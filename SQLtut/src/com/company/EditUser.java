package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EditUser {
    public static void ChangeDetails(Scanner in, String username) {
        Connection conn = Main.connect();
        try {
            System.out.println("Database Connection Success!");
            int choose=0;
            System.out.println("Please choose:\n1:  Change username\n2:  Change password\n");
            choose= in.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Please enter the username you would like to change to:\n");
                    String newusername = in.next();
                    String sql = "UPDATE users SET USERNAME = ? WHERE USERNAME = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, newusername);
                    ps.setString(2, username);
                    ps.execute();
                    System.out.println("Success!");
                    return;
                case 2:
                    System.out.println("Please enter the password you would like to change to:\n");
                    String newpassword = in.next();
                    String sql2 = "UPDATE users SET PASSWORD=? WHERE USERNAME=?";
                    PreparedStatement pss = conn.prepareStatement(sql2);
                    pss.setString(1, newpassword);
                    pss.setString(2, username);
                    pss.execute();
                    System.out.println("Success!");
                    return;
            }

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
