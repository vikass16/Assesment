package java8features.useofFIandLambda;

public class Main {
    public static void main(String[] args) {

        // Without using Lambda Expression (We need a SoftwareEngineer implementation Class)
//        Employee employee = new SoftwareEngineer();
//        System.out.println(employee.getName());  // Output : Software Engineer

        // Use of Lambda Expression (We don't need a Separate SoftwareEngineer implementation Class here)
        Employee employee = () -> "Software Engineer!!";
        System.out.println(employee.getName());

        // Similarly like this (We don't need another implementation class here, We can directly implement using lambda Expression)
        Employee editor = () -> "Editor hu bhai..";
        System.out.println(editor.getName());


        /* If I have a Single Abstract method in Interface then we don't need to write Multiple implementation class.
         We can Implementation same abstract method in main class using Lambda Expression Without creating class.
         */


        // This one is for MyRunnableClass (Without Using Lambda , Using implementation class MyRunnableClass)
        MyRunnableClass myRunnableClass = new MyRunnableClass();
        Thread thread = new Thread(myRunnableClass);
        thread.run();

        // We can Directly use abstract method of Runnable Interface without even creating MyRunnableClass Class Using Lambda Expression(Using Lambda , Without using implementation class MyRunnableClass)

        Runnable runnable = () -> {
            for (int i=1; i<=10; i++){
                System.out.println(i+"Bye");
            }
        };
        Thread th = new Thread(runnable);
        th.run();
    }
}

