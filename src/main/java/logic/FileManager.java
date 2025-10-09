package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    //Will display header in ascii
    public static void headerLogo(String logoPath){
        try {
            FileReader fr = new FileReader(logoPath);

            //great the file is open now we need to go through it
            BufferedReader reader = new BufferedReader(fr);

            //Let's actually go through the file line by line
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
            reader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //will display all the products on products.csv
    public static List<Product> inventory(){
        List<Product> products = new ArrayList<>();
        try{
            FileReader fr = new FileReader("src/main/resources/products.csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split("\\|");
                Product product = new Product();

                product.setSku(itemData[0]);
                product.setProductName(itemData[1]);
                product.setPrice(Double.parseDouble(itemData[2]));
                product.setDepartment(itemData[3]);
                products.add(product);
            }

            reader.close();

        }catch (FileNotFoundException ex) {

            System.out.println("File not found");

        } catch(IOException ex) {

            System.out.println("Error reading file");

        }
        return products;
    }
}
