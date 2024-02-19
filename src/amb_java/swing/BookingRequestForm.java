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
public class BookingRequestForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userId;
    private JComboBox<String> pickupLocationComboBox;
    private JComboBox<String> destinationComboBox;
    private JComboBox<String> hospitalNameComboBox;
    private JComboBox<String> priorityLevelComboBox;
    private JComboBox<String> reasonComboBox;
    private JButton btnNewButton;
	private JTextField additionalNotes;
	private JTextField requestedTime;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookingRequestForm frame = new BookingRequestForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public BookingRequestForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                           BOOKING REQUEST PAGE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("BOOK AMBULANCE");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 42));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblUserId = new JLabel("User ID");
        lblUserId.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblUserId.setBounds(58, 152, 99, 43);
        contentPane.add(lblUserId);

        JLabel lblPickupLocation = new JLabel("Pickup Location");
        lblPickupLocation.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblPickupLocation.setBounds(58, 243, 110, 29);
        contentPane.add(lblPickupLocation);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblDestination.setBounds(58, 324, 124, 36);
        contentPane.add(lblDestination);
        
        JLabel lblNewLabeldob = new JLabel("Priority Level");
        lblNewLabeldob.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblNewLabeldob.setBounds(58, 400, 110, 29);
        contentPane.add(lblNewLabeldob);

        userId = new JTextField();
        userId.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        userId.setBounds(214, 151, 228, 50);
        contentPane.add(userId);
        userId.setColumns(10);

        pickupLocationComboBox = new JComboBox<>(new String[]{"Huye", "Kigali", "Rubavu", "Muhanga", "Kayonza"});
        pickupLocationComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        pickupLocationComboBox.setBounds(214, 235, 228, 50);
        contentPane.add(pickupLocationComboBox);

        destinationComboBox = new JComboBox<>(new String[]{"Huye", "Kigali", "Rubavu", "Muhanga", "Kayonza"});
        destinationComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        destinationComboBox.setBounds(214, 320, 228, 50);
        contentPane.add(destinationComboBox);
        
        priorityLevelComboBox = new JComboBox<>(new String[]{"Low", "Medium", "Medium +", "High"});
        priorityLevelComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        priorityLevelComboBox.setBounds(214, 400, 228, 50);
        contentPane.add(priorityLevelComboBox);


        JLabel lblhospitalName = new JLabel("HospitalName");
        lblhospitalName.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblhospitalName.setBounds(542, 151, 99, 29);
        contentPane.add(lblhospitalName);
        
        
        JLabel lblreason = new JLabel("Reason");
        lblreason.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblreason.setBounds(542, 243, 99, 29);
        contentPane.add(lblreason);

        JLabel lblAdditionalNotes = new JLabel("Additional Notes");
        lblAdditionalNotes.setFont(new Font("Georgia", Font.PLAIN, 13));
        lblAdditionalNotes.setBounds(542, 324, 99, 24);
        contentPane.add(lblAdditionalNotes);

        
        hospitalNameComboBox = new JComboBox<>(new String[]{"CHUB", "CHUK", "Laurier Int Hospital", "KABGAYI Hospital", "Kayonza Lakes Clinics"});
        hospitalNameComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        hospitalNameComboBox.setBounds(707, 151, 228, 50);
        contentPane.add(hospitalNameComboBox);
        
        reasonComboBox = new JComboBox<>(new String[]{"Medical Emergencies", "Accidents and Injuries", "MetrPregnancy-Related", "Serious Illnesses", "Psychiatric Emergencies", "Inter-Hospital Transfers"});
        reasonComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        reasonComboBox.setBounds(707, 240, 228, 50);
        contentPane.add(reasonComboBox);

        additionalNotes = new JTextField();
        additionalNotes.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        additionalNotes.setBounds(707, 320, 228, 50);
        contentPane.add(additionalNotes);
        
        JLabel lblRequestedTime = new JLabel("Time of Request");
        lblRequestedTime.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblRequestedTime.setBounds(542, 400, 99, 24);
        contentPane.add(lblRequestedTime);
        
        requestedTime = new JTextField();
        requestedTime.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        requestedTime.setBounds(707, 400, 228, 50);
        contentPane.add(requestedTime);
        requestedTime.setColumns(10);
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        requestedTime.setText(formattedDateTime);
       
        
        userId.setBackground(Color.LIGHT_GRAY);
        pickupLocationComboBox.setBackground(Color.LIGHT_GRAY);
        destinationComboBox.setBackground(Color.LIGHT_GRAY);
        hospitalNameComboBox.setBackground(Color.LIGHT_GRAY);
        priorityLevelComboBox.setBackground(Color.LIGHT_GRAY);
        reasonComboBox.setBackground(Color.LIGHT_GRAY);
        additionalNotes.setBackground(Color.LIGHT_GRAY);
        requestedTime.setBackground(Color.LIGHT_GRAY);



        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String UserId = userId.getText();
                String PickupLocation = (String)  pickupLocationComboBox.getSelectedItem(); 
                Object Destination = destinationComboBox.getSelectedItem(); 
                Object HospitalName = hospitalNameComboBox.getSelectedItem(); 
                Object PriorityLevel = hospitalNameComboBox.getSelectedItem(); 
                String RequestedTime = requestedTime.getText();
                Object Reason = hospitalNameComboBox.getSelectedItem(); 
                String additionalnotes = additionalNotes.getText();
                String msg = "" + UserId;
                msg += " \n";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO bookingRequest(UserId, PickupLocation, Destination, HospitalName, RequestedTime ,PriorityLevel, Reason, AdditionalNotes) " +
                            "VALUES ('" + UserId + "','" + PickupLocation + "','" + Destination + "','" + HospitalName + "', '"+ RequestedTime +"','" + PriorityLevel + "','" + Reason + "','" + additionalnotes + "')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome user , " + msg + "Your Request is sucessfully created");
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
        copyrightLabel.setBounds(10, 540, 974, 20); 
        contentPane.add(copyrightLabel);
    }
}



