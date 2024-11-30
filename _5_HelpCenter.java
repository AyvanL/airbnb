package main;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class _5_HelpCenter extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextArea description;
    private JComboBox<String> roomDropDown;
    private JTextField email;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                _5_HelpCenter frame = new _5_HelpCenter();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public _5_HelpCenter() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1465, 786);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x09173d));
        panel.setBounds(0, 0, 1366, 114); // Dynamically set width
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Customer Support");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
        lblNewLabel_1.setBounds(425, -2, 515, 66);
        lblNewLabel_1.setForeground(Color.WHITE);
        panel.add(lblNewLabel_1);
        
        JLabel FAQs = new JLabel("FAQs");
        FAQs.setBounds(337, 56, 349, 56);
        panel.add(FAQs);
        FAQs.setForeground(new Color(255, 255, 255));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 30));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(0, 56, 349, 58);
        panel.add(panel_2_1_1);
        
        JLabel report = new JLabel("Report");
        report.setBounds(0, 0, 349, 58);
        panel_2_1_1.add(report);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setFont(new Font("Tahoma", Font.BOLD, 30));
        report.setForeground(new Color(0x09173d));
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                _5_HelpCenter faqsFrame = new _5_HelpCenter(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        JLabel feedBack = new JLabel("Feedback\r\n");
        feedBack.setBounds(685, 58, 342, 56);
        panel.add(feedBack);
        feedBack.setHorizontalAlignment(SwingConstants.CENTER);
        feedBack.setForeground(new Color(255, 255, 255));
        feedBack.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        JLabel contact = new JLabel("Contact & Support");
        contact.setBounds(1026, 55, 340, 58);
        panel.add(contact);
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        contact.setForeground(new Color(255, 255, 255));
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        JLabel backBtn = new JLabel("Back");
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
        backBtn.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\back.png"));
        backBtn.setBounds(10, 11, 127, 34);
        panel.add(backBtn);
        
        //link mo dito yung ibaback
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                _5_HelpCenter faqsFrame = new _5_HelpCenter(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	_5_Contact faqsFrame = new _5_Contact(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        feedBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	_5_FeedBack faqsFrame = new _5_FeedBack(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        
        FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                _5_FAQs faqsFrame = new _5_FAQs(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(0x09173d));
        panel_11.setBounds(144, 157, 1274, 557);
        contentPane.add(panel_11);
        panel_11.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Room Report");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_2.setBounds(19, 11, 262, 31);
        panel_11.add(lblNewLabel_2);

        JLabel lblNewLabel_11 = new JLabel("Name:");
        lblNewLabel_11.setForeground(new Color(255, 255, 255));
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11.setBounds(19, 70, 80, 23);
        panel_11.add(lblNewLabel_11);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(19, 94, 338, 44);
        panel_11.add(name);
        name.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Description:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(19, 159, 135, 23);
        panel_11.add(lblNewLabel_1_1);

        description = new JTextArea();
        description.setBounds(19, 186, 1228, 299);
        description.setFont(new Font("Tahoma", Font.PLAIN, 17));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panel_11.add(description);
        SwingUtilities.invokeLater(() -> roomDropDown.repaint());
        
        // Add room dropdown
        roomDropDown = new JComboBox<>();
        roomDropDown.setFont(new Font("Tahoma", Font.PLAIN, 17));
        roomDropDown.setBounds(761, 93, 238, 44);
        panel_11.add(roomDropDown);

        // Populate dropdown with property names
        populateRoomDropDown();

        JButton ReportBtn = new JButton("Report");
        ReportBtn.setBackground(new Color(255, 255, 255));
        ReportBtn.setBounds(1158, 509, 89, 23);
        panel_11.add(ReportBtn);
        
        email = new JTextField();
        email.setText("");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setColumns(10);
        email.setBounds(391, 94, 338, 44);
        panel_11.add(email);
        
        JLabel lblNewLabel_11_1 = new JLabel("Email:");
        lblNewLabel_11_1.setForeground(Color.WHITE);
        lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11_1.setBounds(391, 70, 80, 23);
        panel_11.add(lblNewLabel_11_1);

        ReportBtn.addActionListener(e -> {
            String nameValue = name.getText().trim();
            String emailValue = email.getText().trim();
            String descriptionValue = description.getText().trim();
            String propertyValue = (String) roomDropDown.getSelectedItem(); // Get selected value from JComboBox

            if (nameValue.isEmpty() || emailValue.isEmpty() || descriptionValue.isEmpty() || propertyValue == null) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if the email exists in the database
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suitespotDB", "root", "")) {
                String sqlCheckEmail = "SELECT COUNT(*) FROM inquiry WHERE inquirerEmail = ?";
                PreparedStatement checkEmailStatement = connection.prepareStatement(sqlCheckEmail);
                checkEmailStatement.setString(1, emailValue);
                ResultSet resultSet = checkEmailStatement.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(this, "No account found with this email.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop further execution if email does not exist
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Submit the report if email exists
            if (DatabaseHelper.insertReport(nameValue, emailValue, descriptionValue, propertyValue)) {
                JOptionPane.showMessageDialog(this, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                name.setText("");
                email.setText("");
                description.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to submit report!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


    }

    private void populateRoomDropDown() {
        BookingsDAO bookingDAO = new BookingsDAO();
        List<String> propertyNames = bookingDAO.getPropertyNames();

        if (propertyNames.isEmpty()) {
            System.out.println("No property names found!"); // Debugging
        }

        for (String propertyName : propertyNames) {
            roomDropDown.addItem(propertyName);
        }
    }
    
    static class DatabaseHelper {

        private static final String DB_URL = "jdbc:mysql://localhost:3306/suitespotDB";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "";

        public static boolean insertReport(String name, String email, String description, String property) {
            String sql = "INSERT INTO helpcenter (name, email, description, property) VALUES (?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, property);
                int rowsInserted = preparedStatement.executeUpdate();
                return rowsInserted > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }


}
