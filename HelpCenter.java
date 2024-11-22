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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelpCenter frame = new HelpCenter();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HelpCenter() {
        Queue<String> roomName = new LinkedList<>();
        Queue<String> roomDesc = new LinkedList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set JFrame to occupy the full screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        setLocationRelativeTo(null); // Optional: Centers the JFrame

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 75, 80));
        panel.setBounds(0, 0, getWidth(), 81); // Dynamically set width
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Customer Support");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(289, -2, 200, 48);
        lblNewLabel_1.setForeground(Color.WHITE);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 42, 177, 39);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Report");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(250, 75, 80));
        lblNewLabel.setBounds(0, 0, 177, 39);
        panel_1.add(lblNewLabel);

        JLabel FAQs = new JLabel("FAQs");
        FAQs.setForeground(new Color(255, 255, 255));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 20));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        FAQs.setBounds(176, 42, 177, 39);
        panel.add(FAQs);

        FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                FAQs faqsFrame = new FAQs();
                faqsFrame.setVisible(true);
                dispose();
            }
        });

        JLabel feedBack = new JLabel("Feedback");
        feedBack.setHorizontalAlignment(SwingConstants.CENTER);
        feedBack.setForeground(Color.WHITE);
        feedBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        feedBack.setBounds(355, 42, 177, 39);
        panel.add(feedBack);

        feedBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                feedBack faqsFrame = new feedBack();
                faqsFrame.setVisible(true);
                dispose();
            }
        });

        JLabel contact = new JLabel("Contact & Support");
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        contact.setForeground(Color.WHITE);
        contact.setFont(new Font("Tahoma", Font.BOLD, 20));
        contact.setBounds(560, 42, 200, 39);
        panel.add(contact);

        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                contact faqsFrame = new contact();
                faqsFrame.setVisible(true);
                dispose();
            }
        });

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(250, 75, 80));
        panel_11.setBounds(75, 104, getWidth() - 150, getHeight() - 150);
        contentPane.add(panel_11);
        panel_11.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Room Report");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_2.setBounds(19, 11, 135, 31);
        panel_11.add(lblNewLabel_2);

        JLabel lblNewLabel_11 = new JLabel("Name:");
        lblNewLabel_11.setForeground(new Color(255, 255, 255));
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_11.setBounds(19, 53, 80, 15);
        panel_11.add(lblNewLabel_11);

        name = new JTextField();
        name.setBounds(19, 69, 340, 29);
        panel_11.add(name);
        name.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Description:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(19, 109, 80, 15);
        panel_11.add(lblNewLabel_1_1);

        description = new JTextArea();
        description.setBounds(19, 127, 599, 174);
        description.setFont(new Font("Tahoma", Font.PLAIN, 12));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panel_11.add(description);

        JButton ReportBtn = new JButton("Report");
        ReportBtn.setBackground(new Color(255, 255, 255));
        ReportBtn.setBounds(529, 312, 89, 23);
        panel_11.add(ReportBtn);

        ReportBtn.addActionListener(e -> {
            String nameValue = name.getText();
            String descriptionValue = description.getText();
            roomName.add(nameValue);
            roomDesc.add(descriptionValue);

            System.out.println("Name: " + nameValue);
            System.out.println("Description: " + descriptionValue);
            System.out.println("System name: " + roomName);
            System.out.println("System name: " + roomDesc);

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
