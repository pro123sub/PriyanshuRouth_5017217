public interface PaymentProcessor {
    void processPayment(double ammount);
}
class PaypalGateway
{
    public void makePayment(double ammount)
    {
        System.out.println("Paying " + ammount + " using PayPal.");
    }
}
class StripeGateway
{
    public void makePayment(double ammount)
    {
        System.out.println("Paying " + ammount + " using Stripe.");
    }
}