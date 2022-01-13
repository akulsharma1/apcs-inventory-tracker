package managerfunctions;

import java.util.*;
public class CreateProduct {
    public static void AddProduct(String productName, String productID, ArrayList<inventory.Variant> variants) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.Product product = new inventory.Product(productName, productID, variants);
        productlist.getProducts().add(product);

    }
}
