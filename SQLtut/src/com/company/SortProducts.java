package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SortProducts {

    public static void sortProducts(Scanner in, ArrayList<ArrayList<Object>> data) {
        Connection conn = Main.connect();
        String sql = "";
        try {
            System.out.println("Sort products by:" +
                    "\n1.Price (High - Low)" +
                    "\n2.Price (Low - High)");
            int option = in.nextInt();

            if (option == 1) {
                sql = "SELECT * FROM products ORDER BY PRODUCT_PRICE DESC";
            } else if (option == 2) {
                sql = "SELECT * FROM products ORDER BY PRODUCT_PRICE";
            }

            Statement state = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();
            ResultSet order = state.executeQuery(sql);
            {
                while (order.next()) {
                    String id = order.getString("ID");
                    String prodId = order.getString("PRODUCT_ID");
                    String prodName = order.getString("PRODUCT_NAME");
                    String prodPrice = order.getString("PRODUCT_PRICE");
                    String prodLocation = order.getString("PRODUCT_LOCATION");
                    String prodQuan = order.getString("PRODUCT_STOCK");

                    ArrayList<Object> rec = new ArrayList<Object>();
                    rec.add(id);
                    rec.add(prodId);
                    rec.add(prodName);
                    rec.add("£" + prodPrice);
                    rec.add(prodLocation);
                    rec.add(prodQuan);

                    data.add(rec);

                }
            }

            Main.printData(data);
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


