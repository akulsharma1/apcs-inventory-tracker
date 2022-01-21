package managerfunctions;

import java.io.IOException;

public class DeleteProduct {
    public static IOException DeleteItem(String productID) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.ProductList newproductlist = productlist;
        for (int i = 0; i < productlist.getProducts().size(); i++) {
            if (productlist.getProducts().get(i).getProductID().equals(productID)) {
                newproductlist.getProducts().remove(i);
            }
        }
        IOException e = writeToFile.WriteProductListToFile(newproductlist);
        if (e != null) {
            DeleteItem(productID);
        }

        return null;
    }

    public static IOException DeleteVariant(String productID, String variantID) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.ProductList newproductlist = productlist;
        for (int i = 0; i < productlist.getProducts().size(); i++) {
            if (productlist.getProducts().get(i).getProductID().equals(productID)) {
                for (int j = 0; j < productlist.getProducts().get(i).getVariants().size(); j++) {
                    if (productlist.getProducts().get(i).getVariants().get(j).getVariantID().equals(variantID)) {
                        newproductlist.getProducts().get(i).getVariants().remove(j);
                    }
                }
            }
        }
        IOException e = writeToFile.WriteProductListToFile(newproductlist);
        if (e != null) {
            DeleteVariant(productID, variantID);
        }

        return null;
        
    }
}
