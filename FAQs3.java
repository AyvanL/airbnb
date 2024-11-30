package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

public class FAQs3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FAQs3 frame = new FAQs3();
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
    public FAQs3() {
   
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
        panel.setBounds(0, 0, 1374, 80);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton reportBack = new JButton("<--");
        reportBack.setFont(new Font("Tahoma", Font.BOLD, 17));
        reportBack.setBackground(new Color(0x09173d));
        reportBack.setForeground(new Color(255, 255, 255));
        reportBack.setBounds(10, 11, 110, 58);
        panel.add(reportBack);
        
        reportBack.addActionListener(e -> {
            _5_FAQs hc = new _5_FAQs();
            hc.setVisible(true); 
            dispose();
        });


        JLabel lblNewLabel = new JLabel("FAQS");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setBounds(505, -1, 363, 77);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0x09173d));
        panel_1.setBounds(74, 144, 1219, 576);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblTitile = new JLabel("How to create an account?");
        lblTitile.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitile.setForeground(Color.WHITE);
        lblTitile.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTitile.setBounds(20, 11, 363, 62);
        panel_1.add(lblTitile);
        
        JTextArea txtrGoToThe = new JTextArea();
        txtrGoToThe.setBackground(new Color(0x09173d));
        txtrGoToThe.setForeground(new Color(255, 255, 255));
        txtrGoToThe.setFont(new Font("Tahoma", Font.PLAIN, 21));
        txtrGoToThe.setText("1. Press the \"Manage\" Button\nOn our homepage, click the \"Manage\" button to start the signup process.\n\n\r\n\r\n2. Fill Out the Sign-Up Form\nProvide the required information in the form, such as your name, email, and other details.\n\n\r\n\r\n3. You're Done!\nAfter completing the form, your account is created, and you’re ready to use our system.");
        txtrGoToThe.setBounds(20, 74, 1176, 470);
        panel_1.add(txtrGoToThe);

        
    }
}
