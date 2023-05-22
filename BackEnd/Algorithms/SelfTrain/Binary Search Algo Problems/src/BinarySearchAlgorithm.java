public class BinarySearchAlgorithm {
    public static void main(String[] args) {
        int [] nums = new int []{1,2,3,5,7,9,12};
        int target = 1;
        System.out.println(BinarySearch(nums , target));
    }

    private static int BinarySearch(int[] nums, int target) {
        return  helper (nums , target , 0 , nums.length-1);
    }
    private static int helper(int [] nums , int target , int left , int right){
        if(left > right){return -1;}
        int middle = left + (right - left)/2;
        if(nums[middle] == target){return middle;}
        else if (nums[middle] > target){return helper(nums , target , left , middle-1);}
        else{return helper(nums , target , middle+1 , right);}
    }
}
