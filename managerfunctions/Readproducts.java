package managerfunctions;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;
public class Readproducts {
    public static inventory.ProductList ReadProducts() {
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("./inventory/inventory.json"));
            inventory.ProductList productlist = gson.fromJson(reader,inventory.ProductList.class);
            reader.close();
            return productlist;
        } catch (IOException e) {
            return null;
        }
    }
    
}
