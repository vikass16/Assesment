package exceptionhandling.customException;

public class Test {
    double balance;

    Test(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount) throws Exception{
        if(amount > balance){
            throw new CustomException();
        }
        balance -= amount;
    }
}
