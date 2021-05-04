package com.company;

import java.sql.*;
import java.util.Scanner;

public class AddUser {

    public static void Add(Scanner in) {
        Connection conn = Main.connect();
        String admin = "";
        try {
            System.out.println("Please enter the details for the new user.");
            System.out.println("Enter the id: ");
            int id = in.nextInt();
            in.nextLine();
            System.out.println("Enter the username: ");
            String username = in.nextLine();
            System.out.println("Enter the password: ");
            String password = in.nextLine();
            System.out.println("Select the role:" +
                    "\n1. Admin" +
                    "\n2. Employee ");
            int option = in.nextInt();

            if(option == 1){
                admin = "Admin";
            }else if(option == 2){
                admin = "Employee";
            }

            String sql = "INSERT INTO users(ID,USERNAME,PASSWORD,ROLE)VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, admin);
            ps.executeUpdate();

            System.out.println("Database values added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
