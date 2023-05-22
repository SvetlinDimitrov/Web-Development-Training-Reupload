import java.util.Arrays;
import java.util.stream.Collectors;

public class Insertion_Sort {
    public static void main(String[] args) {
        int [] arr = {73 ,69, 42, 13, 9 ,9 ,9, 8, 2, 2, 1, 1, -1};
        insertionSort(arr);
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void insertionSort(int[] arr) {
        for (int firstIndex = 0; firstIndex < arr.length  ; firstIndex++) {

            for (int secondIndex = firstIndex; secondIndex > 0; secondIndex--) {
                int helperIndex = secondIndex-1;
                if(arr[helperIndex] > arr[secondIndex]){
                    swap(arr , helperIndex , secondIndex);
                }
            }
        }
    }

    private static void swap(int[] arr, int currentIndex, int minIndex) {
        int save = arr[currentIndex];
        arr[currentIndex] = arr[minIndex];
        arr[minIndex] = save;
    }
}
