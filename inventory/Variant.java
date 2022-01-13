package inventory;

public class Variant {
    private String variantName;
    private String variantID;
    private String size;
    private String image;
    private int quantity;
    private double price;

    public Variant(String variantName, String variantID, String size, String image, int quantity, double price) {
        this.variantName = variantName;
        this.variantID = variantID;
        this.size = size;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public String getVariantName() {
        return variantName;
    }

    public String getVariantID() {
        return variantID;
    }
    public String getSize() {
        return size;
    }
    public String getImage() {
        return image;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
}
