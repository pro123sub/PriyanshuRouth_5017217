import java.util.Map;
import java.util.Scanner;

public class AddproductCommand implements Commands{
    private   InventoryManagement inventoryManagement;
    private  Scanner scanner;
    public AddproductCommand(InventoryManagement inventoryManagement, Scanner scanner) {
        this.inventoryManagement = inventoryManagement;
        this.scanner = scanner;
    }

    @Override
    public void executeCommands() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        Product product = new Product(id, name, quantity, price);
        inventoryManagement.addProduct(product);
    }
}
class UpdateProductCommand implements Commands {
    private   InventoryManagement inventoryManagement;
    private  Scanner scanner;

    public UpdateProductCommand(InventoryManagement inventoryManagement, Scanner scanner) {
        this.inventoryManagement = inventoryManagement;
        this.scanner = scanner;
    }

    @Override
    public void executeCommands() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter New Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        Product updatedProduct = new Product(id, name, quantity, price);
        inventoryManagement.updateProduct(id, updatedProduct);
    }
}
class DeleteProductCommand implements Commands {
    private InventoryManagement inventoryManagement;
    private Scanner scanner;

    public DeleteProductCommand(InventoryManagement inventoryManagement, Scanner scanner) {
        this.inventoryManagement = inventoryManagement;
        this.scanner = scanner;
    }


    @Override
    public void executeCommands() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();
        inventoryManagement.deleteProduct(id);
    }
}

class GetProductCommand implements Commands {
    private InventoryManagement inventoryManagement;
    private Scanner scanner;

    public GetProductCommand(InventoryManagement inventoryManagement, Scanner scanner) {
        this.inventoryManagement = inventoryManagement;
        this.scanner = scanner;
    }
    @Override
    public void executeCommands() {
        System.out.print("Enter Product ID to get details: ");
        String id = scanner.nextLine();
        Map retrievedProduct = inventoryManagement.getProductDetails(id);
        if (retrievedProduct != null) {
            System.out.println("Product found: " + retrievedProduct);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }
}
