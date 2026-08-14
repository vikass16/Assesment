package recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3,2,1,18,9};
        int index = 0;
        int target = 9;
        System.out.println(lsearch(arr,index,target));
    }

    public static int lsearch(int[] arr, int index, int target){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return lsearch(arr, index+1,target);
    }
}
