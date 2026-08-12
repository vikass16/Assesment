package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,9,11};

        System.out.println(bsearch(arr,3,0,arr.length-1));
    }

    public static int bsearch(int[] arr, int target, int start, int end){
        if(start > end){
            return 0;
        }
        int mid = start + (end-start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] > target){
            return bsearch(arr, target, start, mid-1);
        }
        return bsearch(arr, target, mid+1, end);
    }
}
