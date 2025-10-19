package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filter {

    //name and department
    public static void keyword(String keyword, List<Product> products) {
        List<Product> filteredList = new ArrayList<>();

        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(keyword.toLowerCase()) || product.getDepartment().toLowerCase().contains(keyword.toLowerCase())) {
                filteredList.add(product);
            }
        }

        Main.printList(filteredList);


    }

    //price range
    public static void priceRange(List<Product> products, double min, double max) {
        List<Product> range = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                range.add(product);
            }

        }

        Main.printList(range);
    }



}