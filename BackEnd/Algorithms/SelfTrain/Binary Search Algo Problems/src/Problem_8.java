public class Problem_8 {
    /*
    Search in a nearly sorted array in logarithmic time

    Given a nearly sorted array such that each of the n elements may be misplaced by no more than one position from the correct sorted order,
     search a given element in it efficiently. Report if the element is not present in the array.

    An element at index i in a correctly sorted order can be misplaced by the ± 1 position, i.e., it can be present at index i-1 or i or i+1 in the input array.


    For example,

    Input:
    nums = [2, 1, 3, 5, 4, 7, 6, 8, 9],target = 5
    Output: Element 5 found at index 3


    Input:
    nums = [2, 1, 3, 5, 4, 7, 6, 8, 9],target = 10
    Output: Element not found in the array
     */
    public static void main(String[] args) {
        int [] nums = new int []{2, 1, 3, 5, 4, 7, 6, 8, 9,10,11,12,13,14,16,15,18,19,21,20};
        int target = 20 ;
        System.out.println(BS(nums , target,0,nums.length-1 ));
    }
    private static int BS(int[] nums, int target, int start, int end ){
        if(start > end){return -1;}
        int mid = start + (end - start)/2;
        if(start <= mid -1 && nums[mid-1] == target){return mid-1;}
        if(end >= mid + 1 && nums[mid+1] == target){return mid+1;}
        if(nums[mid] == target ){return mid;}
        if(nums[mid] > target){return BS(nums , target , start , mid-1);}
        else{return BS(nums , target , mid+1 , end);}
    }
}
