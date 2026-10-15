package exceptionhandling.customException;

import org.w3c.dom.ls.LSOutput;

public class CustomException extends Exception{
    public CustomException(){
        super("you don't have enough money to withdraw");
    }
}
