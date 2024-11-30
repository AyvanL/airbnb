package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingsDAO {

    // Method to add a booking to the database
    public void addBooking(String propertyName, String propertyOwnerName, String guestFirstName, String guestLastName,
                           String guestEmail, String guestContact, String guestAddress, int numberOfGuests,
                           String arrivalDate, String departureDate) throws SQLException {
        String query = 
            "INSERT INTO bookings (propertyName, propertyOwnerName, guestFirstName, guestLastName, guestEmail, guestContact, guestAddress, " +
            "numberOfGuests, arrivalDate, departureDate, bookingDate) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, propertyName);
            stmt.setString(2, propertyOwnerName);
            stmt.setString(3, guestFirstName);
            stmt.setString(4, guestLastName);
            stmt.setString(5, guestEmail);
            stmt.setString(6, guestContact);
            stmt.setString(7, guestAddress);
            stmt.setInt(8, numberOfGuests);
            stmt.setString(9, arrivalDate);
            stmt.setString(10, departureDate);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Booking added successfully!");
            } else {
                System.out.println("Booking failed: No matching property found or access denied.");
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while adding the booking:");
            e.printStackTrace();
        }
    }

    // Method to fetch property names
    public List<String> getPropertyNames() {
        List<String> propertyNames = new ArrayList<>();
        String query = "SELECT DISTINCT propertyName FROM bookings";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String propertyName = rs.getString("propertyName");
                System.out.println("Fetched propertyName: " + propertyName); // Debugging
                propertyNames.add(propertyName);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving property names: " + e.getMessage());
            e.printStackTrace();
        }

        return propertyNames;
    }

}
