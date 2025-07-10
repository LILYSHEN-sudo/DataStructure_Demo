package Graph;

public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!visited[v]) {
                if(dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    public boolean dfs(int v, int parent) {
        visited[v] = true;
        for(int w : G.adj(v)) {
            if(!visited[w]) {
                if(dfs(w, v)) {
                    return true;
                }
            } else if(w != parent) {
                hasCycle = true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        CycleDetection cd = new CycleDetection(g);
        System.out.println(cd.hasCycle());
    }
}
