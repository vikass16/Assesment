package recursion;

public class Print1To5 {
    public static void main(String[] args) {
        // write a function that prints 1 to 5
        print(1);
        print1(5);
        printReverse(5);
    }

    static void print(int n){
        if(n == 5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }

    static void print1(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        print1(n-1);
        System.out.println(n);

    }

    static void printReverse(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printReverse(n-1);
    }
}
