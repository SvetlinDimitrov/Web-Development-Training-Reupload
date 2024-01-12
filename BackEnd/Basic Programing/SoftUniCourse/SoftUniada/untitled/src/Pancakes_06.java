import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pancakes_06 {
    static ArrayList<ArrayList<Integer>>list = new ArrayList<>();
    static int [] parents ;
    public static void main(String[] args) {;
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        parents = new int [arr.length];

        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
            parents[i] = -1;
            if(i == 0){
                list.get(i).add(arr[i]);
                continue;
            }
            int lastSum = list.get(i-1).stream().mapToInt(e->e).sum();
            list.get(i).add(arr[i]);
            if(lastSum < lastSum +arr[i]){
                parents[i] = i-1;
                list.get(i).addAll(list.get(i-1));
            }

        }
        int bestIndex = -1;
        int bestSum = Integer.MIN_VALUE;
        int bestSize = -1;
        for (int i = 0; i < list.size(); i++) {
            int lastSum = list.get(i).stream().mapToInt(e->e).sum();
            if(bestSum < lastSum){
                bestSum = lastSum;
                bestIndex = i;
                bestSize = list.get(i).size();
            }
            if(bestSum == lastSum && bestSize < list.get(i).size()){
                bestIndex = i;
                bestSize = list.get(i).size();
            }
        }
        StringBuilder build = new StringBuilder();
        build.append(bestSum);
        build.append(" ");
        int startIndex = bestIndex;
        while(parents[startIndex] != -1){
            startIndex = parents[startIndex];
        }
        build.append(startIndex);
        build.append(" ");
        build.append(bestIndex);
        System.out.println(build.toString());
    }
}
