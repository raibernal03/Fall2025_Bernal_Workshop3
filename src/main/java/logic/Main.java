package logic;


import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = FileManager.inventory();
        Scanner scanner = new Scanner(System.in);
        while(true){
            home(scanner, products);
        }
    }
    //store home screen
    public static void home(Scanner scanner, List<Product> products){
        System.out.println("1) Display Products");
        System.out.println("2) Display Cart");
        System.out.println("0) Exit");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                display(scanner, products);
                break;
            case 2:
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, try again");
        }
    }

    //display screen
    public static void display(Scanner scanner,List<Product> products){
        System.out.println("1) Display All Products");
        System.out.println("2) Filter Display");
        System.out.println("0) Back");
        System.out.print("--> ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                printList(FileManager.inventory());
                break;
            case 2:
                filters(scanner, products);
                break;
            case 0:
                home(scanner, products);
                break;
            default:
                System.out.println("Invalid choice, try again");
        }

    }

    //filter display menu
    public static void filters(Scanner scanner, List<Product> products){

        System.out.println("N) Search by Name");
        System.out.println("D) Search by Department");
        System.out.println("P) Search by Price Range");
        System.out.println("H) Home");
        System.out.println("B) Back");
        System.out.print("--> ");
        try {
            char choice = scanner.nextLine().toUpperCase().charAt(0);

            switch (choice) {
                case 'N':
                    System.out.print("Enter Name: ");
                    String keyword = scanner.nextLine();
                    Filter.keyword(keyword, products);
                    filters(scanner, products);
                    break;
                case 'D':
                    System.out.print("Enter Department: ");
                    keyword = scanner.nextLine();
                    Filter.keyword(keyword, products);
                    filters(scanner, products);
                    break;
                case 'P':
                    System.out.print("Enter a min price: ");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter a max price: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    Filter.priceRange(products, min, max);
                    filters(scanner, products);
                    break;
                case 'H':
                    break;
                case 'B':
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    filters(scanner, products);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Invalid choice, try again");
            filters(scanner, products);
        }
    }
    // Print any list
    public static void printList(List<Product> products) {
        System.out.printf("│ %-15s │ %-35s │ $%-10s │ %-12s │\n", "SKU", "PRODUCT NAME", "PRICE", "DEPARTMENT");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : products) {
            System.out.printf("│ %-15s │ %-35s │ %s%-10.2f │ %-12s │\n", product.getSku(),  product.getProductName(),"$", product.getPrice(), product.getDepartment());

        }
    }

    //asking if they want to add to shopping cart
    public static void addToShoppingCart(List<Product> products, Scanner scanner) {
        System.out.print("Would you like to add an item to shopping cart y/n ? ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);
         switch (choice){
             case 'N':
         }

    }
}

