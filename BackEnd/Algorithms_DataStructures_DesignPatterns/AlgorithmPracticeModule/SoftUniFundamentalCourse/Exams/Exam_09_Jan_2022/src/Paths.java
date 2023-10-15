import java.util.*;
import java.util.stream.Collectors;

public class Paths {
    public static Map<Integer , ArrayList<Integer>> graph ;
    public static Set<Integer> visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        graph = new HashMap<>();
        for (int i= 0; i <n ; i++) {
            graph.put(i , new ArrayList<>());
            String input = scanner.nextLine();
            if(input.trim().length() == 0){
                continue;
            }else{
                graph.get(i).addAll(Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            }

        }
        visited = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if(!graph.get(i).isEmpty()) {
                FindPaths(i);
                visited.clear();
            }
        }
    }

    private static void FindPaths(int parent) {
        if(!visited.contains(parent)){
            visited.add(parent);
            if(!graph.get(parent).isEmpty()) {
                for (var child : graph.get(parent)) {
                    FindPaths(child);
                }
            }else{
                Print();
            }
            visited.remove(parent);
        }
    }

    private static void Print() {
        System.out.println(visited.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
