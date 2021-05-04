package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.DeleteProduct.productDelSelc;

public class AdminMenu {
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<ArrayList<Object>> data = null;
    public static String[] userDetails = Login.login(in, data);

    public static void adminMenu(Scanner in, ArrayList<ArrayList<Object>> data) {
        int menuChoice;
        boolean loop;
        String role = userDetails[2];
        if (role.equals("Admin") || role.equals("Employee")) {
            loop = true;
        } else {
            loop = false;
        }
        while (loop){
            if (role.equals("Admin")) {
                System.out.print("""
                        **** Menu ****
                        1. Delete Product 
                        2. Add Product
                        3. View Products 
                        4. Search for Products 
                        5. Sort Products By 
                        6. Edit Product 
                        7. Delete User
                        8. Add User 
                        9. Edit User 
                        10. Exit
                        Enter:  """);
                menuChoice = menuDecider.menuDecide(10, in);
                switch(menuChoice) {
                    case 1 -> {
                        DeleteProduct.deleteProduct(productDelSelc(in));
                    }
                    case 2 -> AddProduct.addProduct(in);
                    case 3 -> ViewProducts.viewProducts(data);
                    case 4 -> SearchProduct.searchProducts(in, data);
                    case 5 -> SortProducts.sortProducts(in, data);
                    case 6 -> EditProduct.editProducts(in, data);
                    case 7 -> DeleteUser.Delete(DeleteUser.userDelSelc(in));
                    case 8 -> AddUser.Add(in);
                    case 9 -> EditUser.ChangeDetails(in, username(userDetails));
                    case 10 -> {
                        System.out.println("Goodbye");
                        loop = false;
                    }
                }
            } else{
                System.out.println(
                        "**** Menu ****\n" +
                                "1. View Inventory\n" +
                                "2. Search Inventory\n" +
                                "3. Change stock of an item.\n" +
                                "4. Exit"
                );
                menuChoice = menuDecider.menuDecide(4, in);
                switch (menuChoice) {
                    case 1 -> {
                        ViewProducts.viewProducts(data);
                    }
                    case 2 -> SearchProduct.searchProducts(in, data);
                    case 3 -> editStock.EditStock(in,data);
                    case 4 -> {
                        System.out.println("Goodbye");
                        loop = false;
                    }
                }
            }
        }
    }

    public static String username(String[] userDetails){
        return userDetails[0];
    }

    public static String role(String[] userDetails){
        return userDetails[2];
    }
}

