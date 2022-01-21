package managerfunctions;

import java.io.*;
import java.nio.file.*;

import com.google.gson.*;

public class writeToFile {
    public static IOException WriteProductListToFile(inventory.ProductList productlist) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer writer = Files.newBufferedWriter(Paths.get("./inventory/inventory.json"));
            gson.toJson(productlist, writer);
            writer.close();
            return null;
        } catch (IOException e) {
            return e;
        }
    }
}
