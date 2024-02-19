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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class PaymentForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tripID;
    private JTextField userID;
    private JComboBox<String> paymentMethodComboBox;
    private JTextField amount;
    private JTextField paymentDateTime;
    private JButton btnNewButton;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PaymentForm frame = new PaymentForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public PaymentForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                          PAYMENT  PAGE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("PAYMENT FORM");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 43));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblTripID = new JLabel("Trip ID");
        lblTripID.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblTripID.setBounds(58, 151, 99, 43);
        contentPane.add(lblTripID);
        
        JLabel lblpaymentDateTime = new JLabel("Date Time");
        lblpaymentDateTime.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblpaymentDateTime.setBounds(58, 400, 99, 43);
        contentPane.add(lblpaymentDateTime);


        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblUserID.setBounds(58, 290, 110, 29);
        contentPane.add(lblUserID);

        JLabel lblPaymentMethod = new JLabel("Payment Method");
        lblPaymentMethod.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblPaymentMethod.setBounds(542, 151, 124, 36);
        contentPane.add(lblPaymentMethod);
        
        paymentDateTime = new JTextField();
        paymentDateTime.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        paymentDateTime.setBounds(214, 400, 228, 50);
        contentPane.add(paymentDateTime);
        paymentDateTime.setColumns(10);
       

        tripID = new JTextField();
        tripID.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        tripID.setBounds(214, 151, 228, 50);
        contentPane.add(tripID);
        tripID.setColumns(10);

        userID = new JTextField();
        userID.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        userID.setBounds(214, 290, 228, 50);
        contentPane.add(userID);
        userID.setColumns(10);

        paymentMethodComboBox = new JComboBox<>(new String[]{"Credit Card", "PayPal", "Bitcoin", "Cheque", "Cash"});
        paymentMethodComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        paymentMethodComboBox.setBounds(707, 151, 228, 50);
        contentPane.add(paymentMethodComboBox);
        
        
        

        JLabel lblamount = new JLabel("Amount");
        lblamount.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblamount.setBounds(542, 290, 99, 29);
        contentPane.add(lblamount);
        
        
       

        
        amount = new JTextField();
        amount.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        amount.setBounds(707, 290, 228, 50);
        contentPane.add(amount);
        amount.setColumns(10);
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        paymentDateTime.setText(formattedDateTime);
        
       
        
        tripID.setBackground(Color.LIGHT_GRAY);
        userID.setBackground(Color.LIGHT_GRAY);
        paymentMethodComboBox.setBackground(Color.LIGHT_GRAY);
        amount.setBackground(Color.LIGHT_GRAY);
        paymentDateTime.setBackground(Color.LIGHT_GRAY);
        


        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String TripID = tripID.getText();
                String UserID = userID.getText();
                Object PaymentMethod = paymentMethodComboBox.getSelectedItem();
                String Amount = amount.getText();
                String PaymentDateTime = paymentDateTime.getText();
                String msg = "" + UserID;
                msg += " 2024";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO payment (TripID, UserID, PaymentMethod, Amount, PaymentDateTime) " +
                            "VALUES ('" + TripID + "','" + UserID + "','" + PaymentMethod + "','" + Amount + "','"+ PaymentDateTime +"')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "PLEASE TRY AGAIN, AN UNEXPECTED ERROR OCCURED");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Thank you USER:   " + msg + " , Your payment was placed successfully, "+"The team will contact you soon.");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        btnNewButton.setBackground(new Color(0, 0, 128));btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnNewButton.setBounds(480, 460, 180, 62);
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




