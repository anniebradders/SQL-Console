package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProduct {
    public static int productDelSelc(Scanner in){
        System.out.println("Please enter the ID of the product you'd like to delete: ");
        int productDel = in.nextInt();
        return productDel;
    }

    public static void deleteProduct(int productDel){
        String sql = "DELETE FROM products WHERE ID = ?";
        Connection conn = Main.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setInt(1, productDel);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("A record has been deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
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

