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

public class FeedbackAndRatingsForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tripID;
    private JTextField userID;
    private JComboBox<String> rating_StarsComboBox;
    private JTextField comments;
    private JTextField feedbackDateTime;
   
    private JButton btnNewButton;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FeedbackAndRatingsForm frame = new FeedbackAndRatingsForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public FeedbackAndRatingsForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                          FEEDBACK AND RATINGS PAGE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("FEEDBACK & RATING FORM");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 22, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblTripID = new JLabel("Trip ID");
        lblTripID.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblTripID.setBounds(58, 151, 99, 43);
        contentPane.add(lblTripID);
        
        JLabel lblfeedbackDateTime = new JLabel("Date Time");
        lblfeedbackDateTime.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
        lblfeedbackDateTime.setBounds(58, 400, 99, 43);
        contentPane.add(lblfeedbackDateTime);


        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblUserID.setBounds(58, 290, 110, 29);
        contentPane.add(lblUserID);

        JLabel lblRating_Stars = new JLabel("Rating_Stars");
        lblRating_Stars.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
        lblRating_Stars.setBounds(542, 151, 124, 36);
        contentPane.add(lblRating_Stars);
        
        feedbackDateTime = new JTextField();
        feedbackDateTime.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        feedbackDateTime.setBounds(214, 400, 228, 50);
        contentPane.add(feedbackDateTime);
        feedbackDateTime.setColumns(10);
       

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

        rating_StarsComboBox = new JComboBox<>(new String[]{"1- Star", "2-Stars", "3-Stars", "4- Stars", "5-Stars"});
        rating_StarsComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        rating_StarsComboBox.setBounds(707, 151, 228, 50);
        contentPane.add(rating_StarsComboBox);
        
        

        JLabel lblcomment = new JLabel("Comment");
        lblcomment.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
        lblcomment.setBounds(542, 290, 99, 29);
        contentPane.add(lblcomment);
        
        
       

        
        comments = new JTextField();
        comments.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        comments.setBounds(707, 290, 228, 50);
        contentPane.add(comments);
        comments.setColumns(10);
        
     
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        feedbackDateTime.setText(formattedDateTime);
        
       
        
        tripID.setBackground(Color.LIGHT_GRAY);
        userID.setBackground(Color.LIGHT_GRAY);
        rating_StarsComboBox.setBackground(Color.LIGHT_GRAY);
        comments.setBackground(Color.LIGHT_GRAY);
        feedbackDateTime.setBackground(Color.LIGHT_GRAY);
        


        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String TripID = tripID.getText();
                String UserID = userID.getText();
                Object Rating_Stars = rating_StarsComboBox.getSelectedObjects();
                String Comments = comments.getText();
                String FeedbackDateTime = feedbackDateTime.getText();
                String msg = "" + UserID;
                msg += " 2024";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO feedbackandratings (TripID, UserID, Rating_Stars, Comments, FeedbackDateTime) " +
                            "VALUES ('" + TripID + "','" + UserID + "','" + Rating_Stars + "','" + Comments + "','"+ FeedbackDateTime +"')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "PLEASE TRY AGAIN, AN UNEXPECTED ERROR OCCURED");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Thank you USER:   " + msg + " , Your feedback was placed successfully, "+"The team will contact you soon.");
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
        
        JLabel copyrightLabel = new JLabel("\u00a9 2024 Laurier HABIYAREMYE - ABS(Ambulance Booking System) . All rights reserved.. All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(10, 530, 974, 20); 
        contentPane.add(copyrightLabel);
    }
}

