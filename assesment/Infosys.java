package assesment;

import java.util.Scanner;

public class Infosys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int D = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=1; j<arr.length; j++){
                if(((arr[i] + arr[j]) % D == 0)  && (Math.abs(arr[i]-arr[j]) % M == 0)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
