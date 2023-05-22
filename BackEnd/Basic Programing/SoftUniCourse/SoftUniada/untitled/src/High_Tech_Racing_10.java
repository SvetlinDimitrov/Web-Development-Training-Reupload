import java.util.*;

public class High_Tech_Racing_10 {
    static Set<Integer> visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = Integer.parseInt(scanner.nextLine());
        int [][]edges = new int [vertex][vertex];
        int connections = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < connections; i++) {
            int [] edge = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges[edge[0]][edge[1]] = edge[2];
        }
        PriorityQueue<int []> que = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> edges[a[0]][a[1]]));
        visited = new HashSet<>();
        for (int i = 0; i < edges[0].length; i++) {
            if(edges[0][i] != 0){
                que.add(new int[]{0,i});
            }
        }
        visited.add(0);
        int [] parents = new int [vertex];
        Arrays.fill(parents , -1);
        while(!que.isEmpty()){
            int [] edge = que.poll();
            int parent = edge[0];
            int child = edge[1];
            if(!visited.contains(child)){
                parents[child] = parent;
                if(child == vertex-1){
                    break;
                }
                for (int i = 0; i < edges[child].length; i++) {
                    if(edges[child][i] != 0){
                        que.add(new int[]{child , i});
                    }
                }
            }
        }


        StringBuilder build = new StringBuilder();
        int index = parents[vertex-1];
        build.append(vertex-1);
        build.append(" >- ");
        while(index != -1){
            build.append(index);
            if(index != 0){
                edges[parents[index]][index] = 0;
            }
            index = parents[index];
            if(index != -1){
                build.append(" >- ");
            }
        }
        build.reverse();
        System.out.println(build.toString());
        Arrays.fill(parents , -1);
        visited.clear();
        que.clear();
        for (int i = 0; i < edges[0].length; i++) {
            if(edges[0][i] != 0){
                que.add(new int[]{0,i});
            }
        }
        visited.add(0);
        while(!que.isEmpty()){
            int [] edge = que.poll();
            int parent = edge[0];
            int child = edge[1];
            if(!visited.contains(child)){
                parents[child] = parent;
                if(child == vertex-1){
                    break;
                }
                for (int i = 0; i < edges[child].length; i++) {
                    if(edges[child][i] != 0){
                        que.add(new int[]{child , i});
                    }
                }
            }
        }
        StringBuilder build1 = new StringBuilder();
        index = parents[vertex-1];
        build1.append(vertex-1);
        build1.append(" >- ");
        while(index != -1){
            build1.append(index);
            index = parents[index];
            if(index != -1){
                build1.append(" >- ");
            }
        }
        build1.reverse();
        System.out.println(build1.toString());
    }
}
