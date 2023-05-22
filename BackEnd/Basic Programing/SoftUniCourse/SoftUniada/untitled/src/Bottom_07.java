import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bottom_07 {
    static int [][] edges ;
    static  int [] root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = Integer.parseInt(scanner.nextLine());
        edges = new int [vertex][vertex];
        int countEdge = Integer.parseInt(scanner.nextLine());
        PriorityQueue<int []> que = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> edges[a[0]][a[1]]));

        for (int i = 0; i < countEdge; i++) {
            int [] connection = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges[connection[0]][connection[1]] = connection[2];
            edges[connection[1]][connection[0]] = connection[2];
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if(edges[i][j] != 0){
                    que.add(new int []{i,j});
                }
            }
        }
        root = new int [vertex];
        for (int i = 0; i < vertex; i++) {
            root[i] = i;
        }
        int maxEdge = Integer.MIN_VALUE;
        while(!que.isEmpty()){
            int [] edge = que.poll();
            int parent = edge[0];
            int child = edge[1];
            int getRootParent = getRoot(parent);
            int getRootChild = getRoot(child);
            if(getRootChild != getRootParent){
                root[getRootChild] = getRootParent;
                if(maxEdge < edges[parent][child]){
                    maxEdge = edges[parent][child];
                }
            }
        }
        System.out.println(maxEdge +1);
    }
    public static int getRoot(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = getRoot(root[x]);
    }
}
