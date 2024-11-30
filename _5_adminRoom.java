package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;

public class _5_adminRoom {

    JFrame frame;
    private JTable tableAdmin;
    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    _5_adminRoom window = new _5_adminRoom();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public _5_adminRoom() {
        initialize();
        loadHelpCenterData(); 
    }
    
    

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 1431, 782);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblADMIN = new JLabel("ADMIN");
        lblADMIN.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblADMIN.setBounds(41, 11, 62, 30);
        frame.getContentPane().add(lblADMIN);

        // Initialize the table model
        tableModel = new DefaultTableModel(
            new Object[][] {}, // Start with an empty table
            new String[] {
                "Name", "Airbnb", "Description","Email"
            }
        );

        // Initialize the table with the model
        tableAdmin = new JTable(tableModel);
        tableAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(tableAdmin);
        scrollPane.setBounds(40, 74, 1282, 559);
        frame.getContentPane().add(scrollPane);

        // Remove Row button
        JButton btnRemoveRow = new JButton("Remove Row");
        btnRemoveRow.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRemoveRow.setBounds(347, 644, 180, 30);
        frame.getContentPane().add(btnRemoveRow);
        
        // Sort by Oldest button
        JButton btnSortbyOldest = new JButton("Sort by Oldest");
        btnSortbyOldest.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSortbyOldest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortTableByArrivalDate(false); // Sort by oldest
            }
        });
        btnSortbyOldest.setBounds(577, 644, 180, 30);
        frame.getContentPane().add(btnSortbyOldest);

        // Sort by Newest button
        JButton btnSortbyNewest = new JButton("Sort by Newest");
        btnSortbyNewest.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSortbyNewest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortTableByArrivalDate(true); // Sort by newest
            }
        });
        btnSortbyNewest.setBounds(802, 644, 180, 30);
        frame.getContentPane().add(btnSortbyNewest);
        
        
        
        JLabel lblRoomReport = new JLabel("ROOM REPORT");
        lblRoomReport.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblRoomReport.setBounds(41, 29, 185, 30);
        frame.getContentPane().add(lblRoomReport);
        
        JButton customerBTN = new JButton("System Reports");
        customerBTN.setFont(new Font("Tahoma", Font.BOLD, 15));
        customerBTN.setBounds(1142, 29, 180, 30);
        frame.getContentPane().add(customerBTN);
        
        customerBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                _5_adminSystem faqsFrame = new _5_adminSystem(); 
                faqsFrame.frame.setVisible(true); // Make the new frame visible
            }
        });

        
        // ActionListener for removing rows
        btnRemoveRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableAdmin.getSelectedRow();
                if (selectedRow >= 0) {
                    // Get the unique identifier for the row
                    String identifier = (String) tableModel.getValueAt(selectedRow, 3); // Assuming the identifier is in column 3

                    String url = "jdbc:mysql://localhost:3306/SuiteSpotDB"; // Replace with your DB details
                    String user = "root"; // Replace with your DB username
                    String password = ""; // Replace with your DB password

                    String deleteQuery = "DELETE FROM HelpCenter WHERE email = ?";

                    try (Connection connection = DriverManager.getConnection(url, user, password);
                         java.sql.PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                        preparedStatement.setString(1, identifier); // Set the identifier value

                        int affectedRows = preparedStatement.executeUpdate();
                        if (affectedRows > 0) {
                            tableModel.removeRow(selectedRow);
                            JOptionPane.showMessageDialog(frame, "Row removed successfully from the database!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Failed to delete row from the database!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error removing data: " + ex.getMessage(),
                                "Database Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to remove!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

  /*  // Method to add a new row to the table
    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }   */

    // Method to sort the table by arrival date
    
    
    private void sortTableByArrivalDate(boolean newestFirst) {
        List<RowData> rowDataList = new ArrayList<>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            try {
                String arrivalDateStr = (String) tableModel.getValueAt(i, 4); // Column 4: Arrival Date
                Date arrivalDate = dateFormat.parse(arrivalDateStr);
                Object[] rowData = new Object[tableModel.getColumnCount()];
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    rowData[j] = tableModel.getValueAt(i, j);
                }
                rowDataList.add(new RowData(arrivalDate, rowData));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        rowDataList.sort((row1, row2) -> {
            if (newestFirst) {
                return row2.arrivalDate.compareTo(row1.arrivalDate);
            } else {
                return row1.arrivalDate.compareTo(row2.arrivalDate);
            }
        });

        tableModel.setRowCount(0);

        for (RowData rowData : rowDataList) {
            tableModel.addRow(rowData.rowData);
        }
    }

    // Helper class to store row data with arrival date
    private static class RowData {
        Date arrivalDate;
        Object[] rowData;

        RowData(Date arrivalDate, Object[] rowData) {
            this.arrivalDate = arrivalDate;
            this.rowData = rowData;
        }
    }
    
    private void loadHelpCenterData() {
        String url = "jdbc:mysql://localhost:3306/SuiteSpotDB"; // Replace with your DB details
        String user = "root"; // Replace with your DB username
        String password = ""; // Replace with your DB password

        String query = "SELECT name, property AS Airbnb, description, email FROM HelpCenter";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String airbnb = resultSet.getString("Airbnb");
                String description = resultSet.getString("description");
                String email = resultSet.getString("email");

                tableModel.addRow(new Object[]{name, airbnb, description, email});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading data: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
