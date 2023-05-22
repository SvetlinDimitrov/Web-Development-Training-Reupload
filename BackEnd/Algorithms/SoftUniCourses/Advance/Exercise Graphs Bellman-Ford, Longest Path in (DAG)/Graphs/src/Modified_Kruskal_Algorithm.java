import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Modified_Kruskal_Algorithm {
    public static int [] nodes;
    private static class Edge implements Comparable<Edge> {
        int  start;
        int  end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight , o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int edges  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        PriorityQueue<Edge>que = new PriorityQueue<>();
        nodes = new int [nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < edges; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            que.add(new Edge(start , end , weight));

        }
        int cost = 0;
        int times =0;
        while(!que.isEmpty()){
            Edge currentConnection = que.poll();
            int rootStart = findRoot(currentConnection.start);
            int rootEnd = findRoot(currentConnection.end);
            int weight = currentConnection.weight;

            if(rootStart != rootEnd){
                nodes[rootEnd] = rootStart;
                cost+=weight;
                times++;
            }
            if(times == nodesCount-1){break;}
        }
        System.out.println("Minimum spanning forest weight: " + cost);
    }

    private static int findRoot(int start) {
        if(start == nodes[start]){
            return  start;
        }
        return nodes[start] = findRoot(nodes[start]);
    }
}
