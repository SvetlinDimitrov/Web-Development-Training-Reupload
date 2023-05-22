import java.util.PriorityQueue;
import java.util.Scanner;

public class Cheap_Town_Tour {
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
        int nodesCount  = Integer.parseInt(scanner.nextLine());
        nodes = new int[nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            nodes[i] = i;
        }
        int edges  = Integer.parseInt(scanner.nextLine());
        PriorityQueue<Edge>que = new PriorityQueue<>();
        for (int i = 0; i < edges; i++) {
            String [] input = scanner.nextLine().split(" - ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            que.add(new Edge(start ,end,weight));
        }

        int totalCost =0;
        while(!que.isEmpty()){
            Edge currentEdge = que.poll();
            int start = currentEdge.start;
            int end = currentEdge.end;
            int weight = currentEdge.weight;

            int rootStart = find(start);
            int rootEnd = find(end);
            if(rootStart != rootEnd){
                nodes[rootEnd] = rootStart;
                totalCost+=weight;
            }
        }
        System.out.println("Total cost: " + totalCost);
    }

    private static int find(int end) {
        if(nodes[end] == end){
            return end;
        }
        return nodes[end] = find(nodes[end]);
    }
}
