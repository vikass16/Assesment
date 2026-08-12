package recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibb(5));
    }

    public static int fibb(int n){
        if(n == 1 || n == 0){
            return n;
        }

        return fibb(n-1) + fibb(n-2);
    }
}
