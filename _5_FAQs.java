package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class _5_FAQs extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    class FAQ {
        String title;
        String url;
        String category;

        FAQ(String title, String url, String category) {
            this.title = title;
            this.url = url;
            this.category = category;
        }

        @Override
        public String toString() {
            return title + " (" + category + ")";
        }
    }

    // Heap Sort class to sort FAQs by title
    static class HeapSortFAQ {

        // Method to perform Heap Sort
        public static void heapSort(ArrayList<FAQ> list) {
            int n = list.size();

            // Build the max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(list, n, i);
            }

            // Extract elements from the heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Swap current root with the end element
                FAQ temp = list.get(0);
                list.set(0, list.get(i));
                list.set(i, temp);

                // Call heapify on the reduced heap
                heapify(list, i, 0);
            }
        }

        // To heapify a subtree rooted with node i
        public static void heapify(ArrayList<FAQ> list, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && list.get(left).title.compareToIgnoreCase(list.get(largest).title) > 0) {
                largest = left;
            }

            if (right < n && list.get(right).title.compareToIgnoreCase(list.get(largest).title) > 0) {
                largest = right;
            }

            if (largest != i) {
                FAQ swap = list.get(i);
                list.set(i, list.get(largest));
                list.set(largest, swap);

                heapify(list, n, largest);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _5_FAQs frame = new _5_FAQs();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public _5_FAQs() {
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
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(340, 56, 349, 58);
        panel.add(panel_2_1_1);
        
        JLabel FAQs = new JLabel("FAQs");
        FAQs.setBounds(0, 0, 349, 56);
        panel_2_1_1.add(FAQs);
        FAQs.setForeground(new Color(0x09173d));
        FAQs.setFont(new Font("Tahoma", Font.BOLD, 30));
        FAQs.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                _5_FAQs faqsFrame = new _5_FAQs(); 
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
        
        JLabel report = new JLabel("Report");
        report.setBounds(0, 55, 349, 58);
        panel.add(report);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setFont(new Font("Tahoma", Font.BOLD, 30));
        report.setForeground(new Color(255, 255, 255));
        
        report.addMouseListener(new java.awt.event.MouseAdapter() {
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

        ArrayList<FAQ> faqList = new ArrayList<>();
        faqList.add(new FAQ("How to book a stay?", "/faq/how-to-book", "Booking"));
        faqList.add(new FAQ("How to report a room", "/faq/report", "Customer Service"));
        faqList.add(new FAQ("How to create an account", "/faq/account", "Account"));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (FAQ faq : faqList) {
            listModel.addElement(faq.toString());
        }

        JLabel lblNewLabel = new JLabel("FAQs");
        lblNewLabel.setBounds(731, 148, 127, 25);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);

        JList<String> faqJList = new JList<>(listModel);
        contentPane.add(faqJList);
        faqJList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        faqJList.setBounds(99, 201, 1366, 518);
        faqJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(99, 135, 213, 40);
        contentPane.add(comboBox);
        comboBox.addItem("Booking");
        comboBox.addItem("Customer Service");
        comboBox.addItem("Account");

        comboBox.addActionListener(e -> {
            String selectedCategory = (String) comboBox.getSelectedItem(); // Get selected category

            // Filter FAQs by selected category
            ArrayList<FAQ> filteredFaqList = new ArrayList<>();
            for (FAQ faq : faqList) {
                if (faq.category.equalsIgnoreCase(selectedCategory)) {
                    filteredFaqList.add(faq); // Add matching FAQs
                }
            }

            // Sort FAQs alphabetically by title using Heap Sort
            HeapSortFAQ.heapSort(filteredFaqList);

            // Update the JList
            listModel.clear(); // Clear the existing list
            for (FAQ faq : filteredFaqList) {
                listModel.addElement(faq.toString());
            }
        });

        faqJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String selectedFAQString = faqJList.getSelectedValue();
                    
                    // Find the corresponding FAQ from the original list by comparing the toString value
                    FAQ selectedFAQ = null;
                    for (FAQ faq : faqList) {
                        if (faq.toString().equals(selectedFAQString)) {
                            selectedFAQ = faq;
                            break; // Exit the loop once we find the matching FAQ
                        }
                    }
                    
                    if (selectedFAQ != null) {
                        // Navigate based on the URL of the selected FAQ
                        String url = selectedFAQ.url;  // Get the URL of the selected FAQ

                        // Navigate to the appropriate frame based on the URL
                        switch (url) {
                            case "/faq/how-to-book":
                                FAQs1 hc1 = new FAQs1();
                                hc1.setVisible(true);
                                dispose();
                                break;
                            case "/faq/report":
                                FAQs2 hc2 = new FAQs2();
                                hc2.setVisible(true);
                                dispose();
                                break;
                            case "/faq/account":
                                FAQs3 hc3 = new FAQs3();
                                hc3.setVisible(true);
                                dispose();
                                break;
                            default:
                                // Handle case where URL doesn't match any known FAQ
                                JOptionPane.showMessageDialog(contentPane, "No matching FAQ page found.");
                                break;
                        }
                    }
                }
            }
        });


    }
}
