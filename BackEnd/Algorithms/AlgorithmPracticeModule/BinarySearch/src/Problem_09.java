public class Problem_09 {
    /*
    Find the number of 1’s in a sorted binary array

    Given a sorted binary array, efficiently count the total number of 1’s in it.

    For example,
    Input:  nums[] = [0, 0, 0, 0, 1, 1, 1]
    Output: The total number of 1’s present is 3


    Input:  nums[] = [0, 0, 1, 1, 1, 1, 1]
    Output: The total number of 1’s present is 5
     */
    public static void main(String[] args) {
        int [] nums = new int [] {0,1,1,1,1};
        System.out.println(BS(nums));
    }
    public static int BS (int[] nums){
        int start = helper(nums , 0 , nums.length-1 , true , -1);
        int end = helper(nums , 0 , nums.length-1 , false, -1);
        return start == -1 ? 0 : end - start +1;
    }
    private static int helper(int[] nums, int start, int end, boolean flag, int result){
        if(start > end){return  result;}
        int mid = start + (end - start)/2;
        if(nums[mid] == 1){
            if(flag){
                return helper(nums , start , mid -1 , flag , mid);
            }else{
                return helper(nums , mid+1 , end , flag , mid);
            }
        }else{
            return helper(nums , mid+1 , end , flag , result);
        }
    }
}
