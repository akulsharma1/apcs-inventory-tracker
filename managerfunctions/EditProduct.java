package managerfunctions;

import java.io.IOException;
public class EditProduct {
    public static void EditItem(inventory.Product product) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.ProductList newproductlist = productlist;
        for (int i = 0; i < productlist.getProducts().size(); i++) {
            if (productlist.getProducts().get(i).getProductID().equals(product.getProductID())) {
                newproductlist.getProducts().set(i, product);
            }
        }
        IOException error = writeToFile.WriteProductListToFile(newproductlist);
        if (error != null) {
            EditItem(product);
        }
    }

    public static void EditVariant(String productID, inventory.Variant variant) {
        inventory.ProductList productlist = Readproducts.ReadProducts();
        inventory.ProductList newproductlist = productlist;
        for (int i = 0; i < productlist.getProducts().size(); i++) {
            if (productlist.getProducts().get(i).getProductID().equals(productID)) {
                for (int j = 0; j < productlist.getProducts().get(i).getVariants().size(); j++) {
                    if (productlist.getProducts().get(i).getVariants().get(j).getVariantID().equals(variant.getVariantID())) {
                        newproductlist.getProducts().get(i).getVariants().set(j, variant);
                    }
                }
            }
        }
        IOException error = writeToFile.WriteProductListToFile(newproductlist);
        if (error != null) {
            EditVariant(productID, variant);
        }
    }
}
