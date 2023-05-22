import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {
    /*
    Print all subarrays of an array having distinct elements
    Given an integer array, print all maximum size subarrays having all distinct elements in them.

    For example,
    Input:  A[] = { 5, 2, 3, 5, 4, 3 }
    Output: The largest subarrays with all distinct elements are:
    { 5, 2, 3 }
    { 2, 3, 5, 4 }
    { 5, 4, 3 }
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 5, 4, 3};
        printAllSubArrays(arr);
    }

    private static void printAllSubArrays(int[] arr) {
        System.out.println("The largest subarrays with all distinct elements are:");
        Set<Integer> set = new LinkedHashSet<>();

        int i = 0;
        int start = 0;

        while (i < arr.length) {

            while (i < arr.length && !set.contains(arr[i])) {
                set.add(arr[i]);
                i++;
            }

            System.out.printf("{%s}%n",
                    Arrays.stream(Arrays.copyOfRange(arr, start, i)).boxed()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")));

            while (i < arr.length && set.contains(arr[i])) {
                set.remove(arr[start]);
                start++;
            }

        }
    }
}
