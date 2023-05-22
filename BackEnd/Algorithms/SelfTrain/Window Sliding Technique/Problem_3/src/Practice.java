import java.util.ArrayDeque;
import java.util.Queue;

public class Practice {
    /*
    Find maximum length sequence of continuous ones (Using Sliding Window)

    Given a binary array, find the index of 0 to be replaced with 1 to get a maximum length sequence of continuous ones.

    For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }. The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.

    Practice This Problem
     */
    public static void main(String[] args) {
        System.out.println(maxLengthOfOnes(new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 0}));
    }

    private static int maxLengthOfOnes(int[] arr) {
        int maxLength = -1;
        int answer = -1;
        int lastZero = -1;


        for (int end = 0, start = 0; end < arr.length; end++) {

            if (arr[end] == 0 && lastZero == -1) {
                lastZero = end;
            }else if (arr[end] == 0 && lastZero != -1){
                start = lastZero+1;
                lastZero = end;
            }else{
                if(maxLength < end-start){
                    maxLength = end-start;
                    answer = lastZero;
                }
            }
        }
        return answer ;
    }
}
