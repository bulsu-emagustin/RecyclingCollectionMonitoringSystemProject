 CREATE DATABASE Recycling;
 USE Recycling;

 CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) UNIQUE NOT NULL,
    PasswordHash NVARCHAR(255) NOT NULL,
    UserType NVARCHAR(15) NOT NULL CHECK (UserType IN ('Admin', 'Contributor')),
    FullName NVARCHAR(100) NOT NULL,
    EmployeeID NVARCHAR(20) UNIQUE, 
    Department NVARCHAR(50), 
    DeviceSessionID NVARCHAR(100) UNIQUE, 
    IsActive BIT DEFAULT 1,
    LastLogin DATETIME NULL,
    CreatedAt DATETIME2 DEFAULT GETDATE()
);

SELECT * FROM Users

CREATE TABLE RecyclableMaterials (
    MaterialID INT IDENTITY(1,1) PRIMARY KEY,
    MaterialName NVARCHAR(50) NOT NULL,
    Category NVARCHAR(30) NOT NULL,
    UnitType NVARCHAR(10) NOT NULL CHECK (UnitType IN ('kg', 'pcs', 'liters')),
    IsActive BIT DEFAULT 1
);
SELECT * FROM RecyclableMaterials

CREATE TABLE Locations (
    LocationID INT IDENTITY(1,1) PRIMARY KEY,
    LocationName NVARCHAR(100) NOT NULL,
    LocationCode NVARCHAR(20) UNIQUE NOT NULL,
    Building NVARCHAR(50)
);

SELECT * FROM Locations 

CREATE TABLE Transactions (
    TransactionID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    MaterialID INT NOT NULL,
    LocationID INT NOT NULL,
    Quantity DECIMAL(10,3) NOT NULL CHECK (Quantity > 0),
    CollectionDate DATETIME2 DEFAULT GETDATE(),
    Status NVARCHAR(20) DEFAULT 'Pending' CHECK (Status IN ('Pending', 'Verified', 'Completed', 'Cancelled')),
    Notes NVARCHAR(500),
    CreatedAt DATETIME2 DEFAULT GETDATE(),
    UpdatedAt AS GETDATE()
);
SELECT * FROM Transactions 

ALTER TABLE Transactions 
ADD CONSTRAINT FK_Transactions_Users FOREIGN KEY (UserID) REFERENCES Users(UserID);

ALTER TABLE Transactions 
ADD CONSTRAINT FK_Transactions_Materials FOREIGN KEY (MaterialID) REFERENCES RecyclableMaterials(MaterialID);

ALTER TABLE Transactions 
ADD CONSTRAINT FK_Transactions_Locations FOREIGN KEY (LocationID) REFERENCES Locations(LocationID);

-- Add Filtered Index for BUSINESS RULE 8 (1 active transaction)
CREATE UNIQUE NONCLUSTERED INDEX IX_ActiveTransaction 
ON Transactions (UserID) 
WHERE Status IN ('Pending', 'Verified');

-- Test the table
SELECT * FROM Transactions;



INSERT INTO RecyclableMaterials (MaterialName, Category, UnitType) VALUES
('PET Plastic Bottles', 'Plastic', 'kg'),
('HDPE Plastic', 'Plastic', 'kg'),
('Office Paper', 'Paper', 'kg'),
('Cardboard Boxes', 'Paper', 'kg'),
('Aluminum Cans', 'Metal', 'kg'),
('Steel Scrap', 'Metal', 'kg'),
('Glass Bottles', 'Glass', 'kg'),
('Organic Waste', 'Organic', 'kg'),
('E-Waste (Electronics)', 'E-Waste', 'kg'),
('Textiles/Clothes', 'Textile', 'kg');

SELECT * FROM RecyclableMaterials;


-- Insert Locations
INSERT INTO Locations (LocationName, LocationCode, Building) VALUES
('Main Entrance Bin 1', 'LOC001', 'Main Building'),
('Library Collection Point', 'LOC002', 'Library'),
('Canteen Waste Area', 'LOC003', 'Student Center'),
('Dormitory A Bin', 'LOC004', 'Dormitory'),
('Engineering Dept', 'LOC005', 'Engineering Building'),
('Cafeteria Back', 'LOC006', 'Cafeteria');

SELECT * FROM Locations;


INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('admin1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Admin', 'System Administrator', 'ADMIN001', 'IT Department', 'ADMIN_DEVICE_001');

INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('admin2', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Admin', 'Recycle Coordinator', 'ADMIN002', 'Environmental Services', NULL);

INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('student001', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Contributor', 'Juan Dela Cruz', 'STU2024001', 'BS Information Technology', NULL);

INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('student002', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Contributor', 'Maria Santos', 'STU2024002', 'BS Computer Science', NULL);

INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('faculty001', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Contributor', 'Prof. Ana Reyes', NULL, 'College of Engineering', NULL);

INSERT INTO Users (Username, PasswordHash, UserType, FullName, EmployeeID, Department, DeviceSessionID) 
VALUES ('staff001', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Contributor', 'Mr. Pedro Gomez', NULL, 'Administrative Staff', NULL);

SELECT * FROM Users ORDER BY UserID;



INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (1, 1, 1, 15.500, 'Completed', 'Weekly collection from main gate');

INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (1, 3, 2, 25.250, 'Verified', 'Library paper collection');

INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (3, 1, 1, 2.750, 'Pending', 'Plastic bottles from dorm');

INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (4, 2, 3, 8.500, 'Completed', 'Papers from CS lab');

INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (5, 4, 5, 12.000, 'Pending', 'Cardboard from engineering');

INSERT INTO Transactions (UserID, MaterialID, LocationID, Quantity, Status, Notes) 
VALUES (6, 5, 6, 3.250, 'Completed', 'Cans from cafeteria');

SELECT * FROM Transactions ORDER BY TransactionID;