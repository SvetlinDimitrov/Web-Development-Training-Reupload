import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class Path_Finder {
    public static Map<Integer , ArrayList<Integer>> graph;
    public static Map<Integer , ArrayList<Integer>> connections;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parents = Integer.parseInt(scanner.nextLine());
        graph = new HashMap<>();
        for (int i = 0; i < parents; i++) {
            graph.put(i , new ArrayList<>());
        }
        for (int i = 0; i < parents ; i++) {
            String input = scanner.nextLine();
            if(input.trim().length() != 0 ) {
                int[] arr = Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (arr.length != 0) {
                    graph.get(i).addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
                }
            }
        }
        connections = new HashMap<>();
        bfs();
        int numberOfPaths = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPaths; i++) {
           int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
           boolean isValidPath = true;
            for (int j = 1; j < arr.length; j++) {
                if(connections.containsKey(arr[j])){
                    if(!connections.get(arr[j]).contains(arr[j-1])){
                        isValidPath = false;
                        break;
                    }
                }else{
                    isValidPath = false;
                    break;
                }
            }
            if(isValidPath){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }

    private static void bfs() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        connections.put(0 , null);
        que.offer(0);
        while(!que.isEmpty()){
            int parent = que.poll();
            for(Integer child : graph.get(parent)){
                connections.putIfAbsent(child , new ArrayList<>());
                connections.get(child).add(parent);
                que.offer(child);
            }
        }
    }
}
