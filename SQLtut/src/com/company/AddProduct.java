package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {
    public static void addProduct(Scanner in){
        Connection conn = Main.connect();
        try {
            System.out.println("Please enter the details for the new product.");
            System.out.println("Enter the id: ");
            int id = in.nextInt();
            System.out.println("Enter the product id: ");
            int pId = in.nextInt();
            in.nextLine();
            System.out.println("Enter the product name: ");
            String pName = in.nextLine();
            System.out.println("Enter the product price: ");
            int pPrice = in.nextInt();
            in.nextLine();
            System.out.println("Enter the product location: ");
            String pLoc = in.nextLine();
            System.out.println("Enter the stock Quantity: ");
            int pStock = in.nextInt();

            String sql = "INSERT INTO products(ID,PRODUCT_ID,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_LOCATION,PRODUCT_STOCK) VALUES(?,?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.setInt(2, pId);
            pstmt.setString(3, pName);
            pstmt.setInt(4, pPrice);
            pstmt.setString(5, pLoc);
            pstmt.setInt(6, pStock);

            pstmt.executeUpdate();

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
