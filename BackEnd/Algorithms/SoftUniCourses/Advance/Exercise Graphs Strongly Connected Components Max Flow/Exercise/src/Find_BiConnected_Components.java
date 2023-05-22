import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Find_BiConnected_Components {
    static int [][] graph;
    static int [] depth;
    static int [] level;
    static boolean [] visited;
    static int [] parents;
    static int point = 1;
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        int edges = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        graph = new int [nodes][nodes];
        depth = new int [nodes];
        level = new int [nodes];
        list = new ArrayList<>();
        visited = new boolean[nodes];
        parents = new int [nodes];
        Arrays.fill(parents , -1);

        for (int i = 0; i < edges; i++) {
            String [] input = scanner.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graph[start][end] = 1;
        }

        for (int node = 0; node < graph.length; node++) {
            if(!visited[node]){
                dfs(node);
            }
        }
        System.out.println(list.size());
    }

    private static void dfs(int node) {
        visited[node] = true;
        depth[node] = point;
        level[node] = point;
        boolean isArticulationPoint = false;
        int children =0;
        point++;

        for (int child = 0; child < graph[node].length; child++) {
            if(graph[node][child] == 1){
                if(!visited[child]){
                    parents[child] = node;
                    dfs(child);
                    children++;
                    if(depth[node] <= level[child]){
                        isArticulationPoint = true;
                    }
                    level[node] = Math.min(level[node],level[child]);
                }else{
                    if(child != parents[node]){
                        level[node] = Math.min(level[node],depth[child]);
                    }
                }
            }
        }
        if(parents[node] == -1 && children > 1){
            list.add(node);
        }
        if(parents[node] != -1 && isArticulationPoint){
            list.add(node);
        }
    }
}
