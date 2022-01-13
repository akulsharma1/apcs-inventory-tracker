package managerfunctions;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.google.gson.*;

public class CreateProduct {
    public static void AddProduct(String productName, String productID, ArrayList<inventory.Variant> variants) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.Product product = new inventory.Product(productName, productID, variants);
        productlist.getProducts().add(product);
        Gson gson = new Gson();
        
        try {
            Writer writer = Files.newBufferedWriter(Paths.get("./inventory/inventory.json"));
            gson.toJson(productlist, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
    }
}
