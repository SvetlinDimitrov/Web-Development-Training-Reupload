import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class Distance_between_Vertices {
    public static Set<Integer> visited = new HashSet<>();
    public static Map<Integer, Integer> paths = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int agesCount = Integer.parseInt(scanner.nextLine());
        int toFind = Integer.parseInt(scanner.nextLine());
        Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<>();

        for (int i = 0; i < agesCount; i++) {
            String[] input = scanner.nextLine().split(":");

            int Edge = Integer.parseInt(input[0]);
            graph.put(Edge, new ArrayList<>());

            if (input.length > 1) {
                int[] arr = Arrays.stream(input[1]
                                .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                graph.get(Edge).addAll(Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.toList()));
            }
        }
        while (toFind-- > 0) {
            String input = scanner.nextLine();
            int Edge = Integer.parseInt(input.split("-")[0]);
            int destination = Integer.parseInt(input.split("-")[1]);
            paths.put(Edge, -1);
            dfs(Edge, graph, destination);
            visited.clear();
            int path = -1;
            if (paths.containsKey(destination)) {
                path++;
                int parrent = paths.get(destination);

                while (parrent > 0) {
                    path++;
                    parrent = paths.get(parrent);
                }
            }
            paths.clear();
            System.out.printf("{%d, %d} -> %d%n", Edge, destination, path);
        }
    }

    private static void dfs(Integer child, Map<Integer, ArrayList<Integer>> graph, int destination) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(child);
        visited.add(child);

        while (!que.isEmpty()) {
            Integer parent = que.poll();
            for (Integer childs : graph.get(parent)) {
                if (!visited.contains(childs)) {
                    paths.put(childs, parent);
                    visited.add(childs);
                    que.offer(childs);
                }
            }
        }

    }
}
