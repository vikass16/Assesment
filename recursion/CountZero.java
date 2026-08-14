package recursion;

public class CountZero {
    public static void main(String[] args) {
        int res = counzero(103205,0);
        System.out.println(res);
    }

    static int counzero(int n, int count){
        if(n == 0){
            return count;
        }
        int rem = n%10;
        if(rem == 0){
            return counzero(n/10, count+1);
        }
        return counzero(n/10,count);
    }

}
