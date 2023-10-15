import java.util.*;

public class Main {
    public static boolean [] isUsed;
    public static Set<String> visited;
    public static Set<String> forCycles;
    public static int i;
    public static void main(String[] args) {
//        Map<Integer , List<Integer>> graph = new LinkedHashMap<>();
//        graph.put(7 , new ArrayList<>());
//        graph.get(7).addAll(List.of(19,21,14));
//        graph.put(19 , new ArrayList<>());
//        graph.get(19).addAll(List.of(1,12,31,21));
//        graph.put(21 ,new ArrayList<>());
//        graph.get(21).add(14);
//        graph.put(14,new ArrayList<>());
//        graph.get(14).addAll(List.of(6,23));
//        graph.put(1 , new ArrayList<>());
//        graph.get(1).add(7);
//        graph.put(12 , new ArrayList<>());
//        graph.put(31 , new ArrayList<>());
//        graph.get(31).add(21);
//        graph.put(23 , new ArrayList<>());
//        graph.get(23).add(21);
//        graph.put(6 , new ArrayList<>());
//        isUsed = new boolean[32];
//        System.out.print("DFS: ");
//        for (Map.Entry<Integer, List<Integer>> node : graph.entrySet()) {
//                dfs(node.getKey(), graph);
//        }
//        System.out.println();
//        System.out.print("BFS : ");
//        boolean [] BFSUsed = new boolean[32];
//        bfs(BFSUsed , graph);
//        Scanner scanner = new Scanner(System.in);
//        List<List<Integer>> graph = new ArrayList<>();
//        int size = Integer.parseInt(scanner.nextLine());
//        for (i = 0; i <size ; i++) {
//            graph.add(new ArrayList<>());
//            String input = scanner.nextLine();
//            if (input.trim().length() != 0) {
//                Arrays.stream(input.split("\\s+"))
//                        .mapToInt(Integer::parseInt)
//                        .forEach(e -> graph.get(i).add(e));
//            }
//        }
//        List<Deque<Integer>> output  = getConnectedComponents(graph);
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int [] prev = new int [size+1];
        isUsed = new boolean[size+1];
        Arrays.fill(prev, -1);
        Map<Integer , List<Integer>> graph = new LinkedHashMap<>();

        for (int j = 1; j <= size; j++) {
            graph.put(j , new ArrayList<>() );
        }

        int edges = Integer.parseInt(scanner.nextLine());
        for (int j = 1; j <= edges; j++) {
            int[] num = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            graph.get(num[0]).add(num[1]);
        }

        int parent = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        bfs.offer(parent);
        while(!bfs.isEmpty()){
            parent = bfs.poll();
            if(!isUsed[parent]) {
                for (Integer child : graph.get(parent)) {
                    prev[child] = parent;
                    bfs.offer(child);
                }
            }

            if(parent == destination){
                break;
            }
        }
        System.out.printf("Shortest path length is: ");

    }

    private static void bfs(boolean[] BFSUsed, Map<Integer, List<Integer>> graph) {
        ArrayDeque<Integer> parents = new ArrayDeque<>();

        for (Map.Entry<Integer, List<Integer>> nodes : graph.entrySet()) {
            if(!BFSUsed[nodes.getKey()]){
                parents.offer(nodes.getKey());

                while(!parents.isEmpty()){
                    Integer parent = parents.poll();
                    BFSUsed[parent] = true;
                    System.out.printf("%d ",parent);
                    for (Integer child : graph.get(parent)) {
                        if(!isUsed[child]) {
                            parents.offer(child);
                        }
                    }
                }
            }
        }

    }

    private static void dfs(int current , List<List<Integer>> graph, List<Deque<Integer>> toReturn, int index) {
        if(!isUsed[current]){
            isUsed[current] = true;
            for (Integer child : graph.get(current)) {
                dfs(child , graph, toReturn, index);
            }
            toReturn.get(index).offer(current);
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        List<Deque<Integer>> toReturn = new ArrayList<>();
        isUsed = new boolean[graph.size()];
        int index = -1;
        for (int parentIndex = 0; parentIndex < graph.size(); parentIndex++) {
            if(!isUsed[parentIndex]){
                toReturn.add(new ArrayDeque<>());
                index++;
                dfs(parentIndex , graph , toReturn , index);

            }

        }
        return toReturn;
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        visited = new LinkedHashSet<>();
        forCycles = new HashSet<>();
        List<String> toReturn = new ArrayList<>();
        for (var node : graph.keySet()) {
            if(!visited.contains(node)) {
                dfs2(node, graph,toReturn);
            }
        }
//        Map<String , Integer> dependenciesCount = findNoParents(graph);
//        while (!graph.isEmpty()) {
//            String zeroChild = dependenciesCount.entrySet().stream()
//                    .filter(e -> e.getValue() == 0)
//                    .findFirst()
//                    .map(Map.Entry::getKey)
//                    .orElse(null);
//
//            if(null == zeroChild){
//                throw new IllegalArgumentException();
//            }
//
//            list.add(zeroChild);
//
//            graph.remove(zeroChild);
//            dependenciesCount = findNoParents(graph);
//
//        }
        Collections.reverse(toReturn);
        return toReturn;
    }

    private static void dfs2(String nodes, Map<String, List<String>> graph, List<String> toReturn) {
        if(forCycles.contains(nodes)){
            throw new IllegalArgumentException();
        }
        if(!visited.contains(nodes)){
            visited.add(nodes);
            forCycles.add(nodes);
            for (String child : graph.get(nodes)) {
                dfs2(child , graph , toReturn);
            }
            toReturn.add(nodes);
            forCycles.remove(nodes);
        }
    }

    private static Map<String, Integer> findNoParents(Map<String, List<String>> graph) {
        Map<String , Integer> toReturn = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            toReturn.putIfAbsent(node.getKey() , 0);
            for (String child : node.getValue()) {
                toReturn.putIfAbsent(child , 0);
                toReturn.put(child , toReturn.get(child) + 1);
            }
        }
        return toReturn;
    }
}
