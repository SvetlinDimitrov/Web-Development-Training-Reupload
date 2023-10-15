import java.util.*;

public class Undefined {
    static int[][] weights;

    public static class Memo implements Comparable<Memo> {
        Integer weight;
        Integer from;

        public Memo(Integer weight, Integer from) {
            this.weight = weight;
            this.from = from;
        }

        @Override
        public int compareTo(Memo o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexCount = Integer.parseInt(scanner.nextLine());
        int Edges = Integer.parseInt(scanner.nextLine());
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        weights = new int[vertexCount + 1][vertexCount + 1];
        Map<Integer, Memo> memoMap = new HashMap<>();

        for (int i = 0; i < Edges; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(start).add(end);
            weights[start][end] = weight;
            memoMap.putIfAbsent(start, new Memo(Integer.MAX_VALUE, null));
            memoMap.putIfAbsent(end, new Memo(Integer.MAX_VALUE, null));
        }


        int startVertex = Integer.parseInt(scanner.nextLine());
        int endVertex = Integer.parseInt(scanner.nextLine());
        memoMap.get(startVertex).weight = 0;

        int asnwer = BellmonFord_Algo(graph, vertexCount, memoMap, startVertex, endVertex);
        int secondTry = BellmonFord_Algo(graph, vertexCount, memoMap, startVertex, endVertex);
        if (secondTry != asnwer) {
            System.out.println("Undefined");
        } else {
            StringBuilder build = new StringBuilder();
            while(memoMap.get(endVertex).from != null){
                build.append(String.format("%d ",endVertex));
                endVertex = memoMap.get(endVertex).from;
            }
            build.append(startVertex);
            build.reverse();
            System.out.println(build.toString());
            System.out.println(asnwer);
        }

    }

    private static int BellmonFord_Algo(Map<Integer, ArrayList<Integer>> graph, int vertexCount, Map<Integer, Memo> memoMap, int startVertex, int endVertex) {

        for (int i = 1; i < vertexCount; i++) {

            for (int j = 1; j <= vertexCount; j++) {
                int currentWeight = memoMap.get(j).weight;
                if (currentWeight != Integer.MAX_VALUE) {
                    for (Integer child : graph.get(j)) {
                        int connectionWeight = weights[j][child];
                        int childWeight = memoMap.get(child).weight;
                        if (currentWeight + connectionWeight < childWeight) {
                            memoMap.get(child).weight = currentWeight + connectionWeight;
                            memoMap.get(child).from = j;
                        }
                    }
                }
            }
        }
        return memoMap.get(endVertex).weight;
    }
}
