package amb_java.swing;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Laurier HABIYAREMYE - Greens Laurier Master With certified Copyright.
 */
public class EmergencyContactsForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userID;
    private JTextField contactName;
    private JComboBox<String> relationshipComboBox;
    private JTextField contactPhoneNumber;
   
    private JButton btnNewButton;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmergencyContactsForm frame = new EmergencyContactsForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public EmergencyContactsForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                          EMERGENCY CONTACTS PAGE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("EMERGENCY CONTACTS FORM");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 35, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setFont(new Font("Georgia", Font.BOLD, 18));
        lblUserID.setBounds(58, 151, 99, 43);
        contentPane.add(lblUserID);

        JLabel lblContactName = new JLabel("Name");
        lblContactName.setFont(new Font("Georgia", Font.BOLD, 18));
        lblContactName.setBounds(58, 320, 110, 29);
        contentPane.add(lblContactName);

        JLabel lblRelationship = new JLabel("Relationship");
        lblRelationship.setFont(new Font("Georgia", Font.BOLD, 18));
        lblRelationship.setBounds(542, 151, 124, 36);
        contentPane.add(lblRelationship);
        
       

        userID = new JTextField();
        userID.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        userID.setBounds(214, 151, 228, 50);
        contentPane.add(userID);
        userID.setColumns(10);

        contactName = new JTextField();
        contactName.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        contactName.setBounds(214, 320, 228, 50);
        contentPane.add(contactName);
        contactName.setColumns(10);

        relationshipComboBox = new JComboBox<>(new String[]{"Spouse or Partner", "Children", "Siblings", "Lawyer or legal representative", "Employers or Colleagues"});
        relationshipComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        relationshipComboBox.setBounds(707, 151, 228, 50);
        contentPane.add(relationshipComboBox);
        
        

        JLabel lblcontactPhoneNumber = new JLabel("Phone Number");
        lblcontactPhoneNumber.setFont(new Font("Georgia", Font.BOLD, 18));
        lblcontactPhoneNumber.setBounds(542, 320, 99, 29);
        contentPane.add(lblcontactPhoneNumber);
        
        
       

        
        contactPhoneNumber = new JTextField();
        contactPhoneNumber.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        contactPhoneNumber.setBounds(707, 320, 228, 50);
        contentPane.add(contactPhoneNumber);
        contactPhoneNumber.setColumns(10);
       
        
        userID.setBackground(Color.LIGHT_GRAY);
        contactName.setBackground(Color.LIGHT_GRAY);
        relationshipComboBox.setBackground(Color.LIGHT_GRAY);
        contactPhoneNumber.setBackground(Color.LIGHT_GRAY);
        


        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String UserID = userID.getText();
                String ContactName = contactName.getText();
                Object Relationship = relationshipComboBox.getSelectedItem();
                String ContactPhoneNumber = contactPhoneNumber.getText();
                String msg = "" + UserID;
                msg += " 2024";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO emergencycontacts (UserID, ContactName, Relationship, ContactPhoneNumber) " +
                            "VALUES ('" + UserID + "','" + ContactName + "','" + Relationship + "','" + ContactPhoneNumber + "')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "An Error occured during submission");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Emergency contact for USER " + msg + " was Successfully submitted");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnNewButton.setBounds(480, 430, 180, 62);
        btnNewButton.setBackground(new Color(139, 0, 0));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);
        
        JLabel copyrightLabel = new JLabel("\u00a9 2024 Laurier HABIYAREMYE - ABS(Ambulance Booking System) . All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(10, 530, 974, 20); 
        contentPane.add(copyrightLabel);
    }
}

