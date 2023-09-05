package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    AdminLogin() {
        setTitle("Admin Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(120, 30, 200, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 60, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(120, 60, 200, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 80, 30);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Check admin credentials here
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            
             if (e.getSource() == loginButton) {
            setVisible(false);
            new AdminPanel();
        }
             
             
             
            // Replace this with your actual admin authentication logic
             else if (isValidAdmin(username, password)) {
                // Admin login successful, open the admin panel or perform desired actions
                JOptionPane.showMessageDialog(this, "Admin login successful");
                // Replace this with code to open the admin panel or perform admin tasks
            } else {
                // Admin login failed, show an error message
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }

    // Replace this with your admin authentication logic
    private boolean isValidAdmin(String username, String password) {
        // Simulate admin authentication logic (replace with actual logic)
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLogin());
    }
}
