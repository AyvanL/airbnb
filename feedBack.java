package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class feedBack extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField txtRate;
    private JTextArea description;
    private ArrayList<Feedback> feedbackList;
    private JTextArea feedbackTextArea;
    private Queue<String> feedName;
    private Queue<String> feedDesc;
    private Queue<Integer> feedRatings;

    class Feedback {
        String name;
        int rating;
        String description;

        Feedback(String name, int rating, String description) {
            this.name = name;
            this.rating = rating;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                feedBack frame = new feedBack();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public feedBack() {
        feedbackList = new ArrayList<>();
        feedName = new LinkedList<>();
        feedDesc = new LinkedList<>();
        feedRatings = new LinkedList<>();

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
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(289, 0, 200, 40);
        panel.add(lblNewLabel_1);

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

        JLabel report = new JLabel("Report");
        report.setBounds(0, 42, 177, 39);
        panel.add(report);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setFont(new Font("Tahoma", Font.BOLD, 20));
        report.setForeground(new Color(255, 255, 255));
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	HelpCenter faqsFrame = new HelpCenter(); 
                faqsFrame.setVisible(true);
                dispose(); 
            }
        });

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBackground(Color.WHITE);
        panel_2_1.setBounds(351, 42, 177, 39);
        panel.add(panel_2_1);

        JLabel feedBack = new JLabel("Feedback");
        feedBack.setBounds(0, 0, 177, 39);
        panel_2_1.add(feedBack);
        feedBack.setHorizontalAlignment(SwingConstants.CENTER);
        feedBack.setForeground(new Color(245, 82, 86));
        feedBack.setFont(new Font("Tahoma", Font.BOLD, 20));

        JLabel FAQs = new JLabel("FAQs");
        FAQs.setBounds(175, 42, 177, 39);
        panel.add(FAQs);
        FAQs.setForeground(new Color(255, 255, 255));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 20));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        
        FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	FAQs faqsFrame = new FAQs(); 
                faqsFrame.setVisible(true);
                dispose(); 
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(250, 75, 80));
        inputPanel.setBounds(23, 114, 400, 291);
        contentPane.add(inputPanel);
        inputPanel.setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(20, 20, 100, 20);
        inputPanel.add(lblName);

        name = new JTextField();
        name.setBounds(20, 40, 180, 30);
        inputPanel.add(name);

        JLabel lblFeedback = new JLabel("Feedback:");
        lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblFeedback.setForeground(Color.WHITE);
        lblFeedback.setBounds(20, 80, 100, 20);
        inputPanel.add(lblFeedback);

        description = new JTextArea();
        description.setBounds(20, 100, 350, 91);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        inputPanel.add(description);

        JLabel lblRating = new JLabel("Rating:");
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRating.setForeground(Color.WHITE);
        lblRating.setBounds(20, 202, 100, 20);
        inputPanel.add(lblRating);

        JPanel ratingPanel = new JPanel();
        ratingPanel.setBackground(new Color(245, 82, 86));
        ratingPanel.setBounds(20, 222, 200, 30);
        inputPanel.add(ratingPanel);

        JCheckBox[] stars = new JCheckBox[5];
        for (int i = 0; i < 5; i++) {
            stars[i] = new JCheckBox(String.valueOf(i + 1));
            ratingPanel.add(stars[i]);
            int index = i;
            stars[i].addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    for (int j = 0; j < 5; j++) {
                        if (j != index) stars[j].setSelected(false);
                    }
                }
            });
        }

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(255, 255, 255));
        submitButton.setBounds(280, 222, 90, 30);
        inputPanel.add(submitButton);

        // Feedback display panel
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setBackground(new Color(250, 75, 80));
        feedbackPanel.setBounds(450, 114, 300, 250);
        contentPane.add(feedbackPanel);
        feedbackPanel.setLayout(null);

        JLabel feedbackTitle = new JLabel("Top Feedbacks:");
        feedbackTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        feedbackTitle.setForeground(Color.WHITE);
        feedbackTitle.setBounds(10, 10, 150, 20);
        feedbackPanel.add(feedbackTitle);

        feedbackTextArea = new JTextArea();
        feedbackTextArea.setEditable(false);
        feedbackTextArea.setLineWrap(true);
        feedbackTextArea.setWrapStyleWord(true);
        feedbackTextArea.setBackground(new Color(255, 255, 255));
        feedbackTextArea.setForeground(new Color(0, 0, 0));
        JScrollPane scrollPane = new JScrollPane(feedbackTextArea);
        scrollPane.setBounds(10, 40, 280, 200);
        feedbackPanel.add(scrollPane);

        txtRate = new JTextField();
        txtRate.setEditable(false);
        txtRate.setForeground(Color.WHITE);
        txtRate.setBackground(new Color(245, 82, 86));
        txtRate.setBounds(450, 375, 300, 30);
        txtRate.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtRate.setText("System Rating: 0");
        contentPane.add(txtRate);

        // Retrieve data from the database
        retrieveFeedbackFromDatabase();
        updateFeedbackList();

        // Submit button action listener
        submitButton.addActionListener(e -> {
            String nameValue = name.getText().trim();
            String descriptionValue = description.getText().trim();
            int selectedRating = 0;

            for (int i = 0; i < 5; i++) {
                if (stars[i].isSelected()) {
                    selectedRating = i + 1;
                    break;
                }
            }

            if (nameValue.isEmpty() || descriptionValue.isEmpty() || selectedRating == 0) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields and select a rating.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Add values to respective queues
                feedName.add(nameValue);
                feedDesc.add(descriptionValue);
                feedRatings.add(selectedRating);

                
             
                name.setText("");
                description.setText("");
                feedbackList.add(new Feedback(nameValue, selectedRating, descriptionValue));
                updateFeedbackList();

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "")) {
                    String sql = "INSERT INTO feedback (name, description, rating) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nameValue);
                    preparedStatement.setString(2, descriptionValue);
                    preparedStatement.setInt(3, selectedRating);

                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to save feedback to the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\FAQs.png"));
        background.setBounds(0, 0, 784, 461);
        contentPane.add(background);
    }

    private void retrieveFeedbackFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "")) {
            String sql = "SELECT name, description, rating FROM feedback";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Clear queues
            feedName.clear();
            feedDesc.clear();
            feedRatings.clear();
            feedbackList.clear();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int rating = resultSet.getInt("rating");

                // Add to queues and feedback list
                feedName.add(name);
                feedDesc.add(description);
                feedRatings.add(rating);
                feedbackList.add(new Feedback(name, rating, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateFeedbackList() {
        feedbackTextArea.setText("");
        int totalRating = 0;

        for (Feedback feedback : feedbackList) {
            feedbackTextArea.append("Name: " + feedback.name + "\n");
            feedbackTextArea.append("Rating: " + feedback.rating + "\n");
            feedbackTextArea.append("Description: " + feedback.description + "\n\n");
            totalRating += feedback.rating;
        }

        double averageRating = feedbackList.isEmpty() ? 0.0 : (double) totalRating / feedbackList.size();
        txtRate.setText(String.format("Average Rating: %.1f", averageRating)); 
    }
}
