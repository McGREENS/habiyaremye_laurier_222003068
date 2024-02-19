package amb_java.swing;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    
    /**
     * @author Laurier HABIYAREMYE - Greens Laurier Master With certified Copyright.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
	 * @author Laurier HABIYAREMYE - Greens Laurier Master With certified Copyright.
	 */
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                               LOGIN  PAGE FOR USER            (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(214, 80, 700, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("LOGIN HERE");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 48));
        lblNewLabel.setBounds(223, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        textField.setBounds(300, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        passwordField.setBounds(300, 286, 281, 68);
        contentPane.add(passwordField);
        
        textField.setBackground(Color.LIGHT_GRAY);
        passwordField.setBackground(Color.LIGHT_GRAY);

        JLabel lblUsername = new JLabel("Email Addres");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Georgia", Font.PLAIN, 31));
        lblUsername.setBounds(80, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Georgia", Font.PLAIN, 31));
        lblPassword.setBounds(80, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(139, 0, 0));
        btnNewButton.setForeground(Color.WHITE); 
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 26));
        btnNewButton.setBounds(310, 450, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String Email = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs",
                        "222003068", "222003068");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from user where email=? and password=?");

                    st.setString(1, Email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHome ah = new UserHome(Email);
                        ah.setTitle("...                                                                           HOME PAGE FOR USER                          (AMBULANCE  BOOKING  SYSTEM )                 ...");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username or Password" + ", Please Verify Credentials");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
        

        JLabel copyrightLabel = new JLabel("\u00a9 2024 Laurier HABIYAREMYE - ABS(Ambulance Booking System) . All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(3, 530, 874, 20); 
        contentPane.add(copyrightLabel);
    }
}