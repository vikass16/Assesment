package exceptionhandling.customException;

public class CustomException extends Exception{
    public CustomException(){
        super("you don't have enough money to withdraw");
    }
}
