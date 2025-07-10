package Graph;

import java.util.ArrayList;

public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    //put the dfs results into order array
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        //improve the code for many Connected Components
        for(int v = 0; v < G.V(); v++) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    public void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for(int w : G.adj(v)) {
            if(!visited[w]) {
                dfs(w);
            }
        }
    }

    //Graph postOrder
//    public void dfs2(int v) {
//        visited[v] = true;
//        for(int w : G.adj(v)) {
//            if(!visited[w]) {
//                dfs(w);
//            }
//        }
//        order.add(v);
//    }

    public ArrayList<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.order());
    }
}
