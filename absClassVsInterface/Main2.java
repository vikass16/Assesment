package absClassVsInterface;

interface Payment{

    void pay(double amount); // Only abstract method it has to be implemented in main class

}

class CreditCard implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Payment "+amount+" using CreditCard");
    }
}

class UPI implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Payment "+amount+" using UPI");
    }
}

class PayPal implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Payment "+amount+" using PayPal");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Payment p1 = new CreditCard();
        Payment p2 = new UPI();
        Payment p3 = new PayPal();

        p1.pay(2000);
        p2.pay(1220);
        p3.pay(9800);
    }
}
