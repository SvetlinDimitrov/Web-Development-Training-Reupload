import java.util.ArrayDeque;
import java.util.Arrays;

public class EdmondsKarp {
    public static int [][] graph;
    public static boolean [] visited;
    public static int [] parents;
    public static int findMaxFlow(int[][] targetGraph) {
        graph = targetGraph;
        visited = new boolean[graph.length];
        parents = new int [targetGraph.length];
        int maxFlow = 0;
        while(bfs()){
            int destination = graph.length-1;
            int flow = Integer.MAX_VALUE;
            while(parents[destination] != -1){
                flow = Math.min(flow , graph[parents[destination]][destination]);
                destination = parents[destination];
            }
            maxFlow +=flow;
            destination = graph.length-1;
            while(parents[destination] != -1){
                graph[parents[destination]][destination]-=flow;
                destination = parents[destination];
            }
        }
        return maxFlow;
    }

    private static boolean bfs() {
        Arrays.fill(visited , false);
        Arrays.fill(parents , -1);
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(0);
        visited[0] = true;

        while(!que.isEmpty()){
            int node = que.poll();
            for (int child = 0; child < graph.length; child++) {
                if(graph[node][child] > 0 && !visited[child]){
                    visited[child] = true;
                    parents[child] = node;
                    que.add(child);
                }
            }
        }

        return visited[graph.length-1];
    }
}
