package EDSxADS_Final_Project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class AdminFrame extends JFrame {

    //Viables
    JFrame AdminF;
    JPanel mainheader, header, UnivImageP, customMenuBar, mainPanel, panel1, panel2, RecordP, subheader, dashboardP, plasticP, glassP, paperP, metalP, EWasteP, DepartmentDP;
    JTextField IDfield;
    JLabel UnivIcon, UniversityL, AdminL, TitleL, UnivIDL, DepartmentL, MTypeL, DashT;
    ImageIcon UnivL, ScaledUnivIcon;
    Image Logo;
    JButton AdminButton, RecordButton, RegisterButton, DeleteButton, DashboardButton, SearchButton;
    String[][] Values = {};
    String[] Atributes = {"Student ID", "Department", "Material Type", "Quantity", "Transaction", "Date"};
    JTable Table;
    JScrollPane TableS;
    ImageIcon AMainBack1, AMainBack2;
    JComboBox<String> DTypeBox, MTypeBox;

    public AdminFrame() {
        //Containers
        AdminF = new JFrame("University Recycle Zone");
        mainheader = new JPanel();
        header = new JPanel();
        UnivImageP = new JPanel();
        mainPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        customMenuBar = new JPanel();
        RecordP = new JPanel();
        subheader = new JPanel();
        String[] DType = {"Information Technology", "Civil Engineering", "Business Administration", "Entrepreneurship", "Education", "Medical Technology", "Criminology"};
        String[] MType = {"Plastic", "Glass", "Paper", "Metal", "E-Waste"};
        String[] Atributes = {"Student ID", "Department", "Material Type", "Quantity", "Transaction", "Date"};
        String[][] Values = {};
        dashboardP = new JPanel();
        plasticP = new JPanel();
        glassP = new JPanel();
        paperP = new JPanel();
        metalP = new JPanel();
        EWasteP = new JPanel();
        DepartmentDP = new JPanel();
        DonutChartPanel plasticChart = new DonutChartPanel(40, Color.GREEN, "Plastic");
        DonutChartPanel glassChart = new DonutChartPanel(20, Color.CYAN, "Glass");
        DonutChartPanel paperChart = new DonutChartPanel(15, Color.YELLOW, "Paper");
        DonutChartPanel metalChart = new DonutChartPanel(10, Color.GRAY, "Metal");
        DonutChartPanel ewasteChart = new DonutChartPanel(15, Color.RED, "E-Waste");

        //Background Image for Panel 1
        AMainBack1 = new ImageIcon("Admin_Background.jpg");
        JLabel AMbackground1 = new JLabel(AMainBack1);
        AMbackground1.setLayout(null);
        AMbackground1.setBounds(0, 0, 1500, 625);

        //Background Image for Panel 2
        AMainBack2 = new ImageIcon("Admin_Background.jpg");
        JLabel AMbackground2 = new JLabel(AMainBack2);
        AMbackground2.setLayout(null);
        AMbackground2.setBounds(0, 0, 1500, 625);

        //Layout
        AdminF.setLayout(new BorderLayout());
        mainheader.setLayout(new BorderLayout());
        customMenuBar.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel1.setLayout(null);
        panel2.setLayout(null);
        RecordP.setLayout(new BorderLayout());
        subheader.setLayout(null);
        dashboardP.setLayout(null);
        plasticP.setLayout(new BorderLayout());
        glassP.setLayout(new BorderLayout());
        paperP.setLayout(new BorderLayout());
        metalP.setLayout(new BorderLayout());
        EWasteP.setLayout(new BorderLayout());

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

        //Logout Button
        AdminL = new JLabel("ADMIN");
        AdminL.setBounds(1240, 25, 120, 40);
        AdminL.setFont(new Font("Bodoni MT", Font.BOLD, 30));
        AdminButton = new JButton("Logout");
        AdminButton.setForeground(Color.red);
        AdminButton.setFont(new Font("Arial Black", Font.BOLD, 20));
        AdminButton.setBounds(1350, 20, 120, 50);

        //CardLayout
        CardLayout cl = new CardLayout();
        mainPanel = new JPanel(cl);

        //Custom Menu bar
        customMenuBar.setBackground(Color.LIGHT_GRAY);
        customMenuBar.setPreferredSize(new Dimension(1500, 50));
        RecordButton = new JButton("Records");
        RecordButton.setPreferredSize(new Dimension(100, 40));
        RegisterButton = new JButton("Register");
        RegisterButton.setPreferredSize(new Dimension(100, 40));
        DeleteButton = new JButton("Delete");
        DeleteButton.setPreferredSize(new Dimension(100, 40));
        DashboardButton = new JButton("Dashboard");
        DashboardButton.setPreferredSize(new Dimension(100, 40));

        //Panel 1
        TitleL = new JLabel("Recyling Collection Monitoring System");
        TitleL.setFont(new Font("Bell MT", Font.BOLD, 50));
        TitleL.setBounds(310, 0, 1000, 100);
        RecordP.setBounds(150, 100, 1180, 700);
        subheader.setBackground(Color.white);
        subheader.setPreferredSize(new Dimension(50, 60));
        DepartmentL = new JLabel("Department: ");
        DepartmentL.setBounds(30, 10, 100, 30);
        DTypeBox = new JComboBox<>(DType);
        DTypeBox.setBounds(105, 10, 170, 30);
        MTypeL = new JLabel("Material Type: ");
        MTypeL.setBounds(310, 10, 200, 30);
        MTypeBox = new JComboBox<>(MType);
        MTypeBox.setBounds(395, 10, 100, 30);
        UnivIDL = new JLabel("ID: ");
        UnivIDL.setBounds(860, 10, 30, 30);
        IDfield = new JTextField(50);
        IDfield.setBounds(880, 10, 200, 30);
        SearchButton = new JButton("Search");
        SearchButton.setFont(new Font("Arial", Font.BOLD, 15));
        SearchButton.setBounds(1080, 10, 90, 30);
        Table = new JTable(Values, Atributes);
        Table.getTableHeader().setReorderingAllowed(false);
        TableS = new JScrollPane(Table);

        //Panel 2
        DashT = new JLabel("Dashboard");
        DashT.setFont(new Font("Bell MT", Font.BOLD, 50));
        DashT.setBounds(50, 0, 1000, 100);
        dashboardP.setBackground(Color.white);
        dashboardP.setBounds(50, 100, 1385, 500);
        plasticP.setBounds(10, 35, 250, 200);
        glassP.setBounds(270, 35, 250, 200);
        paperP.setBounds(530, 35, 250, 200);
        metalP.setBounds(140, 270, 250, 200);
        EWasteP.setBounds(400, 270, 250, 200);
        DepartmentDP.setBounds(800, 10, 570, 480);

        //Logout Button Function
        AdminButton.addActionListener(e -> {

            int respone = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respone == JOptionPane.YES_NO_OPTION) {
                new UniversityRecycleZone();
            }
        });
        
        //Register Button Function
        RegisterButton.addActionListener(e -> {
            
        });
        
        //sample data
        String[] departments = {
            "IT", "Engineering", "Business", "Education", "Medical", "Criminology"
        };

        double[] values = {25, 20, 15, 10, 20, 10};

        Color[] colors = {
            Color.BLUE, Color.GREEN, Color.ORANGE,
            Color.MAGENTA, Color.CYAN, Color.PINK
        };

        PieChartPanel pieChart = new PieChartPanel(departments, values, colors);

        DepartmentDP.setLayout(new BorderLayout());
        DepartmentDP.add(pieChart, BorderLayout.CENTER);

        //Adding Components
        AdminF.add(mainheader, BorderLayout.NORTH);
        mainheader.add(header, BorderLayout.NORTH);
        mainheader.add(customMenuBar, BorderLayout.CENTER);
        customMenuBar.add(RecordButton);
        customMenuBar.add(RegisterButton);
        customMenuBar.add(DeleteButton);
        customMenuBar.add(DashboardButton);
        AdminF.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(panel1, "panel1");
        panel1.add(AMbackground1);
        AMbackground1.add(TitleL);
        AMbackground1.add(RecordP);
        RecordP.add(subheader, BorderLayout.NORTH);
        subheader.add(DepartmentL);
        subheader.add(DTypeBox);
        subheader.add(MTypeL);
        subheader.add(MTypeBox);
        subheader.add(UnivIDL);
        subheader.add(IDfield);
        subheader.add(SearchButton);
        RecordP.add(TableS, BorderLayout.CENTER);
        mainPanel.add(panel2, "panel2");
        panel2.add(AMbackground2);
        AMbackground2.add(DashT);
        AMbackground2.add(dashboardP);
        dashboardP.add(plasticP);
        dashboardP.add(glassP);
        dashboardP.add(paperP);
        dashboardP.add(metalP);
        dashboardP.add(EWasteP);
        dashboardP.add(DepartmentDP);
        plasticP.add(plasticChart, BorderLayout.CENTER);
        glassP.add(glassChart, BorderLayout.CENTER);
        paperP.add(paperChart, BorderLayout.CENTER);
        metalP.add(metalChart, BorderLayout.CENTER);
        EWasteP.add(ewasteChart, BorderLayout.CENTER);
        header.add(UnivImageP);
        UnivImageP.add(UnivIcon);
        header.add(UniversityL);
        header.add(AdminL);
        header.add(AdminButton);

        RecordButton.addActionListener(e -> cl.show(mainPanel, "panel1"));
        DashboardButton.addActionListener(e -> cl.show(mainPanel, "panel2"));

        //Frame Settings
        AdminF.setSize(1500, 800);
        AdminF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminF.setLocationRelativeTo(null);
        AdminF.setVisible(true);
    }
}
