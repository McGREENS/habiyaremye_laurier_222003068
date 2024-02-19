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

public class AmbulanceRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField vehicleNumber;
    private JComboBox<String> typeComboBox;
    private JTextField capacity;
    private JTextField equipment;
    private JComboBox<String> currentlocationComboBox;
    private JTextField driverName;
    private JComboBox<String> driverCertificationCombobox;
    
    private JButton btnNewButton;
	private JTextField driverContact;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AmbulanceRegistration frame = new AmbulanceRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public AmbulanceRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("...                                                                           REGISTRATION PAGE FOR AMMBULANCE                         (AMBULANCE  BOOKING  SYSTEM )                 ...");
        setBounds(180, 50, 1050, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("ADD  AN AMBULANCE");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 43));
        lblNewAmbulanceRegister.setForeground(new Color(0, 0, 128)); 
        lblNewAmbulanceRegister.setBounds(362, 15, 350, 80);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblVehicleNumber = new JLabel("Vehicle Number");
        lblVehicleNumber.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblVehicleNumber.setBounds(58, 152, 99, 43);
        contentPane.add(lblVehicleNumber);

        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblType.setBounds(58, 243, 110, 29);
        contentPane.add(lblType);

        JLabel lblCapacity = new JLabel("Capacity");
        lblCapacity.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblCapacity.setBounds(58, 324, 124, 36);
        contentPane.add(lblCapacity);
        
        JLabel lblNewLabeldob = new JLabel("Current Location");
        lblNewLabeldob.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblNewLabeldob.setBounds(58, 400, 110, 29);
        contentPane.add(lblNewLabeldob);

        vehicleNumber = new JTextField();
        vehicleNumber.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        vehicleNumber.setBounds(214, 151, 228, 50);
        contentPane.add(vehicleNumber);
        vehicleNumber.setColumns(10);

        typeComboBox = new JComboBox<>(new String[]{"Basic", "Basic +", "Advanced", "Metro"});
        typeComboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        typeComboBox.setBounds(214, 235, 228, 50);
        contentPane.add(typeComboBox);


        capacity = new JTextField();
        capacity.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        capacity.setBounds(214, 320, 228, 50);
        contentPane.add(capacity);
        capacity.setColumns(10);
        
        currentlocationComboBox = new JComboBox<>(new String[]{"Huye", "Kigali", "Rubavu", "Muhanga", "Kayonza"}); 
        currentlocationComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
        currentlocationComboBox.setBounds(214, 400, 228, 50);
        contentPane.add(currentlocationComboBox);



        JLabel lblequipment = new JLabel("Equipments");
        lblequipment.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblequipment.setBounds(542, 151, 99, 29);
        contentPane.add(lblequipment);
        
        
        JLabel lbldriverName = new JLabel("Driver Name");
        lbldriverName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbldriverName.setBounds(542, 243, 99, 29);
        contentPane.add(lbldriverName);

        JLabel lblDriverContact = new JLabel("Driver Contact");
        lblDriverContact.setFont(new Font("Georgia", Font.PLAIN, 15));
        lblDriverContact.setBounds(542, 324, 99, 24);
        contentPane.add(lblDriverContact);

        JLabel lbldriverCertification = new JLabel("Driver Certification");
        lbldriverCertification.setFont(new Font("Georgia", Font.PLAIN, 15));
        lbldriverCertification.setBounds(542, 400, 139, 26);
        contentPane.add(lbldriverCertification);
        
        equipment = new JTextField();
        equipment.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        equipment.setBounds(707, 151, 228, 50);
        contentPane.add(equipment);
        equipment.setColumns(10);
        
        driverName = new JTextField();
        driverName.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        driverName.setBounds(707, 240, 228, 50);
        contentPane.add(driverName);
        driverName.setColumns(10);
        
        driverCertificationCombobox = new JComboBox<>(new String[]{"Certified EMT", "Paramedic Certified", "Pediatric (PALS)", "Basic Life Support (BLS)", "Critical Care Paramedic"}); 
        driverCertificationCombobox.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));
        driverCertificationCombobox.setBounds(707, 400, 228, 50);
        contentPane.add(driverCertificationCombobox);


        driverContact = new JTextField();
        driverContact.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        driverContact.setBounds(707, 320, 228, 50);
        contentPane.add(driverContact);
        
        vehicleNumber.setBackground(Color.LIGHT_GRAY);
        typeComboBox.setBackground(Color.LIGHT_GRAY);
        capacity.setBackground(Color.LIGHT_GRAY);
        equipment.setBackground(Color.LIGHT_GRAY);
        currentlocationComboBox.setBackground(Color.LIGHT_GRAY);
        driverName.setBackground(Color.LIGHT_GRAY);
        driverCertificationCombobox.setBackground(Color.LIGHT_GRAY);
        driverContact.setBackground(Color.LIGHT_GRAY);



        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String VehicleNumber = vehicleNumber.getText();
                String Type = (String) typeComboBox.getSelectedItem(); 
                String Capacity = capacity.getText();
                String Equipment = equipment.getText();
                String currentLocation = (String) currentlocationComboBox.getSelectedItem(); 
                String DriverName = driverName.getText();
                String drivercontact = driverContact.getText();
                Object DriverCertification = driverCertificationCombobox.getSelectedItem();
                

                String msg = "" + VehicleNumber;
                msg += " \n";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs", "222003068", "222003068");

                    String query = "INSERT INTO ambulance (VehicleNumber, Type, Capacity, Equipment, CurrentLocation, DriverName, DriverContact, DriverCertification) " +
                            "VALUES ('" + VehicleNumber + "','" + Type + "','" + Capacity + "','" + Equipment + "','" + currentLocation + "','" + DriverName + "','" + drivercontact + "','" + DriverCertification + "')";


                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnNewButton.setBounds(450, 470, 180, 62);
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
