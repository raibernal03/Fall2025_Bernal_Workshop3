package logic;

import java.util.List;
import java.util.Scanner;

public class SearchBy {
    //display products based on name
    public static void keyword(String keyword1,Scanner scanner, List<Product> products) {
        //enter key word

        System.out.printf("%-10s │ %-30s │ $%-10s │ %-15s\n", "SKU", "NAME", "PRICE", "DEPARTMENT");
        System.out.println("───────────────────────────────────────────────────────────────────────────");
        for(Product product: products){
            //condition to see if the keyword matches
            if (product.getProductName().toLowerCase().contains(keyword1.toLowerCase())){
                System.out.printf("%-10s │ %-30s │ $%-10.2f │ %-15s\n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
            }
        }
    }

    //display products based on Dept

    public static void department(Scanner scanner, List<Product> products, int choice) {

        switch (choice) {
            case 1:
                FileManager.headerLogo("src/main/resources/smiski-ascii.txt");
                typeOf(products, "Smiski");
                break;
            case 2:
                FileManager.headerLogo("src/main/resources/labubu-ascii.txt");
                typeOf(products, "labubu");

                break;
            case 3:
                FileManager.headerLogo("src/main/resources/hirono-ascii.txt");
                typeOf(products, "hirono");
                break;
            case 4:
                FileManager.headerLogo("src/main/resources/skullpanda-collection.txt");
                typeOf(products, "skullpanda");
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void typeOf(List<Product> products, String type) {
        System.out.printf("%-10s │ %-30s │ $%-10s │ %-15s\n", "SKU", "NAME", "PRICE", "DEPARTMENT");
        System.out.println("───────────────────────────────────────────────────────────────────────────");

        for (Product product: products) {
            if(product.getDepartment().equalsIgnoreCase(type)){
                System.out.printf("%-10s │ %-30s │ $%-10.2f │ %-15s\n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
            }
        }
    }

    //display based on price range
    public static void priceRange(double min,double max, List<Product> products) {
        System.out.printf("%-10s │ %-30s │ $%-10s │ %-15s\n", "SKU", "NAME", "PRICE", "DEPARTMENT");
        System.out.println("───────────────────────────────────────────────────────────────────────────");
        for (Product product: products){
            if (product.getPrice() >= min && product.getPrice() <= max){
                System.out.printf("%-10s │ %-30s │ $%-10.2f │ %-15s\n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
            }
        }
    }

}
