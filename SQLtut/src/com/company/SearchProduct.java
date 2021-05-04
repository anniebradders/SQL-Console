package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchProduct {
    public static void searchProducts(Scanner in, ArrayList<ArrayList<Object>> data) {
        Connection conn = Main.connect();
        try {
            System.out.println("Enter ID of product you'd like to search: ");
            int searching = in.nextInt();

            String sql = "SELECT * FROM products WHERE ID = ?";

            data = new ArrayList<ArrayList<Object>>();

            PreparedStatement found = conn.prepareStatement(sql);
            found.setInt(1, searching);
            ResultSet rs = found.executeQuery();
            {
                while(rs.next()) {
                    String id = rs.getString("ID");
                    String prodId = rs.getString("PRODUCT_ID");
                    String prodName = rs.getString("PRODUCT_NAME");
                    String prodPrice = rs.getString("PRODUCT_PRICE");
                    String prodLocation = rs.getString("PRODUCT_LOCATION");
                    String prodQuan = rs.getString("PRODUCT_STOCK");

                    ArrayList<Object> search2 = new ArrayList<>();
                    search2.add(id);
                    search2.add(prodId);
                    search2.add(prodName);
                    search2.add("£" + prodPrice);
                    search2.add(prodLocation);
                    search2.add(prodQuan);

                    data.add(search2);
                }
            }
            Main.printData(data);
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
