package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = FileManager.inventory();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            FileManager.headerLogo("src/main/resources/trinket-shop-ascii.txt");

            System.out.println("Index Options: ");
            System.out.println("1| Display All");
            System.out.println("2| Filtered Display");
            System.out.println("3| View Shopping Cart");
            System.out.println("4| Exit");
            System.out.print("--> ");

            int choice = Integer.parseInt(scanner.nextLine());

            // getting out list
            switch (choice) {
                case 1:
                    displayAll(products);
                    break;
                case 2:
                    filteredDisplay(scanner, products);
                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    //display all
    public static void displayAll(List<Product> products) {
        System.out.printf("%-10s │ %-30s │ $%-10s │ %-15s\n", "SKU", "NAME", "PRICE", "DEPARTMENT");

        System.out.println("───────────────────────────────────────────────────────────────────────────");

        for (Product product : products) {
            System.out.printf("%-10s │ %-30s │ $%-10.2f │ %-15s\n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
        }
    }

    public static void filteredDisplay(Scanner scanner, List<Product> products) {
        System.out.println("Filter By:" +
                "\n1| Keyword" +
                "\n2| Department" + "\n3| Price" + "\n4| Back" + "\n5| Exit");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.print("Enter Keyword: ");
                String keyword = scanner.nextLine();
                SearchBy.keyword(keyword,scanner, products);
                break;
            case 2:
                FileManager.headerLogo("src/main/resources/search-by-department-ascii.txt");
                System.out.println("Choose a department to filter:");
                System.out.println("1| Smiski");
                System.out.println("2| Labubu");
                System.out.println("3| Hirono");
                System.out.println("4| SkullPanda");
                System.out.println("5| Back");
                System.out.print("--> ");
                int choice1 = Integer.parseInt(scanner.nextLine());
                SearchBy.department(scanner, products, choice1);
                break;
            case 3:
                FileManager.headerLogo("src/main/resources/search-by-price-ascii.txt");
                System.out.print("Min Amount: ");
                double min =  Double.parseDouble(scanner.nextLine());
                System.out.print("Max Amount: ");
                double max =  Double.parseDouble(scanner.nextLine());
                SearchBy.priceRange(min,max, products);
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                filteredDisplay(scanner, products);
                break;
        }
    }

}

/*
 *
 * Menu:
 * -->Display all ✅
 * -->search by department, name, sku, price range
 * -->See Shopping cart
 * -->Exit
 *
 *
 * */
