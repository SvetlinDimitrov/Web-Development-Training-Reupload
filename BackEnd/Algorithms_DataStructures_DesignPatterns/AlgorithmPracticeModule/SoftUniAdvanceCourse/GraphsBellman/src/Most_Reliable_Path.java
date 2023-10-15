import java.util.*;

public class Most_Reliable_Path {
    public static class Memo implements Comparable<Memo>{
        double weight;
        Integer from;

        public Memo(double weight, Integer from) {
            this.weight = weight;
            this.from = from;
        }

        @Override
        public int compareTo(Memo o) {
            return Double.compare(weight , o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer , ArrayList<Integer>> graph = new HashMap<>();
        Map<Integer , Memo> memoMap = new HashMap<>();

        int nodes  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        double[][] weights = new double[nodes][nodes];
        String path  = scanner.nextLine().split(": ")[1];
        int start = Integer.parseInt(path.split(" - ")[0]);
        int end = Integer.parseInt(path.split(" - ")[1]);
        int edges  = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        for (int i = 0; i < edges; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            int startNode = Integer.parseInt(input[0]);
            int endNode = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            weights[startNode][endNode] = weight/100.00;
            weights[endNode][startNode] = weight/100.00;
            graph.putIfAbsent(startNode , new ArrayList<>());
            graph.putIfAbsent(endNode , new ArrayList<>());
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
            memoMap.putIfAbsent(startNode , new Memo(Double.NEGATIVE_INFINITY ,null));
            memoMap.putIfAbsent(endNode , new Memo(Double.NEGATIVE_INFINITY ,null));
        }
        PriorityQueue<Integer> que = new PriorityQueue<>((s,f)->memoMap.get(f).compareTo(memoMap.get(s)));
        memoMap.get(start).weight = 1.00;
        que.add(start);
        while(!que.isEmpty()){
            int currentNode = que.poll();
            double currentWeight = memoMap.get(currentNode).weight;
            for (Integer destination : graph.get(currentNode)) {
                double weight = weights[currentNode][destination];
                double destinationWeight = memoMap.get(destination).weight;
                if(Double.compare(weight*currentWeight , destinationWeight) > 0){
                    memoMap.get(destination).weight = weight*currentWeight;
                    memoMap.get(destination).from = currentNode;
                    if(!que.contains(destination)){
                        que.add(destination);
                    }
                }
            }
        }

        System.out.printf("Most reliable path reliability: %.2f%%%n" , memoMap.get(end).weight *100);
        StringBuilder build = new StringBuilder();
        build.append(end);
        build.append(" >- ");
        while(memoMap.get(end).from != start){
            build.append(memoMap.get(end).from);
            if(memoMap.get(end).from != end){
                build.append(" >- ");
            }
            end = memoMap.get(end).from;
        }
        build.append(start);
        build.reverse();
        System.out.println(build.toString());
    }
}
