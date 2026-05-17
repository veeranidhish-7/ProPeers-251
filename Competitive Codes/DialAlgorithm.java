import java.util.*;
public class DialAlgorithm {
    static class Edge{
        int dest;
        int wt;
        Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int W = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v,w));
        }
        int src = 0;

        dialAlgo(graph,V,W,src);
    }

    public static void dialAlgo(ArrayList<Edge>[] graph, int V, int W, int src){
        int bucketSize = V*W;
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i<=bucketSize; i++){
            buckets.add(new ArrayList<>());
        }

        buckets.get(0).add(src);

        for(int i = 0; i<= bucketSize; i++){
            while(!buckets.get(i).isEmpty()){
                int u = buckets.get(i).remove(0);
                if(i> dist[u]){
                    continue;
                }
                for(Edge edge : graph[u]){
                    int v = edge.dest;
                    int w = edge.wt;
                    if(dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                        buckets.get(dist[v]).add(v);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
