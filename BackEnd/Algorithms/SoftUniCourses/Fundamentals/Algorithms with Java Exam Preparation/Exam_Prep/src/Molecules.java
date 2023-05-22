import java.awt.*;
import java.util.*;

public class Molecules {
    public static boolean [] isUsed;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer , ArrayList<Integer>> graph = new LinkedHashMap<>();
        for (int i = 1; i <=n ; i++) {
            graph.put(i , new ArrayList<>());
        }
        isUsed = new boolean[n+1];
        isUsed[0] =true;
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int parent = num[0];
            int child = num[1];

            graph.get(parent).add(child);
        }

        int start = Integer.parseInt(scanner.nextLine());
        isUsed[start] = true;
        for (Integer integer : graph.get(start)) {
            if(!isUsed[integer]){
                dfs(integer , graph);
            }
        }
        for (int i = 0; i < isUsed.length; i++) {
            if(!isUsed[i]){
                System.out.printf("%d ",i);
            }
        }
    }

    private static void dfs(Integer parent, Map<Integer, ArrayList<Integer>> graph) {
        if(!isUsed[parent]){
            isUsed[parent] = true;
            for (Integer child : graph.get(parent)) {
                dfs(child , graph);
            }
        }
    }
}
