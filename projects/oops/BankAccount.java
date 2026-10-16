package projects.oops;

abstract class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double bankBalance;


    BankAccount(String accountHolder, String accountNumber, double bankBalance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.bankBalance = bankBalance;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getBankBalance(){
        return bankBalance;
    }
    public void setBankBalance(double balance){
        this.bankBalance = balance;
    }


    public void deposit(double amount){
        if(amount > 0){
            bankBalance += amount;
            System.out.println("Money deposited to "+getAccountHolder()+" account. New Balance is : "+bankBalance);
        }else{
            System.out.println("Enter Valid Amount !!");
        }
    }

    public void showInitialDetails(){
        System.out.println("Account Holder name : "+accountHolder+
                " || Account Number : "+accountNumber+" || BankBalance : "+bankBalance);
    }
    public void remainingBankBalance(){
        System.out.println("Remaining Balance : "+getBankBalance());
    }

    abstract void withdraw(double bankBalance);
}


class SavingAccount extends BankAccount{
    SavingAccount(String accountHolder, String accountNumber, double bankBalance){
        super(accountHolder,accountNumber,bankBalance);
    }

    @Override
    void withdraw(double amount) {
        if(amount < 0 ){
            System.out.println("Enter Valid amount..");
        }else if(amount > getBankBalance()){
            System.out.println("Insufficient Bank Balance");
        }else{
            setBankBalance(getBankBalance()-amount);
            System.out.println("Money withdrawal successfully from "+getAccountHolder()+" account. Remaining amount : "+getBankBalance());
        }
    }
}

class CurrentAccount extends BankAccount{
    final double minimunAmount = 5000;
    CurrentAccount(String accountHolder, String accountNumber, double bankBalance){
        super(accountHolder,accountNumber,bankBalance);
    }

    @Override
    void withdraw(double amount) {
        if(minimunAmount < getBankBalance()-amount){
            System.out.println("Insufficient Amount!!!!");
        }else if(amount  < 0){
            System.out.println("Please Enter Valid amount..");
        }else{
            setBankBalance(getBankBalance()-amount);
            System.out.println("Money withdraw successfully from "+getAccountHolder()+" account. Remaining amount : "+getBankBalance());
        }
    }
}