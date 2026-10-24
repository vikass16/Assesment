package assesment;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {2,0,5,6,0,1,0};
        int i=0;
        int ct = 0;
        while(i < arr.length){
            if(arr[i] != 0){
                arr[ct++] = arr[i];
            }
            i++;
        }
        while (ct < arr.length){
            arr[ct++]= 0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
