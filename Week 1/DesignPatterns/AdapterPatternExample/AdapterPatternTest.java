public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PaypalGateway());
        payPalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.0);
    }
}
