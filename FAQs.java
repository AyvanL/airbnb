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

public class FAQs extends JFrame {

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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FAQs frame = new FAQs();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FAQs() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set JFrame to occupy the full screen dimensions
           setBounds(100, 100, 1465, 786);
           setExtendedState(JFrame.MAXIMIZED_BOTH);
           setUndecorated(true);

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
           
           JPanel panel_2_1_1 = new JPanel();
           panel_2_1_1.setLayout(null);
           panel_2_1_1.setBackground(Color.WHITE);
           panel_2_1_1.setBounds(340, 56, 349, 58);
           panel.add(panel_2_1_1);
           
           JLabel FAQs = new JLabel("FAQs");
           FAQs.setBounds(0, 0, 349, 56);
           panel_2_1_1.add(FAQs);
           FAQs.setForeground(new Color(245, 82, 86));
           FAQs.setFont(new Font("Tahoma", Font.BOLD, 30));
           FAQs.setHorizontalAlignment(SwingConstants.CENTER);
           
           
           FAQs.addMouseListener(new java.awt.event.MouseAdapter() {
               @Override
               public void mouseClicked(java.awt.event.MouseEvent e) {
                   FAQs faqsFrame = new FAQs(); 
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


        ArrayList<FAQ> faqList = new ArrayList<>();
        faqList.add(new FAQ("How to book a stay?", "/faq/how-to-book", "Booking"));
        faqList.add(new FAQ("DI PA TAPOSSS", "/faq/refund-policy", "Payments"));
        faqList.add(new FAQ("try", "/faq/reset-password", "Account"));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (FAQ faq : faqList) {
            listModel.addElement(faq.toString());
        }

        JList<String> faqJList = new JList<>(listModel);
        faqJList.setFont(new Font("Tahoma", Font.PLAIN, 20));
        faqJList.setBounds(50, 150, 700, 250);
        faqJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(faqJList);
        scrollPane.setBounds(49, 199, 1271, 520);
        contentPane.add(scrollPane);

        faqJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = faqJList.getSelectedIndex();
                    if (selectedIndex == 0) {
                        FAQ selectedFAQ = faqList.get(selectedIndex);
                        FAQs1 hc = new FAQs1();
                        hc.setVisible(true);
                        dispose();
                    }else if(selectedIndex == 1) {
                    	FAQ selectedFAQ = faqList.get(selectedIndex);
                    	FAQs1 hc = new FAQs1();
                        hc.setVisible(true);
                        dispose();
                    }
                }
            }
        });
        
        JLabel lblNewLabel = new JLabel("FAQs");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(624, 148, 127, 25);
        contentPane.add(lblNewLabel);
        
                JLabel background = new JLabel("");
                background.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\FAQs.png"));
                background.setBounds(0, 0, 1366, 786);
                contentPane.add(background);
    }
}
