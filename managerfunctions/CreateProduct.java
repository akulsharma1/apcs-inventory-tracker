package managerfunctions;

import java.io.IOException;
import java.util.*;


public class CreateProduct {

    public static void AddProduct(inventory.Product product) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        productlist.getProducts().add(product);
        IOException e = writeToFile.WriteProductListToFile(productlist);
        if (e != null) {
            AddProduct(product);
        }
    }
    public static void AddProduct(String productName, String productID, ArrayList<inventory.Variant> variants) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.Product product = new inventory.Product(productName, productID, variants);
        productlist.getProducts().add(product);
        IOException e = writeToFile.WriteProductListToFile(productlist);
        if (e != null) {
            AddProduct(productName, productID, variants);
        }
        
    }

    public static void AddVariant(String productID, String variantName, String variantID, String size, String image, int quantity, double price) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.Variant variant = new inventory.Variant(variantName, variantID, size, image, quantity, price);
        for (inventory.Product product : productlist.getProducts()) {
            if (product.getProductID().equals(productID)) {
                product.getVariants().add(variant);
            }
        }
        IOException e = writeToFile.WriteProductListToFile(productlist);
        if (e != null) {
            AddVariant(productID, variantName, variantID, size, image, quantity, price);
        }
        
    }

    public static void AddVariant(String productID, inventory.Variant variant) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        for (inventory.Product product : productlist.getProducts()) {
            if (product.getProductID().equals(productID)) {
                product.getVariants().add(variant);
            }
        }
        IOException e = writeToFile.WriteProductListToFile(productlist);
        if (e != null) {
            AddVariant(productID, variant);
        }
        
    }
}
