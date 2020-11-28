package com.company;

import java.sql.*;

public class Bus_Assignment {
    public static void main(String[] args) throws SQLException {
        String url = "JDBC:mysql://localhost:3306/bus_assignment?serverTimezone=UTC";
        String user = "ticket_booker";
        String password = "ticketbooker";

        // connect to database
        Connection bus_assignment_db = DriverManager.getConnection(url, user, password);

        //create bus
        String model_nr = "12345";
        Integer capacity = 40;

        //int firstBus = AddBus(bus_assignment_db, model_nr, capacity);
        //displayBusses(bus_assignment_db);

        //create route
        String start_stop = "Oslo";
        String end_stop = "Trondheim";
        String expected_time = "17:35";

        //int firstRoute = AddRoute(bus_assignment_db, start_stop, end_stop, expected_time);

        //create trip
        String trip_name = "First Trip";
        String trip_date = "21.01.07.";
        Integer bus_id = 3;
        Integer route_id = 1;

        //int firstTrip = AddTrip(bus_assignment_db, trip_name, trip_date, bus_id, route_id);

        //create passenger
        String first_name = "Csilla";
        String last_name = "Posa";

        int firstPassenger = AddPassenger(bus_assignment_db, first_name, last_name);
    }

    // method to add busses
    private static int AddBus(Connection bus_assignment_db, String model_nr, Integer capacity) throws SQLException {
        PreparedStatement addBus = bus_assignment_db.prepareStatement("INSERT INTO bus (model_nr, capacity) " +
                "VALUES (?, ?)");
        addBus.setString(1, model_nr);
        addBus.setInt(2, capacity);
        return addBus.executeUpdate();
    }

    // method to display busses
    private static void displayBusses(Connection bus_assignment_db) throws SQLException {
        PreparedStatement displayStatement = bus_assignment_db.prepareStatement("SELECT * FROM bus_assignment.bus");

        ResultSet busTable = displayStatement.executeQuery();

        while (busTable.next()) {
            System.out.println(busTable.getString("bus_id") + " " + busTable.getString("model_nr")
                    + " " + busTable.getString("capacity"));
        }
    }

    // method to create new routes
    private static int AddRoute(Connection bus_assignment_db, String start_stop, String end_stop, String expected_time)
            throws SQLException {
        PreparedStatement addRoute = bus_assignment_db.prepareStatement("INSERT INTO route " +
                "(start_stop, end_stop, expected_time) VALUES (?, ?, ?)");
        addRoute.setString(1, start_stop);
        addRoute.setString(2, end_stop);
        addRoute.setString(3, expected_time);
        return addRoute.executeUpdate();
    }

    // method to create new trips
    private static int AddTrip(Connection bus_assignment_db, String trip_name, String trip_date, Integer bus_id, Integer route_id) throws SQLException {
        PreparedStatement addTrip = bus_assignment_db.prepareStatement("INSERT INTO trip (trip_name, trip_date, bus_id, route_id) VALUES (?, ?, ?, ?)");
        addTrip.setString(1, trip_name);
        addTrip.setString(2, trip_date);
        addTrip.setInt(3, bus_id);
        addTrip.setInt(4, route_id);
        return addTrip.executeUpdate();
    }

    //method for registering a passenger
    private static int AddPassenger(Connection bus_assignment_db, String first_name, String last_name) throws SQLException {
        PreparedStatement addPassenger = bus_assignment_db.prepareStatement("INSERT INTO passenger (first_name, last_name) VALUES (?, ?)");
        addPassenger.setString(1, first_name);
        addPassenger.setString(2, last_name);
        return addPassenger.executeUpdate();
    }
    
}
