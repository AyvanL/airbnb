package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

public class FAQs1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FAQs1 frame = new FAQs1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FAQs1() {
   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 75, 80));
        panel.setBounds(0, 0, 784, 80);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton reportBack = new JButton("<--");
        reportBack.setFont(new Font("Tahoma", Font.BOLD, 17));
        reportBack.setBackground(new Color(250, 75, 80));
        reportBack.setForeground(new Color(255, 255, 255));
        reportBack.setBounds(10, 11, 110, 58);
        panel.add(reportBack);
        
        reportBack.addActionListener(e -> {
            FAQs hc = new FAQs();
            hc.setVisible(true); 
            this.dispose(); 
        });


        JLabel lblNewLabel = new JLabel("FAQS");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setBounds(220, -1, 363, 77);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(250, 75, 80));
        panel_1.setBounds(75, 104, 639, 319);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblTitile = new JLabel("SUBJECT");
        lblTitile.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitile.setForeground(Color.WHITE);
        lblTitile.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitile.setBounds(10, 11, 363, 62);
        panel_1.add(lblTitile);
        
        JLabel lblDescriptions = new JLabel("Descriptions");
        lblDescriptions.setHorizontalAlignment(SwingConstants.LEFT);
        lblDescriptions.setForeground(Color.WHITE);
        lblDescriptions.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblDescriptions.setBounds(10, 59, 363, 62);
        panel_1.add(lblDescriptions);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("C:\\Users\\ayvan\\OneDrive\\Documents\\Java-Eclipse\\airbnb\\src\\main\\FAQs.png"));
        background.setBounds(0, 0, 784, 461);
        contentPane.add(background);
    }
}
