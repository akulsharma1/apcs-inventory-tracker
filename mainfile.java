
import java.util.*;
import managerfunctions.*;
import com.jakewharton.fliptables.*;

import inventory.Product;
public class mainfile {

    public static String characterList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static String returnRandomString() {
        int index = (int)(Math.random() * ((27) + 1));
        return characterList.substring(index, index + 1);
    }
    public static String returnUUID() {
        String uuid = "";
        for (int i = 0; i < 5; i++) {
            uuid += returnRandomString();
        }
        return uuid;
    }

    public static void printProductMenu(inventory.ProductList productList) {
        String[] headers = {"Product ID", "Product Name", "Variants"};
        String[][] data = new String[productList.getProducts().size()][3];
        for (int i = 0; i < productList.getProducts().size(); i++) {
            data[i][0] = productList.getProducts().get(i).getProductID();
            data[i][1] = productList.getProducts().get(i).getProductName();
            data[i][2] = productList.getProducts().get(i).toString();
        }
        System.out.println(FlipTable.of(headers, data));
    }

    public static void printProductVariants(inventory.Product product) {
        String[] headers = {"Variant ID", "Variant Name", "Size", "Quantity", "Price"};
        String[][] data = new String[product.getVariants().size()][5];
        for (int i = 0; i < product.getVariants().size(); i++) {
            data[i][0] = product.getVariants().get(i).getVariantID();
            data[i][1] = product.getVariants().get(i).getVariantName();
            data[i][2] = product.getVariants().get(i).getSize();
            data[i][3] = Integer.toString(product.getVariants().get(i).getQuantity());
            data[i][4] = Double.toString(product.getVariants().get(i).getPrice());
        }
        System.out.println(FlipTable.of(headers, data));
    }
    
    public static void mainMenu() {
        System.out.println("_ _______             _    \n(_)__   __|           | |   \n_   | |_ __ __ _  ___| | __\n| |  | | '__/ _` |/ __| |/ /\n| |  | | | | (_| | (__|   < \n|_|  |_|_|  \\__,_|\\___|_|\\_\\                          ");
        Scanner input = new Scanner(System.in);
        while (true) {
            printProductMenu(Readproducts.ReadProducts());
            System.out.println("Press 1 to create a product.\nPress 2 to edit a product.\nPress 3 to delete a product.\nPress 4 to exit.");
            int i = input.nextInt();
            input.nextLine();
            if (i == 1) {
                System.out.println("Enter Product Name: ");
                String productName = input.nextLine();
                String productID = returnUUID();
                CreateProduct.AddProduct(new Product(productName, productID, new ArrayList<inventory.Variant>()));
                while (true) {
                    System.out.println("Press 1 to add a variant.\nPress 2 to exit.");
                    int j = input.nextInt();
                    input.nextLine();
                    if (j == 1) {
                        System.out.println("Enter Variant Name: ");
                        String variantName = input.nextLine();
                        String variantID = returnUUID();
                        System.out.println("Enter Size: ");
                        String size = input.nextLine();
                        System.out.println("Enter Quantity: ");
                        int quantity = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter Price: ");
                        double price = input.nextDouble();
                        input.nextLine();
                        CreateProduct.AddVariant(productID, variantName, variantID, size, "", quantity, price);
                    } else if (j == 2) {
                        break;
                    }
                }
            } else if (i == 2) {
                System.out.println("Enter Product ID: ");
                String productID = input.nextLine();
                inventory.Product product = Readproducts.ReadProducts().getProduct(productID);
                while (true) {
                    System.out.println("Press 1 to edit the product name.\nPress 2 to add a variant.\nPress 3 to edit a variant.\nPress 4 to delete a variant.\nPress 5 to exit.");
                    printProductVariants(product);
                    int j = input.nextInt();
                    input.nextLine();
                    if (j == 1) {
                        inventory.Product product2 = product;
                        System.out.println("Enter product name:");
                        String productName = input.nextLine();
                        product2.setProductName(productName);
                        EditProduct.EditItem(product2);
                    } else if (j == 3) {
                        System.out.println("Enter variant ID:");
                        String variantID = input.nextLine();
                        System.out.println("Enter variant name:");
                        String variantName = input.nextLine();
                        System.out.println("Enter size:");
                        String size = input.nextLine();
                        System.out.println("Enter quantity:");
                        int quantity = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter price:");
                        double price = input.nextDouble();
                        input.nextLine();
                        inventory.Variant variant = new inventory.Variant(variantName, variantID, size, "", quantity, price);
                        EditProduct.EditVariant(productID, variant);
                        product = Readproducts.ReadProducts().getProduct(productID);
                        printProductVariants(product);
                    } else if (j == 2) {
                        System.out.println("Enter variant name:");
                        String variantName = input.nextLine();
                        System.out.println("Enter size:");
                        String size = input.nextLine();
                        System.out.println("Enter quantity:");
                        int quantity = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter price:");
                        double price = input.nextDouble();
                        input.nextLine();
                        inventory.Variant variant = new inventory.Variant(variantName, returnUUID(), size, "", quantity, price);
                        CreateProduct.AddVariant(productID, variant);
                        product = Readproducts.ReadProducts().getProduct(productID);
                        printProductVariants(product);
                    } else if (j == 4) {
                        System.out.println("Enter variant ID:");
                        String variantID = input.nextLine();
                        DeleteProduct.DeleteVariant(productID, variantID);
                        product = Readproducts.ReadProducts().getProduct(productID);
                        printProductVariants(product);
                    } else {
                        break;
                    }
                }
            } else if (i == 3) {
                System.out.println("Enter Product ID: ");
                String productID = input.nextLine();
                DeleteProduct.DeleteItem(productID);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // ArrayList<inventory.Variant> variants = new ArrayList<inventory.Variant>();
        // variants.add(new inventory.Variant("Red", "3", "Small", "./images/red.jpg", 10, 10.0));
        // //CreateProduct.AddProduct(new inventory.Product("tanmay", "3", variants));
        // DeleteProduct.DeleteItem("3");
        // EditProduct.EditItem(new inventory.Product("tanmay edited", "2", variants));
        mainMenu();
    }
}
