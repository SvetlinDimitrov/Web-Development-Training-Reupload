public class Problem_6 {
    /*
    Given a sorted array of non-negative distinct integers, find the smallest missing non-negative element in it.
    For example,

    Input:  nums[] = [0, 1, 2, 6, 9, 11, 15]
    Output: The smallest missing element is 3


    Input:  nums[] = [1, 2, 3, 4, 6, 9, 11, 15]
    Output: The smallest missing element is 0


    Input:  nums[] = [0, 1, 2, 3, 4, 5, 6]
    Output: The smallest missing element is 7
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6, 9, 11, 15};
        System.out.println(BS(nums));
    }

    //    public static int BS(int [] nums){
//
//        int start = 0;
//        int end = nums.length-1;
//
//        while(start <= end){
//            int mid = start +(end-start)/2;
//            if(mid != nums[mid]){
//                end = mid -1;
//            }else{
//                start = mid+1;
//            }
//        }
//
//        return start;
//    }
    public static int BS(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    public static int helper(int[] nums, int start, int end){
        if(start > end){return  start;}
        int mid = start + (end -start)/2;
        if(mid != nums[mid]){return helper(nums , start , mid-1);}
        else{return helper(nums , mid+1 , end);}
    }
}
