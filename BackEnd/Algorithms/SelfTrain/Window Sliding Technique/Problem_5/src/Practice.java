import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {
    /*
    Find the count of distinct elements in every subarray of size `k`
    Given an array and an integer k, find the count of distinct elements in every subarray of size k.

    For example,
    Input:
    arr[] = { 2, 1, 2, 3, 2, 1, 4, 5 };
    k = 5;

    Output:
    The count of distinct elements in subarray { 2, 1, 2, 3, 2 } is 3
    The count of distinct elements in subarray { 1, 2, 3, 2, 1 } is 3
    The count of distinct elements in subarray { 2, 3, 2, 1, 4 } is 4
    The count of distinct elements in subarray { 3, 2, 1, 4, 5 } is 5
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 2, 3, 2, 1, 4, 5};
        int k = 5;
        slidingWindowDistinct(arr, k);
    }

    private static void slidingWindowDistinct(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int end = 0, start = 0; end < arr.length; end++) {
            if (end - start + 1 == k) {
                set.addAll(Arrays.stream(Arrays.copyOfRange(arr, start, end + 1))
                        .boxed()
                        .toList());
                System.out.printf("The count of distinct elements in subarray {%s} is %d%n",
                        Arrays.stream(Arrays.copyOfRange(arr, start, end + 1))
                                .boxed()
                                .map(Object::toString)
                                .collect(Collectors.joining(", ")),
                        set.size());
                set.clear();
                start++;
            }
        }
    }
}
