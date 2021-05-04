package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static int attempt = 0;
    public static String dataUsername = null;
    public static String dataPassword = null;
    public static String dataRole = null;
    public static String[] login(Scanner in, ArrayList<ArrayList<Object>> data) {
        Connection conn = Main.connect();
        String username = null;
        String password = null;

        try {
            System.out.println("Please enter your username:");
            username = in.next();
            System.out.println("Please enter your password:");
            password= in.next();
            String sql = "SELECT USERNAME, PASSWORD, ROLE FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            boolean success = false;
            while (rs.next()) {
                success = false;
                dataUsername = rs.getString("USERNAME");
                dataPassword = rs.getString("PASSWORD");
                dataRole = rs.getString("ROLE");
                if (dataUsername.equals(username) && dataPassword.equals(password)) {
                    System.out.println("Correct Login details!\nHello " + username);
                    success = true;
                }
                if (success) {
                    break;
                }
            }
            if (!success) {
                attempt+=1;
                if(attempt == 3){
                    System.out.println("Login Failed");
                    System.exit(0); //WANT TO GET RID OF
                }
                else {
                    System.out.println("Incorrect User Code\nYou have " + (3 - attempt) + " more attempt(s)");
                    login(in, data);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error! Username and/or password is incorrect.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        String[] userDetails = {username, password, dataRole};
        return userDetails;
    }
}
