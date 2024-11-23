package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

public class HelpCenter extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextArea description;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HelpCenter frame = new HelpCenter();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HelpCenter() {
        Queue<String> roomName = new LinkedList<>();
        Queue<String> roomDesc = new LinkedList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1465, 786);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); // Optional: Removes the window borders if needed

        // Initialize contentPane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 75, 80));
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
        report.setForeground(new Color(245, 82, 86));
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                HelpCenter faqsFrame = new HelpCenter(); 
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
                HelpCenter faqsFrame = new HelpCenter(); 
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
        
        feedBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	feedBack faqsFrame = new feedBack(); 
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

        // Content panel
        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(250, 75, 80));
        panel_11.setBounds(51, 165, 1274, 557);
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

        JButton ReportBtn = new JButton("Report");
        ReportBtn.setBackground(new Color(255, 255, 255));
        ReportBtn.setBounds(1158, 509, 89, 23);
        panel_11.add(ReportBtn);

        ReportBtn.addActionListener(e -> {
            String nameValue = name.getText();
            String descriptionValue = description.getText();
            roomName.add(nameValue);
            roomDesc.add(descriptionValue);

            if (nameValue.isEmpty() || descriptionValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Report submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                name.setText("");
                description.setText("");
            }

            try {
                String url = "jdbc:mysql://localhost:3306/airbnb";
                String user = "root";
                String password = "";

                Connection conn = DriverManager.getConnection(url, user, password);
                String query = "INSERT INTO helpcenter (name, description) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);

                while (!roomName.isEmpty() && !roomDesc.isEmpty()) {
                    stmt.setString(1, roomName.poll());
                    stmt.setString(2, roomDesc.poll());
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

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\FAQs.png"));
        background.setBounds(0, 0, getWidth(), getHeight());
        contentPane.add(background);
    }
}
