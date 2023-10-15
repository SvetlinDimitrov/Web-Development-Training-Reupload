import java.util.LinkedHashMap;
import java.util.Map;

public class Problem_12 {
    /*
    Find the frequency of each element in a sorted array containing duplicates

    Given a sorted array containing duplicates, efficiently find each element’s frequency without traversing the whole array.

    For example,

    Input: [2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9]
    Output: {2: 3, 4: 3, 5: 2, 6: 1, 8: 2, 9: 1}

    Explanation:
    2 and 4 occurs thrice
    5 and 8 occurs twice
    6 and 9 occurs once
     */
    public static void main(String[] args) {
        int [] nums = new int []{1,2,2,2,2,2,2,2,2,3,4,5,6,7,8,9,9,9,9,9,9,9,9,9,9,9,9,9,10};
        System.out.println(BS(nums));
    }
//    private static String BS(int [] nums){
//        Map<Integer , Integer> map = new LinkedHashMap<>();
//        int start= 0;
//        int count =0;
//        int end = nums.length-1;
//        while(start <= end){
//            count++;
//            if(nums[start] == nums[end]){
//                map.put(nums[start] ,map.getOrDefault (nums[start] , 0) + (end-start+1));
//                start = end+1;
//                end = nums.length-1;
//            }else{
//                end = start + (end-start)/2;
//            }
//        }
//        System.out.println(count);
//        return map.toString();
//    }
    private static String BS(int [] nums){
        Map<Integer , Integer> map = new LinkedHashMap<>();
        int [] count = new int [1];
        for (int i = 0; i < nums.length; i++) {
            int findEnd = helper(nums[i] , nums , i ,count);
            map.put(nums[i] , findEnd - i + 1);
            i = findEnd;
        }
        System.out.println(count[0]);
        return map.toString();
    }
    private static int helper(int target , int [] nums , int start, int[] count){
        int end = nums.length-1;
        int result = start;

        while(start <= end){
            count[0]++;
            int mid = start + (end-start)/2;
            if(nums[mid] == target){result = mid;}

            if(nums[mid] > target){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
}
