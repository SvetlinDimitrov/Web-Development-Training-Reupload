import java.util.ArrayDeque;

public class Problem_8 {
    /*
    Find the maximum sequence of continuous 1’s formed by replacing at-most `k` zeroes by ones

    Given a binary array, find the maximum sequence of continuous 1’s that can be formed by replacing at most k zeroes by ones.

    For example, consider the following binary array A:
    Input: A[] = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 }

    For k = 0,
    The length of the longest sequence is 4 (from index 6 to 9)

    For k = 1,
    The length of the longest sequence is 7 (from index 3 to 9)

    For k = 2,
    The length of the longest sequence is 10 (from index 0 to 9)

    For k = 3,
    The length of the longest sequence is 11 (from index 0 to 10)
     */
    public static void main(String[] args) {
        int [] arr = new int []{ 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
        for (int k = 0; k <= 3; k++) {
            System.out.println(logestSub(arr , k));
        }
    }

    private static String logestSub(int[] arr, int k) {
        int begin = 0;
        int end = 0;

        ArrayDeque<Integer>que = new ArrayDeque<>();

        for (int i = 0 , start =0; i < arr.length; i++) {
            if(arr[i] == 0){
                que.add(i);
            }
            if(que.size() > k){
                int lastZero = que.poll();
                start = lastZero +1;
            }
            if(i -start +1 > end- begin+1){
                end = i;
                begin = start;
            }
        }
        StringBuilder build = new StringBuilder();
        build.append(String.format("For k = %d,%n",k));
        build.append(String.format("The length of the longest sequence is %d (from index %d to %d)", end-begin+1 , begin , end));

        return build.toString();
    }
}
