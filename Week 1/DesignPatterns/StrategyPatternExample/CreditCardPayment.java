public class CreditCardPayment implements PaymentStrategy
{
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv)
    {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double ammount)
    {
        System.out.println("Paid " + ammount + " using Credit Card.");
    }
}
