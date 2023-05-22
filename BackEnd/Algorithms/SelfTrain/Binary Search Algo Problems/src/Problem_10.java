public class Problem_10 {
    /*
    Find the peak element in an array
    Given an integer array, find the peak element in it. A peak element is an element that is greater than its neighbors.
    There might be multiple peak elements in an array, and the solution should report any peak element.

    An element A[i] of an array A is a peak element if it’s not smaller than its neighbor(s).

    A[i-1] <= A[i] >= A[i+1] for 0 < i < n-1
    A[i-1] <= A[i] if i = n – 1
    A[i] >= A[i+1] if i = 0
    For example,

    Input : [8, 9, 10, 2, 5, 6]
    Output: The peak element is 10 (or 6)


    Input : [8, 9, 10, 12, 15]
    Output: The peak element is 15


    Input : [10, 8, 6, 5, 3, 2]
    Output: The peak element is 10
     */
    public static void main(String[] args) {
        int[] nums = new int []{17,5,6,7,8,9,10,1,2,3,4};
        int pivot = pivot(nums);
        if(pivot == -1){
            System.out.println(nums[nums.length-1]);
        }else{
            System.out.println(nums[pivot]);
        }
    }
    public static int pivot(int [] nums){

     int start = 0;
     int end = nums.length-1;

     if(nums[start] < nums[end]){return -1;}

     while(start <= end){
         int mid = start + (end-start)/2;
         if(nums[mid] > nums[mid+1] && nums[start] <= nums[mid]){
             return mid;
         }else if (nums[start] > nums[mid]){
             end = mid - 1;
         }else {
             start = mid +1;
         }

     }
     return  -1;
    }
}
