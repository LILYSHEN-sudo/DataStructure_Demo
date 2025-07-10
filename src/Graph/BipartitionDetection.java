package Graph;

public class BipartitionDetection {
    private Graph G;
    private int[] colors;
    private boolean[] visited;
    private boolean isBipartite = true;

    public BipartitionDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for(int i = 0; i < G.V(); i++) {
            colors[i] = -1;
        }
        for(int v = 0 ; v < G.V(); v++) {
            if(!visited[v]) {
                if(dfs(v, 0)) {
                    isBipartite = false;
                    break;
                }
            }
        }
    }

    public boolean dfs(int v, int color) {
        visited[v] = true;
        for(int w : G.adj(v)) {
            if(!visited[w]) {
                if(dfs(w, 1 - color)) {
                    return false;
                }
            } else if(colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        BipartitionDetection bd = new BipartitionDetection(g);
        System.out.println(bd.isBipartite());
    }
}
