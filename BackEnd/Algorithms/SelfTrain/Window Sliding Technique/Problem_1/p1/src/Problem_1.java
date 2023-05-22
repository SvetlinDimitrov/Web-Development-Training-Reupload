public class Problem_1 {
    /*
    Example: Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

    Input  : arr[] = {100, 200, 300, 400}, k = 2
    Output : 700

    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
    Output : 39
    We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

    Input  : arr[] = {2, 3}, k = 3
    Output : Invalid
    There is no subarray of size 3 as size of whole array is 2.
     */
    public static void main(String[] args) {
        int [] arr1 = new int [] {100, 200, 300, 400};
        int k1 =2;
        int [] arr2 = new int [] {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k2 =4;
        int [] arr3 = new int [] {2,3,4};
        int k3 =3;
        System.out.printf("first answer is %d%n" , slidingWindowApproachRecursive(arr1 , k1 ,0,0));
        System.out.printf("second answer is %d%n" , slidingWindowApproachRecursive(arr2 , k2,0,0));
        System.out.printf("third answer is %d" , slidingWindowApproachRecursive(arr3 , k3,0,0));
    }

    private static int slidingWindowApproachRecursive(int[] arr, int k, int index , int maxSum) {
        if(k > arr.length){return -1;}
        if(arr.length <= index){return maxSum;}
        if(k > index){
            return slidingWindowApproachRecursive(arr , k ,index+1 , maxSum + arr[index]);
        }else{
            int window_sum = maxSum;
            window_sum +=arr[index] - arr[index-k];
            return slidingWindowApproachRecursive(arr ,k ,index+1 ,Math.max(window_sum , maxSum));
        }
    }

    private static int slidingWindowApproach(int[] arr, int k) {
        if(k > arr.length){return -1;}
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum+=arr[i];
        }
        int window_sum = max_sum;
        for (int i = k; i < arr.length ; i++) {
            window_sum += arr[i] - arr[i-k];
            max_sum=Math.max(max_sum , window_sum);
        }
        return  max_sum;
    }
}
