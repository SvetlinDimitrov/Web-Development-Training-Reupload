import java.util.*;

public class StronglyConnectedComponents {
    public static class Vertex{

        int index;
        int level;

        public Vertex(int index, int level) {

            this.index = index;
            this.level = level;
        }

    }
    public static  Map<Integer , Vertex> vertexMap;
    public static  List<List<Integer>> answer;
    public static ArrayDeque<Integer> deck;
    public static List<Integer>[] graph;
    public static Set<Integer> visited;
    public static int index = 0;

    public static List<List<Integer>> findStronglyConnectedComponents(List<Integer>[] targetGraph) {
        // Tarjan's Strongly Connected Component (SCC) Algorithm
       graph =  targetGraph;
       visited = new HashSet<>();
       deck = new ArrayDeque<>();
       vertexMap = new HashMap<>();
       answer = new ArrayList<>();

        for (int node = 0; node < targetGraph.length; node++) {
            vertexMap.put(node , new Vertex(0 ,0 ));
        }

        for (int node = 0; node < targetGraph.length; node++) {
            if(!visited.contains(node)){
                strongConnected(node);
            }
        }
       return  answer;
    }

    private static void strongConnected(int node) {
        vertexMap.get(node).index = index;
        vertexMap.get(node).level = index;
        index++;
        visited.add(node);
        deck.push(node);

        for (Integer child : graph[node]) {
            if(!visited.contains(child)){
                strongConnected(child);
                vertexMap.get(node).level = Math.min(vertexMap.get(node).level , vertexMap.get(child).level);
            }else{
                if(deck.contains(child)){
                    vertexMap.get(node).level = Math.min(vertexMap.get(node).level , vertexMap.get(child).index);
                }
            }
        }

        if(vertexMap.get(node).level == vertexMap.get(node).index){
            answer.add(new ArrayList<>());
            while (true){
                int child = deck.pop();
                answer.get(answer.size()-1).add(child);
                if(child == node){
                    break;
                }
            }

        }
    }
}
