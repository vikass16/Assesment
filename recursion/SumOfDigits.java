package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int res = sumdigits(1235);
        System.out.println(res);
    }

    static int sumdigits(int n){
        if(n == 1){
            return n;
        }

        return (n%10) + sumdigits(n/10);
    }
}
