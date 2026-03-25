package EDSxADS_Final_Project;

//Imports
import java.awt.Color;
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

    //Main Method
    public static void main(String[] args) {
        new WelcomeFrame();
    }

}

//Main Frame
class UniversityRecycleZone extends JFrame {

    //Variables
    JFrame MainF;
    JPanel header;
    JDialog Login, Contribution, History;
    JLabel UniversityL, WelcomeL, UserL, AdminL, LoginL, UsernameL, PasswordL, ContributionL, SIDL, MTypeL, QuantityL;
    JButton AdminButton, AddContriButton, ViewContriButton, ClearButton, EnterButton, CancelButton, SearchButton;
    JTextField Usernamefield, Passworfield, IDfield, Quantityfield;
    JComboBox<String> MTypeBox;
    JTable Table;
    JScrollPane Scroll;

    public UniversityRecycleZone() {

        //Containers
        MainF = new JFrame("University Recycle Zone");
        header = new JPanel();
        Login = new JDialog(this, "Admin Login", true);
        Contribution = new JDialog(this, "Contribution Form", true);
        History = new JDialog(this, "User History", true);
        String[] Mtype = {"Plastic", "Glass", "Paper", "Metal", "E-Waste"};
        String[] Atributes = {"Student ID", "Department", "Material Type", "Quantity", "Date"};
        String[][] Values = {};

        //Background Image
        ImageIcon icon = new ImageIcon("Main_Background.jpg");
        JLabel Mbackground = new JLabel(icon);
        Mbackground.setLayout(null);
        MainF.setContentPane(Mbackground);

        //Header
        header.setBackground(Color.green);
        header.setBounds(0, 0, 1500, 50);
        header.setLayout(null);
        UniversityL = new JLabel("University Recycle Zone");
        UniversityL.setBounds(10, 0, 500, 50);
        UniversityL.setFont(new Font("Arial Black", Font.BOLD, 30));
        AdminL = new JLabel("Admin");
        AdminL.setBounds(1260, 5, 120, 40);
        AdminL.setFont(new Font("Arial", Font.BOLD, 30));
        AdminButton = new JButton("Login");
        AdminButton.setFont(new Font("Arial", Font.BOLD, 20));
        AdminButton.setBounds(1360, 5, 120, 40);
        new LoginFunction();

        //Title
        WelcomeL = new JLabel("WELCOME");
        WelcomeL.setBounds(450, 65, 600, 90);
        WelcomeL.setFont(new Font("Arial Black", Font.BOLD, 100));
        UserL = new JLabel("USER");
        UserL.setBounds(615, 175, 500, 80);
        UserL.setFont(new Font("Arial Black", Font.BOLD, 80));

        //JTable
        //Add Contribution Button
        ImageIcon icon1 = new ImageIcon("RecycleButton.png");
        Image img1 = icon1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(img1);
        AddContriButton = new JButton(scaledIcon1);
        AddContriButton.setBounds(300, 290, 400, 400);

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
        ImageIcon icon2 = new ImageIcon("HistoryButton.png");
        Image img2 = icon2.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(img2);
        ViewContriButton = new JButton(scaledIcon2);
        ViewContriButton.setBounds(800, 290, 400, 400);

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
            Scroll = new JScrollPane(Table);
            Scroll.setBounds(10, 60, 700, 300);

            //Adding Components
            History.add(Scroll);
            History.add(SIDL);
            History.add(IDfield);
            History.add(SearchButton);

            History.setVisible(true);
        });

        //Adding Components
        MainF.add(header);
        header.add(UniversityL);
        header.add(AdminL);
        header.add(AdminButton);
        MainF.add(WelcomeL);
        MainF.add(UserL);
        MainF.add(AddContriButton);
        MainF.add(ViewContriButton);

        //Frame Settings
        MainF.setSize(1500, 800);
        MainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainF.setLocationRelativeTo(null);
        MainF.setLayout(null);
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
                Usernamefield.setBounds(150, 60, 250, 30);
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
                Passworfield.setBounds(150, 110, 250, 30);
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
