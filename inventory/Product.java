package inventory;

import java.util.*;
public class Product {
    private String productName;
    private String productID;

    private ArrayList<Variant> variants;
    public Product(String productName, String productID) {
        this.productName = productName;
        this.productID = productID;
    }

    public Product(String productName, String productID, ArrayList<Variant> variants) {
        this.productName = productName;
        this.productID = productID;
        this.variants = variants;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public ArrayList<Variant> getVariants() {
        return variants;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String toString() {
        String variantList = "";
        for (int i = 0; i < variants.size(); i++) {
            variantList += variants.get(i).getVariantName() + ": " + variants.get(i).getSize()+",\n";
        }
        return variantList;
    }

}




