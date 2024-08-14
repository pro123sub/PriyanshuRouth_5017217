public class Product
{
    public String productID;
    public String productName;
    public int quantity;
    public double price;
    public Product(String productId, String productName, int quantity, double price)
    {
        this.productID=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
    }
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
