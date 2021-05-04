package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewProducts {

    public static void viewProducts (ArrayList<ArrayList<Object>> data){
        Connection conn = Main.connect();

        try {
            String sql = "SELECT * FROM products";

            Statement stmt  = conn.createStatement();
            data = new ArrayList<ArrayList<Object>>();

            ResultSet res = stmt.executeQuery(sql);
            {
                // loop through the result set
                while (res.next()) {

                    String id = res.getString("ID");
                    String prodId = res.getString("PRODUCT_ID");
                    String prodName = res.getString("PRODUCT_NAME");
                    String prodPrice = res.getString("PRODUCT_PRICE");
                    String prodLocation = res.getString("PRODUCT_LOCATION");
                    String prodQuan = res.getString("PRODUCT_STOCK");

                    ArrayList<Object> rec = new ArrayList<>();
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

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
