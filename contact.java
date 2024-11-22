package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class contact extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextArea description;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    contact frame = new contact();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public contact() {
    	Queue<String> systemName = new LinkedList<>();
        Queue<String> systemDesc = new LinkedList<>();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 75, 80));
        panel.setBounds(0, 0, 784, 81);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Customer Support");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(289, -2, 200, 48);
        lblNewLabel_1.setForeground(Color.WHITE);
        panel.add(lblNewLabel_1);
        
        JLabel report = new JLabel("Report");
        report.setBounds(0, 42, 177, 39);
        panel.add(report);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setFont(new Font("Tahoma", Font.BOLD, 20));
        report.setForeground(new Color(255, 255, 255));
        
        JLabel FAQs = new JLabel("FAQs");
        FAQs.setBounds(175, 42, 177, 39);
        panel.add(FAQs);
        FAQs.setForeground(new Color(255, 255, 255));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 20));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(527, 42, 257, 39);
        panel.add(panel_2_1_1);
        
        JLabel contact = new JLabel("Contact & Support");
        contact.setBounds(0, 0, 257, 39);
        panel_2_1_1.add(contact);
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        contact.setForeground(new Color(245, 82, 86));
        contact.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JLabel feedBack = new JLabel("Feedback\r\n");
        feedBack.setBounds(361, 42, 167, 39);
        panel.add(feedBack);
        feedBack.setHorizontalAlignment(SwingConstants.CENTER);
        feedBack.setForeground(new Color(255, 255, 255));
        feedBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        feedBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	feedBack faqsFrame = new feedBack(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	contact faqsFrame = new contact(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        
        FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                FAQs faqsFrame = new FAQs(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                HelpCenter faqsFrame = new HelpCenter(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(250, 75, 80));
        panel_11.setBounds(53, 104, 390, 319);
        contentPane.add(panel_11);
        panel_11.setLayout(null);

        JLabel lblNewLabel_11 = new JLabel("Name:");
        lblNewLabel_11.setForeground(new Color(255, 255, 255));
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_11.setBounds(19, 21, 80, 15);
        panel_11.add(lblNewLabel_11);

        name = new JTextField();
        name.setBounds(19, 37, 188, 29);
        panel_11.add(name);
        name.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Issue:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(19, 77, 80, 15);
        panel_11.add(lblNewLabel_1_1);

        description = new JTextArea();
        description.setBounds(19, 92, 346, 174);
        description.setFont(new Font("Tahoma", Font.PLAIN, 12));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panel_11.add(description);

        JButton ReportBtn = new JButton("Report");
        ReportBtn.setBackground(new Color(255, 255, 255));
        ReportBtn.setBounds(276, 277, 89, 23);
        panel_11.add(ReportBtn);

       
        ReportBtn.addActionListener(e -> {
            String nameValue = name.getText(); 
            String descriptionValue = description.getText();
            systemName.add(nameValue);
            systemDesc.add(descriptionValue);

        
            System.out.println("Name: " + nameValue);
            System.out.println("Description: " + descriptionValue);
            System.out.println("System name: " + systemName);
            System.out.println("System name: " + systemDesc);

            
            if (nameValue.isEmpty() || descriptionValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                name.setText(""); 
                description.setText(""); 
            }
            
            try {
                // Database connection details
                String url = "jdbc:mysql://localhost:3306/airbnb";
                String user = "root"; // Replace with your username
                String password = ""; // Replace with your password

                // Establish connection
                Connection conn = DriverManager.getConnection(url, user, password);

                // Prepare SQL insert query
                String query = "INSERT INTO contact (name, issue) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);

                // Insert each value from the queues into the database
                while (!systemName.isEmpty() && !systemDesc.isEmpty()) {
                    stmt.setString(1, systemName.poll()); // Insert room name
                    stmt.setString(2, systemDesc.poll()); // Insert room description
                    stmt.executeUpdate();
                }
                
                JOptionPane.showMessageDialog(null, "Report submitted and saved to database!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the connection
                stmt.close();
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(250, 75, 80));
        panel_2.setBounds(492, 104, 267, 68);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 11, 46, 14);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("SuiteDreams@gmail.com");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 32, 201, 25);
        panel_2.add(lblNewLabel_2);
        
        JPanel panel_2_11 = new JPanel();
        panel_2_11.setLayout(null);
        panel_2_11.setBackground(new Color(250, 75, 80));
        panel_2_11.setBounds(492, 195, 267, 68);
        contentPane.add(panel_2_11);
        
        JLabel lblContact = new JLabel("Contact: ");
        lblContact.setForeground(Color.WHITE);
        lblContact.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblContact.setBounds(10, 11, 68, 14);
        panel_2_11.add(lblContact);
        
        JLabel lblNewLabel_2_1 = new JLabel("+63-283-555-3570");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(10, 32, 201, 25);
        panel_2_11.add(lblNewLabel_2_1);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setLayout(null);
        panel_2_2.setBackground(new Color(250, 75, 80));
        panel_2_2.setBounds(492, 288, 267, 68);
        contentPane.add(panel_2_2);
        
        JLabel lblNewLabel_4 = new JLabel("Facebook: ");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_4.setBounds(10, 11, 107, 14);
        panel_2_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_2_2 = new JLabel("Suite Dreams");
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2_2.setBounds(10, 32, 201, 25);
        panel_2_2.add(lblNewLabel_2_2);
        
        JLabel background = new JLabel("");
        background.setBackground(new Color(250, 75, 80));
        background.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\FAQs.png"));
        background.setBounds(0, 0, 784, 461);
        contentPane.add(background);
    }
}