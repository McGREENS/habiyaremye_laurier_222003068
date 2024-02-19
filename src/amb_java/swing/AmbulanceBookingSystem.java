package amb_java.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmbulanceBookingSystem extends JFrame {
    /**
	 * @author Laurier HABIYAREMYE - Greens Laurier Master With certified Copyright.
	 */
	private static final long serialVersionUID = 1L;

	public AmbulanceBookingSystem() {
        setTitle(".   (ABS) AMBULANCE BOOKING SYSTEM - MAIN PAGE");
        setBounds(180, 50, 600, 597);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBackground(new Color(176, 196, 222));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        
        JButton userLoginButton = new JButton("User Login");
        userLoginButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        userLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUserLoginForm();
            }
           
        });
        
        JButton userRegistrationButton = new JButton("User Registration");
        userRegistrationButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        userRegistrationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUserRegistrationForm();
            }
        });
        
        JButton adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAdminLoginForm();
            }
        });
       
        
        JButton adminRegistrationButton = new JButton("Admin Registration");
        adminRegistrationButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        adminRegistrationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAdminRegistrationForm();
            }
        });
        
        panel.add(userLoginButton);
        panel.add(userRegistrationButton);
        panel.add(adminLoginButton);
        panel.add(adminRegistrationButton);
        
        add(panel);
        setLocationRelativeTo(null); 
    }
    
    private void openUserLoginForm() {
        JOptionPane.showMessageDialog(this, "Are you sure you want to login as a user?");
            UserLogin userLoginForm = new UserLogin();
            userLoginForm.setVisible(true);
        }
    
    
    private void openUserRegistrationForm() {

        JOptionPane.showMessageDialog(this, "Get started by creating an account");
        UserRegistration userRegistrationForm = new UserRegistration();
        userRegistrationForm.setVisible(true);
        }
    
    
    private void openAdminLoginForm() {

        JOptionPane.showMessageDialog(this, "Are you sure you want login as an Admin ?");
        AdminLogin adminLoginForm = new AdminLogin();
        adminLoginForm.setVisible(true);
    }
    
    private void openAdminRegistrationForm() {
        JOptionPane.showMessageDialog(this, "SignUp as an Admnistrator");
      
        AdminRegistration adminRegistrationForm = new AdminRegistration();
        adminRegistrationForm.setVisible(true);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmbulanceBookingSystem().setVisible(true);
            }
        });
    }
}
