package logic;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    static List<Product> cart = new ArrayList<>();


    //add to shopping cart
    public static void addToCart(List<Product> products, String keyword) {
        for (Product product : products) {
            if (product.getSku().toLowerCase().contains(keyword.toLowerCase()) || product.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                cart.add(product);
                System.out.println("✔️ " + product.getProductName() + " Added to cart");

            }
        }

    }

    // remove from shopping cart
    public static void removeFromCart(List<Product> products, String keyword) {
        for (Product product:products){
            if(product.getSku().toLowerCase().contains(keyword.toLowerCase()) || product.getProductName().toLowerCase().contains(keyword.toLowerCase())){
                cart.remove(product);
                System.out.println("✖️ " + product.getProductName() + " Removed to cart");

            }
        }
    }

    // view shopping cart with total


}
