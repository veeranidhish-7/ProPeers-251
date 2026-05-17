import java.util.*;
public class BFS {
    static ArrayList<Integer>[] graph;
    static boolean visited[];

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        graph = new ArrayList[V];
        visited= new boolean[V];

        for(int i = 0; i<V; i++){
            graph[i] = (new ArrayList<>());
        }

        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    public static void bfs(int src){
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int nei : graph[curr]){
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }
    }

}
