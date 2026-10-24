package assesment;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr ={2,3,5,1,7,6};
        int n = arr.length+1;  // This is the catch point (I have to add +1 in length because we are finding missing element)
        int num = (n * (n+1)) / 2;
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        System.out.println(num-sum);
    }
}
