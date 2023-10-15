import java.util.*;

public class Salaries {
    public static Map<Integer, ArrayList<Integer>> graph = new LinkedHashMap<>();
    public static Set<Integer> visited = new HashSet<>();
    public static Map<Integer, Integer> salary = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            graph.put(i, new ArrayList<>());
            salary.put(i, -1);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'Y') {
                    graph.get(i).add(j);
                }
            }

        }
        for (Integer parent : graph.keySet()) {
            int money = dfs(parent);
            visited.clear();
            salary.put(parent, money);
        }
        System.out.println(salary.values().stream().mapToInt(e->e).sum());
    }

    private static int dfs(Integer parent) {
        int salary = 0;

        if(visited.contains(parent)){
            return salary;
        }
        visited.add(parent);

        if (graph.get(parent).size() == 0) {
            visited.remove(parent);
            return 1;

        } else {
            for (Integer child : graph.get(parent)) {
                salary += dfs(child);
            }
        }
        visited.remove(parent);
        return salary;
    }
}
