import java.util.Arrays;
import java.util.stream.Collectors;

public class Selection_Sort {
    public static void main(String[] args) {
        int [] arr = {8,1,-1,9,2,73,13,42,69,9,9,1,2};
        selectionSort(arr);
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex =i;
            for (int j = i; j <arr.length ; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr , i , minIndex);
        }
    }

    private static void swap(int[] arr, int currentIndex, int minIndex) {
        int save = arr[currentIndex];
        arr[currentIndex] = arr[minIndex];
        arr[minIndex] = save;
    }
}
