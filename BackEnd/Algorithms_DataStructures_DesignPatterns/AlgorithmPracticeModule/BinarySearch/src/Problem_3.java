public class Problem_3 {
    /*
    Search an element in a circularly sorted array.

    Given a circularly sorted integer array, search an element in it.
    Assume there are no duplicates in the array, and the rotation is in the anti-clockwise direction.

    Input: nums = [8, 9, 10, 2, 5, 6],target = 10
    Output: Element found at index 2

    Input: nums = [9, 10, 2, 5, 6, 8],target = 5
    Output: Element found at index 3
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(BinarySearchUp(nums , 1) == 0);
        System.out.println(BinarySearchUp(nums , 13) == -1);
        int[] nums1 = new int[]{12, 1, 2, 3, 4, 5, 6,7,8,9,10,11};
        System.out.println(BinarySearchUp(nums1 , 12) == 0);
        System.out.println(BinarySearchUp(nums1, 13) == -1);
        int[] nums2 = new int[]{11, 12, 1, 2, 3,4, 5, 6,7};
        System.out.println(BinarySearchUp(nums2 , 12) == 1);
        System.out.println(BinarySearchUp(nums2 , 7) == 8);
        int[] nums3 = new int[]{10, 11,12, 13, 14, 1, 2};
        System.out.println(BinarySearchUp(nums3 , 1) == 5);
        System.out.println(BinarySearchUp(nums3 , 10) == 0);
    }

    private static int BinarySearchUp(int[] nums, int target) {
        //find pivot Index
//        int pivot = searchPivot(nums);
//        return searh(0 , pivot,nums,target) == -1 ? searh(pivot , nums.length ,nums,target) : searh(0 , pivot,nums,target);
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){return mid;}

            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <=nums[end]){
                    start = mid +1;
                }else{
                    end = mid-1;
                }
            }else{
                if(nums[mid] > target && target >= nums[start]){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }


    private static int searh(int start, int end, int[] nums, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int searchPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= nums[end]) {
            return start;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                if (nums[start] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
