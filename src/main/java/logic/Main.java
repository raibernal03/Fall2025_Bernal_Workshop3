package logic;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = FileManager.inventory();

    public static void main(String[] args) {

        while (true) {
            home();
        }
    }
    //store home screen
    public static void home() {
        System.out.println("1) Display Products");
        System.out.println("2) Display Cart");
        System.out.println("0) Exit");
        System.out.print("--> ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //display screen
    public static void display() {
        boolean running = true;
        while (running) {
            try {
                System.out.println("1) Display All Products");
                System.out.println("2) Filter Display");
                System.out.println("0) Back");
                System.out.print("--> ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        printList(products);
                        addToShoppingCart();
                        break;
                    case 2:
                        filters();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    //filter display menu
    public static void filters() {
        boolean running = true;
        while (running) {
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
                        break;
                    case 'D':
                        System.out.print("Enter Department: ");
                        keyword = scanner.nextLine();
                        Filter.keyword(keyword, products);
                        break;
                    case 'P':
                        System.out.print("Enter a min price: ");
                        double min = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter a max price: ");
                        double max = Double.parseDouble(scanner.nextLine());
                        Filter.priceRange(products, min, max);
                        break;
                    case 'H':
                        home();
                        break;
                    case 'B':
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice, try again");
                }

                addToShoppingCart();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid choice, try again");
            }
        }
    }

    // Print any list
    public static void printList(List<Product> products) {
        System.out.printf("│ %-15s │ %-35s │ $%-10s │ %-12s │\n", "SKU", "PRODUCT NAME", "PRICE", "DEPARTMENT");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : products) {
            System.out.printf("│ %-15s │ %-35s │ %s%-10.2f │ %-12s │\n", product.getSku(), product.getProductName(), "$", product.getPrice(), product.getDepartment());

        }
        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }

    //asking if they want to add to shopping cart
    public static void addToShoppingCart() {
        System.out.print("Would you like to add an item to shopping cart y/n ? ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);
        switch (choice) {
            case 'N':
                break;
            case 'Y':
                System.out.print("Enter sku or name of item: ");
                String sku = scanner.nextLine();
                ShoppingCart.addToCart(products, sku);
                break;

        }

    }
}

