package java8features.useofFIandLambda;


// Runnable Interface has only one Abstract method ( abstract void run(); )
public class MyRunnableClass implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i +"Hii");
        }
    }
}
