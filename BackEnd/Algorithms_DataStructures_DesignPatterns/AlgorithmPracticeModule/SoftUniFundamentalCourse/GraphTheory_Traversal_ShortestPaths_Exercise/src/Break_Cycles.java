import java.util.*;

public class Break_Cycles {
    public static Map<String , ArrayList<String>> graph = new TreeMap<>();
    public static boolean [] cycleOn = new boolean[1];
    public static Map<String , String> cycle = new TreeMap<>();
    public static Set<String> checkForCycle = new HashSet<>();
    public static Set<String> visited = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("")){
            String [] mass = input.split(" -> ");
            graph.putIfAbsent(mass[0], new ArrayList<>());
            if(mass.length > 1){
                String [] connections = mass[1].split(" ");
                for (String connection : connections) {
                    graph.putIfAbsent(connection , new ArrayList<>());
                    graph.get(mass[0]).add(connection);
                }
            }
            input = scanner.nextLine();
        }
        int count = 0;
        for (String parent : graph.keySet()) {

            if(count != cycle.size()) {
                count++;
                int current = 0;
                for (var string : cycle.entrySet()) {
                    current++;
                    if (current == count) {
                        graph.get(string.getKey()).remove(string.getValue());
                        break;
                    }
                }
            }

            visited.clear();
            cycleOn[0]= false;
            dfs(parent);
        }
    }

    private static void dfs(String parent) {
        if(checkForCycle.contains(parent)){
            cycleOn[0]= true;
            return;
        }
        if(!visited.contains(parent)) {
            visited.add(parent);
            checkForCycle.add(parent);
            for (String child : graph.get(parent)) {
                dfs(child);
            }
            checkForCycle.remove(parent);
        }
    }
}
