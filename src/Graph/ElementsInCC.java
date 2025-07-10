package Graph;

import java.util.ArrayList;

public class ElementsInCC {
    private Graph G;
    private int[] visited;
    private int count = 0;

    public ElementsInCC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for(int v = 0; v < G.V(); v++) {
            if(visited[v] == -1) {
                dfs(v, count);
                count++;
            }
        }
    }

    private void dfs(int v, int count) {
        visited[v] = count;
        for(int w : G.adj(v)) {
            if(visited[w] == -1) {
                dfs(w, count);
            }
        }
    }

    private int count() {
        for(int e : visited) {
            System.out.print(e + " ");
        }
        System.out.println();
        return count;
    }

    private boolean isConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return visited[v] == visited[w];
    }

    private void validateVertex(int v) {
        if(v < 0 || v >= G.V()) {
            throw new IllegalArgumentException("Vertex" + v + "is invalid");
        }
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] list = new ArrayList[count];
        for(int i = 0; i < count; i++) {
            list[i] = new ArrayList<>();
        }
        for(int v = 0; v < G.V(); v++) {
            list[visited[v]].add(v);
        }
        return list;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        ElementsInCC ec = new ElementsInCC(g);
        System.out.println(ec.count());
        System.out.println(ec.isConnected(1,2));
        //print the elements in the ConnectedComponent
        ArrayList<Integer>[] res = ec.components();
        for(int i = 0; i < res.length; i++) {
            System.out.print(i + " :");
            for(int w : res[i]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
