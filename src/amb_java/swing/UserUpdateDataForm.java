package amb_java.swing;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateDataForm extends JFrame {

	
 
	private static final long serialVersionUID = 1L;
	private JComboBox<String> columnComboBox;
    private JTextField valueTextField;
    private JButton updateButton;

    public UserUpdateDataForm(String email) {
        setTitle("Update User Data");
        setSize(400, 200);
        setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        JLabel columnLabel = new JLabel("Select Column:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(columnLabel, gbc);

        String[] columns = {"Name", "Email", "Address", "Date of Birth", "Gender", "Insurance", "Password"};
        columnComboBox = new JComboBox<>(columns);
        columnComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        columnComboBox.setBounds(214, 235, 228, 50);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(columnComboBox, gbc);

        
        JLabel valueLabel = new JLabel("Enter New Value:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(valueLabel, gbc);

        valueTextField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(valueTextField, gbc);

        
        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String column = (String) columnComboBox.getSelectedItem();
                String value = valueTextField.getText();
                updateUserData(email, column, value);
                dispose();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(updateButton, gbc);

        add(panel);
    }

    private void updateUserData(String email, String column, String value) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/habiyaremye_laurier_abs",
                    "222003068", "222003068");

            String query = "UPDATE user SET " + column + " = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, value);
            statement.setString(2, email);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "User data updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update user data.");
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating user data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
