<?php
  require 'config.php';
  
  session_start();

  if (!isset($_SESSION["login_data"]))
  {
    session_destroy();
    header('Location: login.php');
    exit();
  } 

  $user_data = $_SESSION["login_data"];

  $userid = $user_data["id"];

  try{
    
    require 'db/action/dbconfig.php';

    $stmt = "SELECT * FROM login WHERE id='$userid'";
    
    $query = $conn->query($stmt);
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    // var_dump($result);

    $user_data = array_shift($result);

    $conn = null;

  } catch(PDOException $e) {

  }

?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="css/styles.css">

  <script>
    window.onload = function() {
      // document.getElementById('heroheader').textContent = `Welcome, ${sessionStorage.getItem('username')}!`;
      // document.getElementById('heroheader').textContent = `Welcome, ${localStorage.getItem('loggedInUser')}!`;
    }
  </script>
</head>
<body>


  <!-- HEADER -->
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Dropdown
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="<?php echo $url; ?>/update.php?id=<?php echo $userid; ?>" tabindex="-1" aria-disabled="true">Update User</a>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
          <button class="btn btn-outline-primary my-2 my-sm-0" type="button" id="logout">Logout</button>
        </div>
        <div class="user-avatar ms-2">
          <a href="#"
            class="d-block"
            data-bs-toggle="popover"
            data-bs-placement="right"
            data-bs-title="User Profile"
            data-bs-content="Some additional user information can go here."
            data-bs-trigger="focus">
            
            <?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname= "Act9";

    $conn = new PDO("mysql:host=$servername;port=3306", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "use ". $dbname;
    $conn->exec($sql);

        $SELECT = "SELECT * FROM login WHERE id='$userid'";
        $result1 = $conn->query($SELECT);
        $user_data = $result1->fetch(PDO::FETCH_ASSOC);
        ?>
            <img src="<?php echo $user_data['img_url']; ?>" alt="User Avatar" class="rounded-circle">
          </a>
        </div>
      </div>
    </nav>
  </header>

  <main class="my-5">
    <div class="container">
      <div class="row">
        <div class="col">
          <h1 id="heroheader">Hi, <?php echo $user_data["first_name"]; ?></h1>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptas, voluptate.</p>
        </div>
      </div>
      <div class="row">
        <?php 


        $SELECT = "SELECT * FROM books";
        $result = $conn->query($SELECT);

        $rows = $result->fetchAll(PDO::FETCH_ASSOC); 


        foreach($rows as $key => $row){
        ?>
        

   
          <div class="col" id="product-data-<?php echo $key+1; ?>">

            <div class="card" style="width: 18rem;">

              <!-- <img src="<?php //echo $product['imgurl']; ?>" class="card-img-top" alt="..."> -->
              <img src="<?php echo $row['image']; ?>" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title"><?php echo $row['title']; ?></h5>
                <p class="card-text"><?php echo $row['excerpt']; ?></p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
                <a href="<?php echo $url; ?>/updatebooks.php?id=<?php echo $row['id']; ?>" class="btn btn-primary">Update Book</a>
              </div>
            </div>
          </div>

        <?php } ?>
        
      </div>
    </div>
  </main>

  
  <!-- FOOTER -->
  <footer>
    <div class="py-5 bg-dark text-white text-center">
    <p class="my-0">&copy; 2023-2024 IT 304 Web Systems and Technologies 1</p>
    </div>
  </footer>

  <!-- <script src="js/main.js"></script> -->
</body>
</html>