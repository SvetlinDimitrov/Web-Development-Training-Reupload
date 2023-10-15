import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubble_Sort {
    public static void main(String[] args) {
        int [] arr = {8,1,-1,9,2,73,13,42,69,9,9,1,2};
        buubleSort(arr);
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void buubleSort(int[] arr) {
        int index = 0;

        while(index < arr.length){
            int startIndex = 0;

            for (int secondIndex = 1; secondIndex < arr.length - index; secondIndex++) {
                if(arr[startIndex] > arr[secondIndex]){
                    swap(arr , secondIndex , startIndex);
                }
                startIndex++;
            }

            index++;
        }

    }
    private static void swap(int[] arr, int currentIndex, int minIndex) {
        int save = arr[currentIndex];
        arr[currentIndex] = arr[minIndex];
        arr[minIndex] = save;
    }
}
