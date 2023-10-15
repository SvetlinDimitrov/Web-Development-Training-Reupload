public class Problem_11 {
    /*
    Find the missing term in a sequence in logarithmic time

    Given a sequence of n numbers such that the difference between the consecutive terms is constant, find the missing term in logarithmic time.
    Assume that the first and last elements are always part of the input sequence and the missing number lies between index 1 to n-1.

    For example,

    Input:  [5, 7, 9, 11, 15]
    Output: The missing term is 13

    Input:  [1, 4, 7, 13, 16]
    Output: The missing term is 10
     */
    public static void main(String[] args) {
        int [] nums = new int []{1, 4, 7, 13, 16};
        System.out.println(BS(nums));
    }
    private static int BS(int [] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums.length <= 2){
            return -1;
        }
        int diff = Math.min(nums[1] - nums[0] , nums[2]-nums[1]);

        while(start <= end){
            int mid = start + (end- start)/2;

            if(((end - mid) * diff) + nums[mid] != nums[end]){

                if(mid < nums.length-1 && nums[mid+1] - nums[mid] != diff){
                    return nums[mid] + diff;
                }

                start = mid +1;
            }else{

                if(mid > 0 && nums[mid] - nums[mid-1] != diff){
                    return nums[mid] - diff;
                }
                end = mid-1;
            }

        }
        return -1;
    }
}
