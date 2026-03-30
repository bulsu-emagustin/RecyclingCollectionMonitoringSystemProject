package EDSxADS_Final_Project;

//Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RecyclingCollectionMonitoringSystem {

    //Main Method (DIto palagi magrun ng code)
    public static void main(String[] args) {
        new WelcomeFrame();
    }
}

//Main Frame
class UniversityRecycleZone extends JFrame {

    //Variables
    JFrame MainF;
    JPanel header, UnivImageP, leftPanel, UserImageP, MainP, ColumnChart;
    JDialog Login, Contribution, History;
    JLabel UnivIcon, UserIcon, UniversityL, UserL, AdminL, LoginL, UsernameL, PasswordL, ContributionL, SIDL, MTypeL, QuantityL, StudentCL;
    JButton AdminButton, AddContriButton, ViewContriButton, ClearButton, EnterButton, CancelButton, SearchButton;
    JTextField Usernamefield, Passworfield, IDfield, Quantityfield;
    JComboBox<String> MTypeBox;
    JTable Table;
    JScrollPane TableS;
    ImageIcon MainBack, UnivL, UserIconL, ScaledUnivIcon, ScaledUserIcon;
    Image Logo, Logo2;

    public UniversityRecycleZone() {

        //Containers
        MainF = new JFrame("University Recycle Zone");
        header = new JPanel();
        leftPanel = new JPanel();
        UnivImageP = new JPanel();
        UserImageP = new JPanel();
        Login = new JDialog(this, "Admin Login", true);
        Contribution = new JDialog(this, "Contribution Form", true);
        History = new JDialog(this, "User History", true);
        String[] Mtype = {"Plastic", "Glass", "Paper", "Metal", "E-Waste"};
        String[] Atributes = {"Student ID", "Department", "Material Type", "Quantity", "Transaction", "Date"};
        String[][] Values = {};
        MainP = new JPanel(); 
        ColumnChart = new WeeklyColumnChart();

        //Background Image
        MainBack = new ImageIcon("Main_Background.jpg");
        JLabel Mbackground = new JLabel(MainBack);
        Mbackground.setLayout(null);
        MainF.setContentPane(Mbackground);

        //Layout Config
        MainF.setLayout(new BorderLayout());

        //Header Config
        header.setBackground(new Color(34, 139, 34));
        header.setPreferredSize(new Dimension(1500, 90));
        header.setLayout(null);
        UnivImageP.setBounds(10, 10, 80, 70);
        UnivImageP.setLayout(null);
        UnivL = new ImageIcon("URZLogo.png");
        Logo = UnivL.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        ScaledUnivIcon = new ImageIcon(Logo);
        UnivIcon = new JLabel(ScaledUnivIcon);
        UnivIcon.setBounds(0, 0, 80, 70);
        UniversityL = new JLabel("University Recycle Zone");
        UniversityL.setBounds(61, 20, 500, 50);
        UniversityL.setFont(new Font("Arial Black", Font.BOLD, 30));

        //Login button
        AdminL = new JLabel("ADMIN");
        AdminL.setBounds(1240, 25, 120, 40);
        AdminL.setFont(new Font("Bodoni MT", Font.BOLD, 30));
        AdminButton = new JButton("Login");
        AdminButton.setForeground(Color.red);
        AdminButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        AdminButton.setBounds(1350, 20, 120, 50); 
        new LoginFunction();

        //Left panel Config
        leftPanel.setBackground(new Color(72, 209, 204));
        leftPanel.setPreferredSize(new Dimension(400, 800));
        leftPanel.setLayout(null);
        UserImageP.setBounds(50, 50, 300, 250);
        UserImageP.setLayout(null);
        UserIconL = new ImageIcon("UserIcon.png");
        Logo2 = UserIconL.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        ScaledUserIcon = new ImageIcon(Logo2);
        UserIcon = new JLabel(ScaledUserIcon);
        UserIcon.setBounds(0, 0, 300, 250);
        UserL = new JLabel("USER");
        UserL.setFont(new Font("Arial", Font.BOLD, 30));
        UserL.setBounds(160, 310, 100, 50);
        AddContriButton = new JButton("Add Contribution");
        AddContriButton.setBackground(Color.LIGHT_GRAY);
        AddContriButton.setFont(new Font("Arial", Font.BOLD, 30));
        AddContriButton.setBounds(50, 390, 300, 100);
        ViewContriButton = new JButton("View Contribution");
        ViewContriButton.setBackground(Color.LIGHT_GRAY);
        ViewContriButton.setFont(new Font("Arial", Font.BOLD, 30));
        ViewContriButton.setBounds(50, 530, 300, 100);

        //Add Contribution Dialog
        AddContriButton.addActionListener(e -> {
            Contribution.setSize(500, 350);
            Contribution.setLocationRelativeTo(this);
            Contribution.setLayout(null);
            ContributionL = new JLabel("CONTRIBUTION");
            ContributionL.setBounds(130, 10, 300, 50);
            ContributionL.setFont(new Font("Arial Black", Font.BOLD, 25));

            SIDL = new JLabel("School ID: ");
            SIDL.setBounds(63, 40, 70, 80);
            IDfield = new JTextField(100);
            IDfield.setBounds(130, 65, 300, 30);
            MTypeL = new JLabel("Material Type: ");
            MTypeL.setBounds(40, 93, 100, 80);
            MTypeBox = new JComboBox<>(Mtype);
            MTypeBox.setBounds(130, 120, 300, 30);
            QuantityL = new JLabel("Quantity: ");
            QuantityL.setBounds(70, 150, 70, 80);
            Quantityfield = new JTextField(100);
            Quantityfield.setBounds(130, 175, 300, 30);
            EnterButton = new JButton("Enter");
            EnterButton.setBounds(90, 230, 130, 50);
            EnterButton.setFont(new Font("Arial", Font.BOLD, 25));
            CancelButton = new JButton("Cancel");
            CancelButton.setBounds(270, 230, 130, 50);
            CancelButton.setFont(new Font("Arial", Font.BOLD, 25));

            //Adding Components
            Contribution.add(SIDL);
            Contribution.add(ContributionL);
            Contribution.add(IDfield);
            Contribution.add(MTypeL);
            Contribution.add(MTypeBox);
            Contribution.add(QuantityL);
            Contribution.add(Quantityfield);
            Contribution.add(EnterButton);
            Contribution.add(CancelButton);

            //Listeners for Contribution Dialog
            CancelButton.addActionListener(ev -> Contribution.dispose());

            //Visibility (Importanteng palaging nasa pinaka dulo ito)
            Contribution.setVisible(true);
        });

        //View Contribution
        ViewContriButton.addActionListener(e -> {
            History.setSize(733, 400);
            History.setLocationRelativeTo(this);
            History.setLayout(null);
            SIDL = new JLabel("School ID: ");
            SIDL.setBounds(300, 13, 100, 35);
            IDfield = new JTextField(50);
            IDfield.setBounds(360, 13, 250, 35);
            SearchButton = new JButton("Search");
            SearchButton.setBounds(609, 13, 100, 35);
            Table = new JTable(Values, Atributes);
            Table.getTableHeader().setReorderingAllowed(false);
            TableS = new JScrollPane(Table);
            TableS.setBounds(10, 60, 700, 300);

            //Adding Components
            History.add(TableS);
            History.add(SIDL);
            History.add(IDfield);
            History.add(SearchButton);

            History.setVisible(true);
        });
        
        //Main Panel
        MainP.setBackground(Color.WHITE);
        MainP.setPreferredSize(new Dimension(1, 1));
        MainP.setLayout(null);    
        StudentCL = new JLabel("Students Weekly");
        StudentCL.setFont(new Font("Arial Black", Font.BOLD, 60));
        StudentCL.setBounds(270, 20, 700, 80);
        ContributionL = new JLabel("Contribution");
        ContributionL.setFont(new Font("Arial Black", Font.BOLD, 60));
        ContributionL.setBounds(350, 100, 700, 80);
        ColumnChart.setBounds(30, 200, 1030, 460);

        //Adding Components
        MainF.add(header, BorderLayout.NORTH);
        header.add(UnivImageP);
        UnivImageP.add(UnivIcon);
        header.add(UniversityL);
        header.add(AdminL);
        header.add(AdminButton);
        MainF.add(leftPanel, BorderLayout.WEST);
        leftPanel.add(UserImageP);
        UserImageP.add(UserIcon);
        leftPanel.add(AddContriButton);
        leftPanel.add(UserL);
        leftPanel.add(ViewContriButton);
        MainF.add(MainP, BorderLayout.CENTER);
        MainP.add(StudentCL);
        MainP.add(ContributionL);
        MainP.add(ColumnChart);

        //Frame Settings
        MainF.setSize(1500, 800);
        MainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainF.setLocationRelativeTo(null);
        MainF.setVisible(true);
    }

