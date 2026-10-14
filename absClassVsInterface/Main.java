package absClassVsInterface;

abstract class BankAccount{

    // Common Attributes
    String accountNumber;
    String holderName;
    double balance;

    BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Common Behaviour for Every account
    void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    // Each Account(classes) have their own behaviour [that's why it is declared as abstract method]
    abstract void withdraw(double amount);// An Abstract method can't have body

    void showBalance(){
        System.out.println("Balance is : "+balance);
    }

}


class SavingClass extends BankAccount{
    SavingClass(String accountNumber, String holderName, double balance){
        super(accountNumber,holderName,balance);
    }

    @Override
    void withdraw(double amount) {
        if(amount > 0 && amount <= balance){
            System.out.println("Amount withdrawal Successfully from Saving Account Class");
        }else{
            System.out.println("Insufficient Amount!!");
        }
    }
}


class CurrentClass extends BankAccount{
    private double overDraftLimit = 5000;
    CurrentClass(String accountNumber, String holderName, double balance){
        super(accountNumber,holderName,balance);
    }

    @Override
    void withdraw(double amount) {
        if(amount > 0 && amount < balance+overDraftLimit){
            System.out.println("Amount Withdrawal Successfully from Current Class");
        }else{
            System.out.println("InSufficient Amount!!");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount aClass = new SavingClass("2","Vikas", 8000);
        BankAccount bClass = new CurrentClass("4","Vipin",12000);

        // Shared Data
        aClass.deposit(7800);
        bClass.deposit(3200);

        aClass.showBalance();
        bClass.showBalance();

        // Own implemented Data
        aClass.withdraw(1200);
        bClass.withdraw(9800);
    }
}
