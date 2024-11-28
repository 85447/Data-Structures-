
//ADJACENCY LIST::::::::::::::::

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }

    //BFS:::
    public static void bfs(ArrayList<Edge> graph[], int V){
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i  = 0; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    //DFS::::
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        if(visited[curr]){
            return;
        }
        System.out.print(curr+" ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dfs(graph,e.dest,visited);
        }
    }
    public static void printallpath(ArrayList<Edge> graph[], int curr, boolean visited[],int tar, String path){
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                printallpath(graph, e.dest, visited, tar, path+e.dest);
                visited[curr] = false;
            }
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        //print 2's neighbours
        for(int i = 0; i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest+","+e.wt);
        }
        bfs(graph, V);
        dfs(graph, 0, new boolean[V]);

        int src = 0, tar= 3;
        printallpath(graph, src, new boolean[V], tar, "0");
    }
}