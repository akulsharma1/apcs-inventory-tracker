package inventory;

import java.util.*;
public class ProductList {
    private ArrayList<Product> products;
    public ProductList(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
