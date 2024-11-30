package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _5_Contact extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextArea description;
    private JTextField email;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _5_Contact frame = new _5_Contact();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public _5_Contact() {
    	Queue<String> systemName = new LinkedList<>();
        Queue<String> systemDesc = new LinkedList<>();
        Queue<String> systemEmail = new LinkedList<>();
    	
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
        panel.setBounds(99, 0, 1366, 114); 
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Customer Support");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
        lblNewLabel_1.setBounds(425, -2, 515, 66);
        lblNewLabel_1.setForeground(Color.WHITE);
        panel.add(lblNewLabel_1);
        
        JLabel report = new JLabel("Report");
        report.setBounds(0, 54, 349, 60);
        panel.add(report);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setFont(new Font("Tahoma", Font.BOLD, 30));
        report.setForeground(new Color(255, 255, 255));
        
        JLabel FAQs = new JLabel("FAQs");
        FAQs.setBounds(337, 56, 349, 56);
        panel.add(FAQs);
        FAQs.setForeground(new Color(255, 255, 255));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 30));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(1026, 56, 340, 58);
        panel.add(panel_2_1_1);
        
        JLabel contact = new JLabel("Contact & Support");
        contact.setBounds(0, 0, 340, 58);
        panel_2_1_1.add(contact);
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        contact.setForeground(new Color(0x09173d));
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	_5_Contact faqsFrame = new _5_Contact(); 
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
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	_5_HelpCenter faqsFrame = new _5_HelpCenter(); 
                faqsFrame.setVisible(true); 
                dispose(); 
            }
        });
        
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
        
        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(0x09173d));
        panel_11.setBounds(173, 161, 694, 560);
        contentPane.add(panel_11);
        panel_11.setLayout(null);

        JLabel lblNewLabel_11 = new JLabel("Name:");
        lblNewLabel_11.setForeground(new Color(255, 255, 255));
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11.setBounds(19, 30, 80, 15);
        panel_11.add(lblNewLabel_11);

        name = new JTextField();
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(19, 48, 282, 44);
        panel_11.add(name);
        name.setColumns(10);
        
        email = new JTextField();
        email.setText("");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setColumns(10);
        email.setBounds(330, 48, 339, 44);
        panel_11.add(email);
        
        JLabel lblNewLabel_11_1 = new JLabel("Email:");
        lblNewLabel_11_1.setForeground(Color.WHITE);
        lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11_1.setBounds(329, 30, 80, 15);
        panel_11.add(lblNewLabel_11_1);

        JLabel lblNewLabel_1_1 = new JLabel("Issue:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(19, 103, 80, 15);
        panel_11.add(lblNewLabel_1_1);

        description = new JTextArea();
        description.setBounds(19, 121, 650, 381);
        description.setFont(new Font("Tahoma", Font.PLAIN, 17));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panel_11.add(description);

        JButton ReportBtn = new JButton("Report");
        ReportBtn.setBackground(new Color(255, 255, 255));
        ReportBtn.setBounds(580, 513, 89, 23);
        panel_11.add(ReportBtn);

       
        ReportBtn.addActionListener(e -> {
            String nameValue = name.getText(); 
            String descriptionValue = description.getText();
            String emailValue = email.getText(); 
            systemName.add(nameValue);
            systemDesc.add(descriptionValue);
            systemEmail.add(emailValue);

        
            System.out.println("Name: " + nameValue);
            System.out.println("Description: " + descriptionValue);
            System.out.println("System name: " + systemName);
            System.out.println("System name: " + systemDesc);

            
            if (nameValue.isEmpty() || descriptionValue.isEmpty() || emailValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                name.setText(""); 
                description.setText(""); 
                email.setText("");
                
                
            }
            
            try {
                
                String url = "jdbc:mysql://localhost:3306/suitespotdb";
                String user = "root"; 
                String password = ""; 

                
                Connection conn = DriverManager.getConnection(url, user, password);

                
                String query = "INSERT INTO contact (name, issue, email) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);

                while (!systemName.isEmpty() && !systemDesc.isEmpty()) {
                    stmt.setString(1, systemName.poll()); 
                    stmt.setString(2, systemDesc.poll()); 
                    stmt.setString(3, systemEmail.poll()); 
                    stmt.executeUpdate();
                }
                
                JOptionPane.showMessageDialog(null, "Report submitted and saved to database!", "Success", JOptionPane.INFORMATION_MESSAGE);

                
                stmt.close();
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(0x09173d));
        panel_2.setBounds(939, 162, 460, 167);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 22, 168, 25);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("SuiteDreams@gmail.com");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(10, 45, 291, 43);
        panel_2.add(lblNewLabel_2);
        
        JPanel panel_2_11 = new JPanel();
        panel_2_11.setLayout(null);
        panel_2_11.setBackground(new Color(0x09173d));
        panel_2_11.setBounds(939, 360, 460, 167);
        contentPane.add(panel_2_11);
        
        JLabel lblContact = new JLabel("Contact: ");
        lblContact.setForeground(Color.WHITE);
        lblContact.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblContact.setBounds(10, 11, 138, 25);
        panel_2_11.add(lblContact);
        
        JLabel lblNewLabel_2_1 = new JLabel("+63-283-555-3570");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(10, 32, 279, 53);
        panel_2_11.add(lblNewLabel_2_1);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setLayout(null);
        panel_2_2.setBackground(new Color(0x09173d));
        panel_2_2.setBounds(939, 554, 462, 167);
        contentPane.add(panel_2_2);
        
        JLabel lblNewLabel_4 = new JLabel("Facebook: ");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(10, 11, 160, 25);
        panel_2_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_2_2 = new JLabel("Suite Dreams");
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_2.setBounds(10, 39, 201, 67);
        panel_2_2.add(lblNewLabel_2_2);
        
        
    }
}
