import java.util.*;
public class BellmanFord {
    static class E{
        int u,v,w;
        E(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<E> graph = new ArrayList<>();
        for(int i = 0; i<e; i++){
            graph.add(new E(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int x = sc.nextInt();
        bf(n,graph,x);
        System.out.println(x);
    }

    public static void bf(int n, ArrayList<E> graph, int src){
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 1; i<n; i++){
            for(E e : graph){
                if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]){
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for(E e : graph){
            if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]){
//                dist[e.v] = dist[e.u] + e.w;
                System.out.println("Negative Cycle..");
                return;
            }
        }

        System.out.println(Arrays.toString(dist));

    }
}
