
import java.util.*;

public class Cable_Network {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int nodes  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int edges  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        Map<Integer , ArrayList<Integer>> graph= new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[][] edgesWeigh = new int [nodes][nodes];


        for (int i = 0; i < edges; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            int to = Integer.parseInt(input[0]);
            int from = Integer.parseInt(input[1]);
            int weigh = Integer.parseInt(input[2]);
            graph.putIfAbsent(from , new ArrayList<>());
            graph.putIfAbsent(to , new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
            edgesWeigh[to][from] = weigh;
            edgesWeigh[from][to] = weigh;

            if(input.length > 3){
                set.add(from);
                set.add(to);
            }
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((f,s)-> Integer.compare(edgesWeigh[f[0]][f[1]] , edgesWeigh[s[0]][s[1]]));
        for (Integer to : set) {
            for (Integer from : graph.get(to)) {
                que.add(new int[]{to , from});
            }
        }
        int cost =0;

        while(!que.isEmpty()){
            int [] connection = que.poll();
            int from = connection[0];
            int to = connection[1];
            int weight = edgesWeigh[from][to];
            if (budget-weight < 0){
                break;
            }
            if(!set.contains(to)){
                cost+=weight;
                budget-=weight;
                set.add(to);
                for (Integer child : graph.get(to)) {
                    que.add(new int[]{to , child});
                }
            }
        }
        System.out.println("Budget used: " + cost);
    }
}
