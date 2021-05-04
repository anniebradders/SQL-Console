package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser {

    public static String userDelSelc(Scanner in){
        in.nextLine();
        System.out.println("Please enter the username of the user you'd like to delete: ");
        String userDel = in.nextLine();
        return userDel;
    }

    public static void Delete(String userDel) {
        Connection conn = Main.connect();
        try {
            System.out.println("Database Connection Success!");

            String sql = "DELETE FROM users WHERE USERNAME = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userDel);
            ps.executeUpdate();

            System.out.println("Selected Database values have been removed!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
