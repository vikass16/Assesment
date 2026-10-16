package projects.oops;


// Banking Application Demonstrating Encapsulation, Inheritance, Polymorphism and Abstraction Concept.
public class Main {
    public static void main(String[] args) {
        BankAccount s1 = new SavingAccount("Vikas","752399",20000);
        BankAccount s2 = new SavingAccount("Vipin", "812781",40000);

        BankAccount c1 = new CurrentAccount("Vishnu","61238124", 35000);
        BankAccount c2 = new CurrentAccount("Atul","974981",98300);

        s1.showInitialDetails();
//        s2.showInitialDetails();
//        c1.showInitialDetails();
//        c2.showInitialDetails();

        s1.deposit(3000);
        s1.withdraw(5000);
        s1.remainingBankBalance();
        s1.showInitialDetails();


    }
}
