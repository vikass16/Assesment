package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,7,5,2,9};
        selection(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void selection(int[] arr, int lengthOfArray, int currentElement, int maximum){
        if(lengthOfArray == 0){
            return;
        }

        if(lengthOfArray > currentElement){
            if(arr[currentElement] > arr[maximum]){
                selection(arr,lengthOfArray,currentElement+1,currentElement);
            }else {
                selection(arr,lengthOfArray,currentElement+1,maximum);
            }
        }else{
            int temp = arr[lengthOfArray-1];
            arr[lengthOfArray-1] = arr[maximum];
            arr[maximum] = temp;

            selection(arr, lengthOfArray-1,0,0);
        }
    }
}
