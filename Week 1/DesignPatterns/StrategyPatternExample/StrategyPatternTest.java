import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        // Define a map to associate choices with actions
        Map<Integer, Runnable> paymentActions = new HashMap<>();

        // Define actions for each payment method
        paymentActions.put(1, () -> {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter card holder name: ");
            String cardHolderName = scanner.nextLine();
            System.out.print("Enter CVV: ");
            String cvv = scanner.nextLine();
            context.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName, cvv));
        });

        paymentActions.put(2, () -> {
            System.out.print("Enter PayPal email: ");
            String email = scanner.nextLine();
            System.out.print("Enter PayPal password: ");
            String password = scanner.nextLine();
            context.setPaymentStrategy(new PayPalPayment(email, password));
        });

        while (true) {
            System.out.println("Select payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            Runnable action = paymentActions.get(choice);
            if (action != null) {
                action.run();
                context.pay(amount);
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
