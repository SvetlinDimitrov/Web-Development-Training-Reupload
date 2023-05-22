import java.util.*;

public class Cycles_in_Graph {
    public static Map<String , ArrayList<String>> graph = new LinkedHashMap<>();
    public static Set<String> visited = new HashSet<>();
    public static Set<String> cycles = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("End")){
            String Edge = input.split("-")[0];
            String Child = input.split("-")[1];
            graph.putIfAbsent(Edge , new ArrayList<>());
            graph.putIfAbsent(Child , new ArrayList<>());
            graph.get(Edge).add(Child);
            input = scanner.nextLine();
        }
        boolean [] isTrue = new boolean[1];
        for (var parent: graph.keySet()) {
            dfs(parent,graph , isTrue);
            cycles.clear();
            visited.clear();
        }

        System.out.printf("%s", isTrue[0] ? "Acyclic: No" : "Acyclic: Yes");
    }

    private static void dfs(String parent, Map<String, ArrayList<String>> graph, boolean[] isTrue) {
        if(cycles.contains(parent)){
            isTrue[0] = true;
            return;
        }
        if(!visited.contains(parent)){
            visited.add(parent);
            cycles.add(parent);
            for (String child : graph.get(parent)) {
                dfs(child , graph , isTrue);

            }
            cycles.remove(parent);
        }
    }
}
