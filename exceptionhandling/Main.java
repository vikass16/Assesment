package exceptionhandling;

public class Main {
    public static void main(String[] args) {
        int[] nominator = {10,20,30,40};
        int[] denominator = {1,2,0,3};
        for(int i=0; i<7; i++){
            try{
                System.out.println(divide(nominator[i],denominator[i]));
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of Index "+e);
            }

        }
        System.out.println("Exception Handled Gracefully using Try-catch block");
    }

//    public static int divide(int a, int b){
//        return a/b;
//    }

    public static int divide(int a, int b){
        try {
            return a/b;
        }catch (ArithmeticException e){
            System.out.println(e);
            return -1;
        }
    }
}
