package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class editStock {
    public static void EditStock(Scanner in, ArrayList<ArrayList<Object>> data) {
        Connection conn = Main.connect();
        String sql = "";
        try {
            System.out.println("Enter the ID of the product you'd like to edit the stock of: ");
            int searching = in.nextInt();

            System.out.println("Enter new value: ");
            int newStock = in.nextInt();
            sql = "UPDATE products SET PRODUCT_STOCK = ? WHERE ID = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, newStock);
            preparedStmt.setInt(2,searching);
            preparedStmt.executeUpdate();
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

