import java.util.ArrayDeque;

public class Practice {
    /*
    Find minimum sum subarray of size `k`

    Given an integer array, find the minimum sum subarray of size k, where k is a positive integer.

    For example,
    Input:  {10, 4, 2, 5, 6, 3, 8, 1}, k = 3
    Output: Minimum sum subarray of size 3 is (1, 3)
     */
    public static void main(String[] args) {
        System.out.println(minSubArray(new int []{11, 4, 2, 5, 1, 3, 8, 1} , 3));
    }

    private static String minSubArray(int[] arr, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum+=arr[i];
        }
        int begin = 0;
        int end = k;
        int minSum = currentSum;

        for (int i = k , start =0; i < arr.length; i++) {
            currentSum+= arr[i];
            if(i-start >= k){
                currentSum-=arr[start];
                start++;
            }
            if(minSum > currentSum){
                minSum = currentSum;
                begin = start;
                end = i;
            }
        }
        return String.format("Minimum sum subarray of size %d is (%d, %d)",k,begin,end);
    }
}
