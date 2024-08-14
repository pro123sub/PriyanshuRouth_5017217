public class PayPalAdapter implements PaymentProcessor{
    private PaypalGateway paypalGateway;
    public PayPalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway=paypalGateway;
    }

    @Override
    public void processPayment(double ammount) {
        paypalGateway.makePayment(ammount);
    }
}
