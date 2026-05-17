import java.util.*;
public class DFS {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        graph = new ArrayList[V];
        visited = new boolean[V];

        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void dfs(int curr){
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int nei : graph[curr]){
            if(!visited[nei]){
                dfs(nei);
            }
        }
    }
}
