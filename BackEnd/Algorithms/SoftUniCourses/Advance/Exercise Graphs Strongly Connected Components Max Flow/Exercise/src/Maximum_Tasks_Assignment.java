import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Tasks_Assignment {
    static int[][] graph;
    static int [] parents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peoples = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        int tasks = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        graph = new int[peoples + tasks + 2][peoples + tasks+2];
        parents = new int [graph.length];
        for (int i = 0; i < peoples; i++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int index = 0; index < input.length; index++) {
                if (input[index] == 'Y') {
                    graph[1 + i][peoples + 1 + index] = 1;
                }
            }
        }
        for (int start = 0; start < peoples; start++) {
            graph[0][start+1] = 1;
        }
        for (int end = 0; end < tasks; end++) {
            graph[peoples +1+end][graph.length-1] = 1;
            graph[graph.length-1][peoples +1+end] = 1;
        }



        while(bfs()){
            int node = graph.length-1;
            int task = parents[node];
            graph[node][task] = 0;
            graph[task][node] = 0;
            node = parents[node];
            int people = parents[node];
            graph[people][task] = 0;
            graph[0][people] =0;
            people--;
            task = tasks-task;
            System.out.printf("%c%d%n" , people +'A' ,task);
        }
    }

    private static boolean bfs() {

        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean [] visited = new boolean[graph.length];
        Arrays.fill(parents , -1);
        que.offer(0);

        while(!que.isEmpty()){
            int currentNode = que.poll();

            for (int child = 0 ; child < graph.length ; child++) {
                if(graph[currentNode][child] > 0 && !visited[child]){
                    parents[child] = currentNode;
                    visited[child] = true;
                    que.push(child);
                }
            }
        }

        return visited[graph.length-1];
    }
}
