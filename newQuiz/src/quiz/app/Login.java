//Java Swing and AWT are two libraries in Java that allow developers to create graphical user interfaces (GUIs) for desktop applications.// This line specifies the package name for this code. The package name is `quiz.app`.//The package name is a way of organizing Java code into logical groups. In this case, the code is part of a project called quiz.app.package quiz.app;// This line imports the `javax.swing` package, which contains classes for creating graphical user interfaces (GUIs).import javax.swing.*;// This line imports the `java.awt` package, which contains classes for basic graphical components, such as windows, buttons, and text fields.import java.awt.*;// This line imports the `java.awt.event` package, which contains classes for events, such as mouse clicks and button presses.import java.awt.event.ActionEvent;import java.awt.event.ActionListener;public class Login extends JFrame implements ActionListener {    JTextField text;    JButton Next, back, admin;    Login() {        // Set the JFrame title        setTitle("Login");        // Set the JFrame size        setSize(1000, 500);        // Specify what happens when the close button is clicked        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // Center the JFrame on the screen        setLocation(200, 150);        // Create a custom JPanel with a gradient background        JPanel contentPanel = new JPanel() {            @Override            protected void paintComponent(Graphics g) {                super.paintComponent(g);                // Define your gradient colors and direction                                // Using hexadecimal values to define colors                int blueHex = 0x0000FF; // Blue in hexadecimal (R=0, G=0, B=255)                int cyanHex = 0x00FFFF; // Cyan in hexadecimal (R=0, G=255, B=255)                // Creating Color objects using hexadecimal values                Color blueColor = new Color(blueHex);                Color cyanColor = new Color(cyanHex);                // Creating a GradientPaint using Color objects                GradientPaint gradient = new GradientPaint(0, 0, blueColor, getWidth(), getHeight(), cyanColor);                Graphics2D g2d = (Graphics2D) g;                g2d.setPaint(gradient);                g2d.fillRect(0, 0, getWidth(), getHeight());            }        };        // Set the layout manager of the contentPanel        contentPanel.setLayout(null);        // Set the content pane of the JFrame to our custom panel        setContentPane(contentPanel);        // Load an image for the login screen        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));        Image i = i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);        ImageIcon i2 = new ImageIcon(i);        JLabel image = new JLabel(i2);        image.setBounds(450, 0, 550, 500);        add(image);        // Create and configure the "CODE QUIZ" heading        JLabel heading = new JLabel("CODE QUIZ");        heading.setBounds(100, 30, 300, 45);        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));        heading.setForeground(Color.white);        add(heading);        // Create and configure the "Enter Your Name" label        JLabel name = new JLabel("Enter Your Name");        name.setBounds(130, 150, 300, 20);        name.setFont(new Font("Times New Roman", Font.BOLD, 30));        name.setForeground(Color.white);        add(name);        // Create and configure the text field for entering the name        text = new JTextField();        text.setBounds(80, 200, 300, 25);        text.setFont(new Font("Times New Roman", Font.BOLD, 18));        add(text);        // Create and configure the "Next" button        Next = new JButton("Next");        Next.setBounds(80, 270, 150, 40);        Next.setFont(new Font("Times New Roman", Font.BOLD, 24));        Next.setBackground(Color.blue);        Next.setForeground(Color.WHITE);        Next.addActionListener(this);        add(Next);        // Create and configure the "Exit" button        back = new JButton("Exit");        back.setBounds(250, 270, 150, 40);        back.setFont(new Font("Times New Roman", Font.BOLD, 24));        back.setBackground(Color.blue);        back.setForeground(Color.WHITE);        back.addActionListener(this);        add(back);        // Create and configure the "Admin Login" button        admin = new JButton("Admin Login");        admin.setBounds(160, 360, 150, 40);        admin.setFont(new Font("Times New Roman", Font.BOLD, 20));        admin.setBackground(Color.black);        admin.setForeground(Color.WHITE);        admin.setFocusPainted(false);        admin.addActionListener(this);        add(admin);        // Make the JFrame undecorated (removes title bar)        setUndecorated(true);        // Make the JFrame visible        setVisible(true);    }    @Override    // ActionListener implementation for handling button clicks    public void actionPerformed(ActionEvent e) {        if (e.getSource() == Next) {            // Get the name entered by the user            String name = text.getText();            // Hide the login screen and open the Rules screen            setVisible(false);            new Rules(name);        } else if (e.getSource() == back) {            // Exit the application with exit status 50 when the "Exit" button is clicked            System.exit(50);        } else if (e.getSource() == admin) {            // Hide the login screen and open the Admin Login screen            setVisible(false);            new AdminLogin();        }    }    public static void main(String[] args) {        // Create an instance of the Login class to start the application        new Login();    }}