    //Class for Admin Login
    class LoginFunction extends JFrame {

        public LoginFunction() {
            AdminButton.addActionListener(e -> {

                //Dialog Settings
                Login.setSize(550, 300);
                Login.setLocationRelativeTo(this);
                Login.setLayout(null);
                LoginL = new JLabel("LOGIN");
                LoginL.setFont(new Font("Arial Black", Font.BOLD, 25));
                LoginL.setBounds(220, 10, 150, 40);
                Login.add(LoginL);

                //Username
                UsernameL = new JLabel("Username:");
                UsernameL.setBounds(50, 60, 100, 25);
                Login.add(UsernameL);
                Usernamefield = new JTextField();
                Usernamefield.setBounds(115, 60, 285, 30);
                Login.add(Usernamefield);

                //Clear Username Button
                JButton clearUser = new JButton("Clear");
                clearUser.setBounds(410, 60, 80, 30);
                Login.add(clearUser);

                //Password Label
                PasswordL = new JLabel("Password:");
                PasswordL.setBounds(50, 110, 100, 25);
                Login.add(PasswordL);

                //Password Field
                Passworfield = new JTextField();
                Passworfield.setBounds(115, 110, 285, 30);
                Login.add(Passworfield);

                //Clear Password Button
                ClearButton = new JButton("Clear");
                ClearButton.setBounds(410, 110, 80, 30);
                Login.add(ClearButton);

                //Enter Button
                EnterButton = new JButton("Enter");
                EnterButton.setBounds(150, 180, 100, 40);
                EnterButton.addActionListener(ev -> {
                    new AdminFrame();
                    Login.dispose();
                    MainF.dispose();
                });
                Login.add(EnterButton);

                //Cancel Button
                CancelButton = new JButton("Cancel");
                CancelButton.setBounds(270, 180, 100, 40);
                Login.add(CancelButton);

                //Logic
                clearUser.addActionListener(ev -> Usernamefield.setText(""));
                ClearButton.addActionListener(ev -> Passworfield.setText(""));
                CancelButton.addActionListener(ev -> Login.dispose());
                CancelButton.addActionListener(ev -> Contribution.dispose());

                Login.setVisible(true);
            });
        }

    }
}
