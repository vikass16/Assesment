package assesment;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,8,11,23,45,65};
        int target = 14;
        System.out.println(floor(arr,target));
    }

    public static int floor(int[] arr, int target){
        int start  = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if(arr[mid] > target){
                end = mid-1;
            }else if(arr[mid] < target){
                start = mid+1;
            }else{
                return arr[mid];
            }
        }
        return arr[end];
    }
}
