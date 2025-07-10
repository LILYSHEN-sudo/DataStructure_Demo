package Graph;

public class ConnectedComponent {
    private Graph G;
    private boolean[] visited;
    private int count = 0;

    public ConnectedComponent(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!visited[v]) {
                dfs(v);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        for(int w : G.adj(v)) {
            if(!visited[w]) {
                dfs(w);
            }
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        ConnectedComponent cc = new ConnectedComponent(g);
        System.out.println(cc.count());

    }
}
