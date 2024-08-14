import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private HashMap<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductID(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Map<String, Object> getProductDetails(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            Map<String, Object> productDetails = new HashMap<>();
            productDetails.put("Product ID", product.getProductID());
            productDetails.put("Product Name", product.getProductName());
            productDetails.put("Quantity", product.getQuantity());
            productDetails.put("Price", product.getPrice());
            productDetails.put("Total Price", product.getPrice() * product.getQuantity());
            return productDetails;
        }
        return null;
    }
}
