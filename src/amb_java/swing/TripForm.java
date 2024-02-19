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

public class TripForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField bookingID;
    private JTextField pickupTime;
    private JTextField dropoffTime;
    private JTextField distanceTraveled;
    private JTextField fare;
    private JComboBox<String> paymentStatusComboBox;
   
    private JButton btnNewButton;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TripForm frame = new TripForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public TripForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                          TRIP PAGE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("TRIP FORM");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblBookingID = new JLabel("Booking ID");
        lblBookingID.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblBookingID.setBounds(58, 151, 99, 43);
        contentPane.add(lblBookingID);
        
        JLabel lblPaymentStatus = new JLabel("Payment Status");
        lblPaymentStatus.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblPaymentStatus.setBounds(58, 400, 99, 43);
        contentPane.add(lblPaymentStatus);

        JLabel lblPickupTime = new JLabel("Pickup Time");
        lblPickupTime.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblPickupTime.setBounds(58, 280, 110, 29);
        contentPane.add(lblPickupTime);

        JLabel lblDropoffTime = new JLabel("DropoffTime");
        lblDropoffTime.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblDropoffTime.setBounds(542, 151, 124, 36);
        contentPane.add(lblDropoffTime);
        
        paymentStatusComboBox = new JComboBox<>(new String[]{"Pending", "Canceled", "Rebuilt"});
        paymentStatusComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        paymentStatusComboBox.setBounds(214, 390, 228, 50);
        contentPane.add(paymentStatusComboBox);
       

        bookingID = new JTextField();
        bookingID.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        bookingID.setBounds(214, 151, 228, 50);
        contentPane.add(bookingID);
        bookingID.setColumns(10);

        pickupTime = new JTextField();
        pickupTime.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        pickupTime.setBounds(214, 280, 228, 50);
        contentPane.add(pickupTime);
        pickupTime.setColumns(10);

        dropoffTime = new JTextField();
        dropoffTime.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        dropoffTime.setBounds(707, 151, 228, 50);
        contentPane.add(dropoffTime);
        dropoffTime.setColumns(10);
        
        

        JLabel lbldistanceTraveled = new JLabel("Distance");
        lbldistanceTraveled.setFont(new Font("Georgia", Font.PLAIN, 15));
        lbldistanceTraveled.setBounds(542, 280, 99, 29);
        contentPane.add(lbldistanceTraveled);
        
        JLabel lblFare = new JLabel("Fare");
        lblFare.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblFare.setBounds(542, 400, 99, 29);
        contentPane.add(lblFare);
        
       

        
        distanceTraveled = new JTextField();
        distanceTraveled.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        distanceTraveled.setBounds(707, 280, 228, 50);
        contentPane.add(distanceTraveled);
        distanceTraveled.setColumns(10);
        
        fare = new JTextField();
        fare.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        fare.setBounds(707, 400, 228, 50);
        contentPane.add(fare);
        fare.setColumns(10);
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        pickupTime.setText(formattedDateTime);
        
        bookingID.setBackground(Color.LIGHT_GRAY);
        pickupTime.setBackground(Color.LIGHT_GRAY);
        dropoffTime.setBackground(Color.LIGHT_GRAY);
        distanceTraveled.setBackground(Color.LIGHT_GRAY);
        fare.setBackground(Color.LIGHT_GRAY);
        paymentStatusComboBox.setBackground(Color.LIGHT_GRAY);
        


        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String BookingID = bookingID.getText();
                String PickupTime = pickupTime.getText();
                String DropoffTime = dropoffTime.getText();
                String DistanceTraveled = distanceTraveled.getText();
                String Fare = fare.getText();
                Object PaymentStatus = paymentStatusComboBox.getSelectedItem();
                String msg = "" + BookingID;
                msg += " \n";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO trip (BookingID, PickupTime, DropoffTime, DistanceTraveled, Fare, PaymentStatus) " +
                            "VALUES ('" + BookingID + "','" + PickupTime + "','" + DropoffTime + "','" + DistanceTraveled + "', '" + Fare + "', '" + PaymentStatus + "')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "Failed to place a new Trip");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome Dispatcher , " + msg + "A new Trip is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
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



