import java.util.*;

public class ArticulationPoints {
    public static class Vertex{
        Integer level;
        Integer depth;
        Integer parent =-1;
        boolean isArticulation;
        Integer childrenCount = 0;

    }
    public static List<Integer> answer;
    public static Set<Integer> visited;
    public static Map<Integer , Vertex> vertexMap;
    public static List<Integer>[] graph;
    public static int level = 0;
    public static List<Integer> findArticulationPoints(List<Integer>[] targetGraph) {
        answer = new ArrayList<>();
        graph = targetGraph;
        vertexMap = new HashMap<>();
        visited = new HashSet<>();
        for (int node = 0; node < targetGraph.length; node++) {
            vertexMap.put(node , new Vertex());
        }
        for (int node = 0; node < targetGraph.length; node++) {
            if(!visited.contains(node)){
                dfs(node);
            }
        }
        return answer;
    }

    private static void dfs(int node) {
        vertexMap.get(node).depth = level;
        vertexMap.get(node).level = level;
        visited.add(node);
        level++;
        for (Integer child : graph[node]) {
            if(!visited.contains(child)){
                vertexMap.get(child).parent = node;
                dfs(child);
                vertexMap.get(node).childrenCount = vertexMap.get(node).childrenCount +1;
                if(getLevel(child) >= getDepth(node)){
                    vertexMap.get(node).isArticulation = true;
                }
                vertexMap.get(node).level = Math.min( getLevel(node) , getLevel(child));
            }else if ((int) child != vertexMap.get(node).parent){
                vertexMap.get(node).level = Math.min( getLevel(node) , getDepth(child));
            }
        }
        if((vertexMap.get(node).parent != -1 && vertexMap.get(node).isArticulation) ||
                (vertexMap.get(node).parent == -1 && vertexMap.get(node).childrenCount >1)){
            answer.add(node);
        }
    }
    private static int getLevel(int node){
        return vertexMap.get(node).level;
    }
    private static int getDepth(int node){
        return vertexMap.get(node).depth;
    }
}
