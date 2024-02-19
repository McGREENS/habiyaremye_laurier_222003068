package amb_java.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Laurier HABIYAREMYE - Greens Laurier Master
 */


public class AdminHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea notificationTextArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminHome frame = new AdminHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminHome(String adminSes) {
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setTitle("...                                                                           HOME PAGE FOR ADMIN                          (AMBULANCE  BOOKING  SYSTEM )                 ...");
    	 setBounds(180, 50, 1014, 597);
         setResizable(true);
         contentPane = new JPanel();
         contentPane.setBackground(new Color(176, 196, 222));
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         JLabel lblNewUserRegister = new JLabel(" ADMIN DASHBOARD");
         lblNewUserRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 43));
         lblNewUserRegister.setForeground(new Color(0, 0, 128)); 
         lblNewUserRegister.setBounds(362, 18, 350, 80);
         contentPane.add(lblNewUserRegister);
         
         JButton btnViewDetails = new JButton("View Details");
         btnViewDetails.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                     
                     String query = "SELECT * FROM admin WHERE email = ?";
                     PreparedStatement statement = connection.prepareStatement(query);
                     statement.setString(1, adminSes);

                     
                     ResultSet resultSet = statement.executeQuery();

                     
                     StringBuilder adminData = new StringBuilder();
                     while (resultSet.next()) {
                         adminData.append("AdminID: ").append(resultSet.getInt("AdminID")).append("\n");
                         adminData.append("Name: ").append(resultSet.getString("Name")).append("\n");
                         adminData.append("Phone Number : ").append(resultSet.getString("Phonenumber")).append("\n");
                         adminData.append("Email: ").append(resultSet.getString("Email")).append("\n");
                         adminData.append("Role: ").append(resultSet.getString("Role")).append("\n");
                         adminData.append("Password: ").append(resultSet.getString("Password")).append("\n");

                         
                     }

                     
                     JOptionPane.showMessageDialog(AdminHome.this, adminData.toString(), "Admin Details", JOptionPane.INFORMATION_MESSAGE);

                    
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error retrieving admin data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
         btnViewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewDetails.setBounds(214, 410, 228, 50);
         btnViewDetails.setBackground(new Color(0, 0, 128));
         btnViewDetails.setForeground(Color.WHITE ); 
         contentPane.add(btnViewDetails);
         
         
         JButton btnViewTable = new JButton("View Database");
         btnViewTable.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                     
                     DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
                     ResultSet tablesResultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
                     List<String> tableNames = new ArrayList<>();
                     while (tablesResultSet.next()) {
                         String tableName = tablesResultSet.getString("TABLE_NAME");
                         tableNames.add(tableName);
                     }
                     tablesResultSet.close();

                     
                     String selectedTable = (String) JOptionPane.showInputDialog(AdminHome.this, "Select a table to view data:", "Select Table",
                             JOptionPane.QUESTION_MESSAGE, null, tableNames.toArray(), tableNames.get(0));

                     
                     String query = "SELECT * FROM " + selectedTable;
                     PreparedStatement statement = connection.prepareStatement(query);

                     ResultSet resultSet = statement.executeQuery();

                    
                     StringBuilder tableData = new StringBuilder();
                     ResultSetMetaData metaData1 = resultSet.getMetaData();
                     int columnCount = metaData1.getColumnCount();
                     while (resultSet.next()) {
                         for (int i = 1; i <= columnCount; i++) {
                             String columnName = metaData1.getColumnName(i);
                             String columnValue = resultSet.getString(i);
                             tableData.append(columnName).append(": ").append(columnValue).append("\n");
                         }
                         tableData.append("\n");
                     }

                    
                     JTextArea textArea = new JTextArea(20, 40);
                     textArea.setText(tableData.toString());
                     textArea.setEditable(false);
                     JScrollPane scrollPane = new JScrollPane(textArea);
                     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                     JOptionPane.showMessageDialog(AdminHome.this, scrollPane, "Table Data: " + selectedTable, JOptionPane.INFORMATION_MESSAGE);

                     
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error retrieving table data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
         btnViewTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewTable.setBounds(454, 410, 228, 50);
         btnViewTable.setBackground(new Color(0, 0, 128));
         btnViewTable.setForeground(Color.WHITE);
         contentPane.add(btnViewTable);
         
 
     JButton btnDeleteRow = new JButton("Delete Data");
     btnDeleteRow.setFont(new Font("Tahoma", Font.PLAIN, 20));
     btnDeleteRow.setBounds(454, 320, 228, 50);
     btnDeleteRow.setBackground(new Color(0, 0, 128));
     btnDeleteRow.setForeground(Color.WHITE);
     contentPane.add(btnDeleteRow);

     btnDeleteRow.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String tableName = JOptionPane.showInputDialog(AdminHome.this, "Enter the name of the table:");
             String primaryKeyColumn = JOptionPane.showInputDialog(AdminHome.this, "Enter the name of the primary key column:");
             String primaryKeyValue = JOptionPane.showInputDialog(AdminHome.this, "Enter the primary key value of the row to delete:");
             if (tableName != null && primaryKeyColumn != null && primaryKeyValue != null) {
                 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068")) {
                     String query = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumn + " = ?";
                     try (PreparedStatement statement = connection.prepareStatement(query)) {
                         statement.setString(1, primaryKeyValue);
                         int rowsDeleted = statement.executeUpdate();
                         if (rowsDeleted > 0) {
                             JOptionPane.showMessageDialog(AdminHome.this, "Row deleted successfully.");
                         } else {
                             JOptionPane.showMessageDialog(AdminHome.this, "No row found with the specified primary key.", "Error", JOptionPane.ERROR_MESSAGE);
                         }
                     }
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error deleting row: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         }
     });
         
 



         JButton btnNewButton = new JButton("Logout");
         btnNewButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                 if (a == JOptionPane.YES_OPTION) {
                     dispose();
                     AdminLogin obj = new AdminLogin();
                     obj.setTitle("Admin-Login");
                     obj.setVisible(true);
                 }
             }
         });
         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnNewButton.setBounds(454, 480, 228, 50);
         btnNewButton.setBackground(new Color(0, 0, 128));
         btnNewButton.setForeground(Color.WHITE ); 
         contentPane.add(btnNewButton);

         JButton button = new JButton("Change password");
         button.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ChangePassword bo = new ChangePassword(adminSes);
                 bo.setTitle("Change Password");
                 bo.setVisible(true);
             }
         });
         button.setFont(new Font("Tahoma", Font.PLAIN, 20));
         button.setBackground(new Color(0, 0, 128));
         button.setForeground(Color.WHITE); 
         button.setBounds(707, 151, 228, 50);
         contentPane.add(button);
         
         JButton btnPayment = new JButton("Make Payment");
         btnPayment.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 PaymentForm paymentForm = new PaymentForm();
                 paymentForm.setTitle("Make Payment ");
                 paymentForm.setVisible(true);
             }
         });
         btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnPayment.setBackground(new Color(0, 0, 128));
         btnPayment.setForeground(Color.WHITE); 
         btnPayment.setBounds(214, 224, 228, 50);
         contentPane.add(btnPayment);

         
         JButton btnBookingRequest = new JButton("Booking Request");
         btnBookingRequest.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 BookingRequestForm bookingRequestForm = new BookingRequestForm();
                 bookingRequestForm.setTitle("Booking Request Form");
                 bookingRequestForm.setVisible(true);
             }  
         });
         btnBookingRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnBookingRequest.setBackground(new Color(0, 0, 128));
         btnBookingRequest.setForeground(Color.WHITE); 
         btnBookingRequest.setBounds(214, 151, 228, 50);
         contentPane.add(btnBookingRequest);
         
         
         
         JButton btnEmergencyContacts = new JButton("Add Emergency contact");
         btnEmergencyContacts.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 EmergencyContactsForm EmergencyContactsForm = new EmergencyContactsForm();
            	 EmergencyContactsForm.setTitle("Emergency Contacts Form");
            	 EmergencyContactsForm.setVisible(true);
             }
         });
         btnEmergencyContacts.setFont(new Font("Tahoma", Font.PLAIN, 17));
         btnEmergencyContacts.setBackground(new Color(0, 0, 128));
         btnEmergencyContacts.setForeground(Color.WHITE); 
         btnEmergencyContacts.setBounds(707, 224, 228, 50);
         contentPane.add(btnEmergencyContacts);
         
         JButton btnTrip = new JButton("Trip Form");
         btnTrip.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 TripForm TripForm = new TripForm();
                 TripForm.setTitle("Trip Form");
                 TripForm.setVisible(true);
             }
         });
         btnTrip.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnTrip.setBackground(new Color(0, 0, 128));
         btnTrip.setForeground(Color.WHITE); 
         btnTrip.setBounds(214, 320, 228, 50);
         contentPane.add(btnTrip);
         
         JButton btnAmbulanceRegistration = new JButton("Register Ambulance");
         btnAmbulanceRegistration.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 AmbulanceRegistration AmbulanceRegistration = new AmbulanceRegistration();
                 AmbulanceRegistration.setTitle("AmbulanceRegistration");
                 AmbulanceRegistration.setVisible(true);
             }
         });
         btnAmbulanceRegistration.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnAmbulanceRegistration.setBackground(new Color(0, 0, 128));
         btnAmbulanceRegistration.setForeground(Color.WHITE); 
         btnAmbulanceRegistration.setBounds(707, 320, 228, 50);
         contentPane.add(btnAmbulanceRegistration);
         
         JButton btnUpdateData = new JButton("Update Data");
         btnUpdateData.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 AdminUpdateDataForm updateForm = new AdminUpdateDataForm(adminSes);
                 updateForm.setVisible(true);
             }
         });
         btnUpdateData.setFont(new Font("Tahoma", Font.PLAIN, 16));
         btnUpdateData.setBounds(707, 410, 228, 50);
         btnUpdateData.setBackground(new Color(0, 0, 128));
         btnUpdateData.setForeground(Color.WHITE ); 
         contentPane.add(btnUpdateData);
         
         
      //  Copyright notice
         JLabel copyrightLabel = new JLabel("\u00a9 2024 Laurier HABIYAREMYE - ABS(Ambulance Booking System) . All rights reserved.");
         copyrightLabel.setForeground(Color.GRAY);
         copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
         copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
         copyrightLabel.setBounds(10, 540, 974, 20); 
         contentPane.add(copyrightLabel);
    }

    public AdminHome() {
		// TODO Auto-generated constructor stub
	}

	private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
        button.setBackground(new Color(0, 0, 128));
        button.setForeground(Color.WHITE);
        return button;
    }
}
