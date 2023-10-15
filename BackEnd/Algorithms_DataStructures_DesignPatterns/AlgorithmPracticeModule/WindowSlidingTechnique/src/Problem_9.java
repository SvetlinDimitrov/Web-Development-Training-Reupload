public class Problem_9 {
    /*
    Find the smallest subarray length whose sum of elements is greater than `k`

    Given an array of positive integers, find the smallest subarray’s length whose sum of elements is greater than a given number k.

    For example,

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 20
    Output: The smallest subarray length is 3
    Explanation: The smallest subarray with sum > 20 is {6, 7, 8}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 7
    Output: The smallest subarray length is 1
    Explanation: The smallest subarray with sum > 7 is {8}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 21
    Output: The smallest subarray length is 4
    Explanation: The smallest subarray with sum > 21 is {4, 5, 6, 7}

    Input:  {1, 2, 3, 4, 5, 6, 7, 8}, k = 40
    Output: No subarray exists
     */

    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 7;
        findSmallestSubWhoseSumIsGraterThen(arr , k);
    }

    private static void findSmallestSubWhoseSumIsGraterThen(int[] arr, int k) {
        int sum = 0;
        int shortestLength = Integer.MAX_VALUE;

        for (int end = 0 ,start =0; end <arr.length; end++) {
            sum+=arr[end];

            while(sum > k && end >= start){
                shortestLength = Math.min(shortestLength , end-start+1);

                sum-=arr[start];
                start++;
            }

        }
        System.out.println(shortestLength);
    }
}
