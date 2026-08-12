package recursion;

public class Print1To5 {
    public static void main(String[] args) {
        // write a function that prints 1 to 5
        print(1);
    }

    static void print(int n){
        if(n == 5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }
}
