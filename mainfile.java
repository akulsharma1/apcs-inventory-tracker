
import java.util.*;
import managerfunctions.*;
public class mainfile {
    public static void main(String[] args) {
        ArrayList<inventory.Variant> variants = new ArrayList<inventory.Variant>();
        variants.add(new inventory.Variant("Red", "3", "Small", "./images/red.jpg", 10, 10.0));
        //CreateProduct.AddProduct(new inventory.Product("tanmay", "3", variants));
        DeleteProduct.DeleteItem("3");
        EditProduct.EditItem(new inventory.Product("tanmay edited", "2", variants));
    }
}
