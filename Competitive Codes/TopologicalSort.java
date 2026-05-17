//import java.util.*;
//public class TopologicalSort {
//    static ArrayList<ArrayList<Integer>> graph;
//    static boolean[] visited;
//    static Stack<Integer> stack;
//
//    static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//        graph = new ArrayList<>();
//        visited = new boolean[V];
//        stack = new Stack<>();
//        for(int i = 0; i<E; i++){
//            graph.add(new ArrayList<>());
//        }
//        for(int i = 0; i<E; i++){
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            graph.get(u).add(v);
//        }
//        topo(V);
//    }
//
//    public static void dfs(int curr){
//        visited[curr] = true;
//        for(int nei : graph.get(curr)){
//            if(!visited[nei]){
//                dfs(nei);
//            }
//        }
//        stack.push(curr);
//    }
//
//    public static void topo(int V){
//        for(int i = 0; i<V; i++){
//            if(!visited[i]){
//                dfs(i);
//            }
//        }
//
//        while(!stack.isEmpty()){
//            System.out.print(stack.pop() + " ");
//        }
//    }
//}

import java.util.*;
public class TopologicalSort{
    static int indegree[];
    static ArrayList<Integer>[] graph;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        graph = new ArrayList[V];
        indegree = new int[V];
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            indegree[v]++;
        }
        topoSort(V);
    }

    public static void topoSort(int V){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int nei : graph[curr]){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
    }
}

























