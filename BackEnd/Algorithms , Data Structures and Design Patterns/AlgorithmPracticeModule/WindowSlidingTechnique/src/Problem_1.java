import java.util.*;

public class Problem_1 {
    /*
    Find a subarray having the given sum in an integer array

    Given an integer array, find a subarray having a given sum in it.

    For example:

    Input:  nums[] = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10}, target = 15
    Output: {6, 0, 9}

    Input:  nums[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, target = 15
    Output: {1, -4, 7, 6, 1, 4} or {4, 1, 10}

    Input:  nums[] = {0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10}, target = -3
    Output: {1, -4} or {-7, 1, -4, 7}
     */
    public static void main(String[] args) {
        int [] arr = new int []{0, 5, -7, 1, -4, 7, 6, 1, 4, 2, 10};
        int target =-4;
        findSubArrayGivenSum(arr , target);
    }

    private static void findSubArrayGivenSum(int[] arr, int target) {
//        int currentSum = 0;
//        ArrayList<int []> list = new ArrayList<>();
//
//        for (int end = 0 , start =0 ; start < arr.length; start++) {
//
//            while(currentSum < target && end < arr.length){
//                currentSum+=arr[end];
//                end++;
//            }
//
//            if(currentSum == target){
//                list.add(Arrays.copyOfRange(arr, start, end));
//            }
//            currentSum-=arr[start];
//        }
//
//        if(list.size() == 0){
//            System.out.println(-1);
//        }else{
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(Arrays.toString(list.get(i)));
//            }
//        }
        Map<Integer , Integer> map = new HashMap<>();
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum+=arr[i];
            map.put(currentSum , i);
            if(map.containsKey(currentSum-target)){
                System.out.println(
                        Arrays.toString(
                                Arrays.copyOfRange(arr, map.get(currentSum - target) +1, i + 1)
                        )
                );
            }
        }
    }
}
