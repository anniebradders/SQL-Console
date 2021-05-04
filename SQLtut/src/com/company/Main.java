package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Object>> data = null;
        AdminMenu.adminMenu(in, data);
    }

    public static Connection connect() {
        String fileName = "C:\\Users\\Annie\\OneDrive\\Documents\\YEAR 1\\Software Engineering\\SQLtut\\src\\inventory_db.db";
        String url = "jdbc:sqlite:" + fileName;
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void printData (ArrayList<ArrayList<Object>> data)
    {
        for(int i=0; i<data.size(); i++)
        {
            for (int j=0; j<data.get(i).size(); j++)
            {
                System.out.print(data.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}


