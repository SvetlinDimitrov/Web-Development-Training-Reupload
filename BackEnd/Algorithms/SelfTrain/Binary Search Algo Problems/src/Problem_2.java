public class Problem_2 {
    //Find the number of rotations in a circularly sorted array
    //Given a circularly sorted integer array,
    //find the total number of times the array is rotated. Assume there are no duplicates in the array, and the rotation is in the anti-clockwise direction.

    //Input:  nums = [8, 9, 10, 2, 5, 6]
    //Output: The array is rotated 3 times
    //
    //
    //Input:  nums = [2, 5, 6, 8, 9, 10]
    //Output: The array is rotated 0 times
    public static void main(String[] args) {
        int [] nums = new int [] {1,2,3,4,5,6,7,0};
        System.out.println(bsPivot(nums));
    }

    private static int bsPivot(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        if(nums[start] < nums[end]){return 0;}

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]){return mid+1;}
            else{
                if(nums[start] > nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
//            int mid  = start + (end - start)/2;
//            int next = (mid + 1) % nums.length;
//            int prev = (mid - 1 + nums.length) % nums.length;
//            if(nums[start] <= nums[end]){
//                return start;
//            }
//            if(nums[mid] < nums[prev] && nums[mid] < nums[next]){
//                return  mid;
//            }
//            if(nums[mid] > nums[end]){
//                start = mid +1;
//            }else if(nums[mid] < nums[start]){
//                end = mid -1;
//            }
        }
        return  -1;
    }
}
