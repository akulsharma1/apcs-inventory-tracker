package inventory;

import java.util.*;

import managerfunctions.Readproducts;
public class ProductList {
    private ArrayList<Product> products;
    public ProductList(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public inventory.Product getProduct(String productID) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        for (inventory.Product product : productlist.getProducts()) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }
}
