public class Problem_5 {
    //Count occurrences of a number in a sorted array with duplicates

    /*
    Input:  nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
    target = 5
    Output: Target 5 occurs 3 times


    Input:  nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
    target = 6
    Output: Target 6 occurs 2 times
     */
    public static void main(String[] args) {
        int [] nums1 = new int []{2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int [] nums2 = new int []{2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target1 = 5;
        int target2 = 6;
        System.out.println(BS(nums1 , target1) == 3 && BS(nums2 , target2) == 2);
    }

    private static int BS(int[] arr, int target) {
        int start = helper(arr , target , false , 0 , arr.length-1, -1);
        int end = helper(arr , target , true, 0, arr.length - 1,-1);
        return start == -1 ? 0 : end - start +1;
    }
    private  static int helper(int[] arr, int target, boolean flag, int start, int end, int result){
        int mid = start + (end - start)/2;
        if(start > end){
            return result;
        }
        if(arr[mid] == target){
            if(!flag){
                return helper(arr,target,flag,start,mid-1,mid);
            }else{
                return helper(arr,target,flag,mid+1,end,mid);
            }
        }else if(arr[mid] > target){
            return helper(arr,target,flag,start,mid-1,result);
        }else{
            return helper(arr,target,flag,mid+1,end,result);
        }
    }
}