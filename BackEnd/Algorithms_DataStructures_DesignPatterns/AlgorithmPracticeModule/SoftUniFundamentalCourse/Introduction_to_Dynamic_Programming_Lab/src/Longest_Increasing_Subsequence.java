import java.util.*;
import java.util.stream.Collectors;

public class Longest_Increasing_Subsequence {
    public static Map<Integer , Integer> map = new LinkedHashMap<>();
    public static int [] longestValue;
    public static int [] indexes ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        indexes = new int [arr.length];
        longestValue = new int [arr.length];
        Arrays.fill(indexes , -1);

        for (int i = 0 ; i<arr.length ; i++){
            int currentNum = arr[i];
            longestValue[i] = 1;

            for (int j = i-1; j >=0 ; j--) {
                if(currentNum > arr[j] && longestValue[j] +1 == longestValue[i]){
                    indexes[i] = j;
                }
                if(currentNum > arr[j] && longestValue[i] <= longestValue[j]){
                    longestValue[i] = longestValue[j]+1;
                    indexes[i] = j;
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int size = longestValue.length-1;

        while(size >= 0){
            if(max < longestValue[size]){
                max = longestValue[size];
                maxIndex = size;
            }
            size--;
        }
        while(maxIndex >= 0){
            answer.add(arr[maxIndex]);
            maxIndex = indexes[maxIndex];

        }
        Collections.reverse(answer);
        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
