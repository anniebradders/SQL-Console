package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EditProduct {
    public static void editProducts(Scanner in, ArrayList<ArrayList<Object>> data) {
        Connection conn = Main.connect();
        String sql = "";
        try {
            System.out.println("Enter the ID of the product you'd like to edit: ");
            int searching = in.nextInt();

            System.out.println("Would you like to change:" +
                    "\n1. Product Name" +
                    "\n2. Product Price" +
                    "\n3. Product Location" +
                    "\n4. Stock Quantity");
            int change = in.nextInt();

            if(change == 1){
                in.nextLine();
                System.out.println("Enter the new value: ");
                String newName = in.nextLine();
                sql = "UPDATE products SET PRODUCT_NAME = ? WHERE ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, newName);
                preparedStmt.setInt(2,searching);
                preparedStmt.executeUpdate();
            }else if(change == 2){
                System.out.println("Enter new value: ");
                int newPrice = in.nextInt();
                sql = "UPDATE products SET PRODUCT_PRICE = ? WHERE ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, newPrice);
                preparedStmt.setInt(2,searching);
                preparedStmt.executeUpdate();
            }else if(change == 3){
                in.nextLine();
                System.out.println("Enter the new value: ");
                String newLoc = in.nextLine();
                sql = "UPDATE products SET PRODUCT_LOCATION = ? WHERE ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString(1, newLoc);
                preparedStmt.setInt(2,searching);
                preparedStmt.executeUpdate();
            }else if(change == 4){
                System.out.println("Enter new value: ");
                int newStock = in.nextInt();
                sql = "UPDATE products SET PRODUCT_STOCK = ? WHERE ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt(1, newStock);
                preparedStmt.setInt(2,searching);
                preparedStmt.executeUpdate();
            }
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
