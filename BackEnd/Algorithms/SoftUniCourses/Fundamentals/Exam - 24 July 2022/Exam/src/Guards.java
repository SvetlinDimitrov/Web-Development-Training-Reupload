import java.awt.*;
import java.util.*;

public class Guards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parents = Integer.parseInt(scanner.nextLine());
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Set<Integer> used = new HashSet<>();

        for (int i = 1; i <= parents; i++) {
            graph.put(i, new ArrayList<>());
        }

        int connections = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < connections; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(arr[0]).add(arr[1]);
        }
        int start = Integer.parseInt(scanner.nextLine());
        used.add(start);
        for (Integer parent : graph.get(start)) {
            dfs(parent, graph, used);

        }

        for (Integer integer : graph.keySet()) {
            if (!used.contains(integer)) {
                System.out.printf("%d ", integer);
            }
        }
    }

    private static void dfs(Integer parent, Map<Integer, ArrayList<Integer>> graph, Set<Integer> used) {
        if (!used.contains(parent)) {
            used.add(parent);
            for (Integer child : graph.get(parent)) {
                dfs(child, graph, used);
            }
        }
    }
}
