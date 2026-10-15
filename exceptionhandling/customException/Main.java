package exceptionhandling.customException;

public class Main {
    public static void main(String[] args) {
        Test test = new Test(10);

        try {
            test.withdraw(25);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
