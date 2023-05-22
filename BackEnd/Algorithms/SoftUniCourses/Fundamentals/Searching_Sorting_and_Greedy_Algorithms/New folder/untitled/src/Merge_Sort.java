import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Merge_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        sort(num);
        System.out.println(Arrays.stream(num)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void sort(int[] arr) {
        merge(arr);
    }

    private static int[] merge(int[] arr) {
        if(arr.length == 1){
            return arr;
        }
        int half = arr.length/2;
        int firstArrayLength = half;
        int secondArrayLength = arr.length -half;

        int [] firstHalf = new int [firstArrayLength];
        int [] secondHalf = new int [secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstHalf[i] = arr[i];
        }

        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = arr[half + i];
        }

        merge(firstHalf);
        merge(secondHalf);

        int mainIndex = 0;

        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length){
            if(firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]){
                arr[mainIndex++] = firstHalf[firstHalfIndex++];
            }else{
                arr[mainIndex++] = secondHalf[secondHalfIndex++];
            }
        }

        while(firstHalfIndex < firstHalf.length){
            arr[mainIndex++] = firstHalf[firstHalfIndex++];
        }
        while(secondHalfIndex < secondHalf.length){
            arr[mainIndex++] = secondHalf[secondHalfIndex++];
        }

        return arr;
    }
}
