package Graph;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if(V < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new LinkedList[V]; //adj include V elements, each element is a LinkedList

            for(int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>(); //each element in adj is a linkedList
            }
            E = scanner.nextInt();
            if(E < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            for(int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if(a == b) {
                    throw new IllegalArgumentException("Self Loop is Detected!");
                }
                if(adj[a].contains(b)) {  //TC: worest case is O(V)
                    throw new IllegalArgumentException("Parallel Edge is Detected!");
                }
                adj[a].add(b);
                adj[b].add(a);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if(v < 0 || v >= V) {
            throw new IllegalArgumentException("Vertex" + v + "is invalid");
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    //whether there is an egde between two nodes
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }
    //return all the adj nodes of v
    public LinkedList<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    //return the degree of node v
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
        //return adj(v).size(); adj function
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int i = 0; i < V; i++) {
            for(int w : adj[i]) {
                sb.append(String.format("%d ", w));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjList adjlist = new AdjList("g.txt");
        System.out.print(adjlist);
        System.out.println(adjlist.V());
        System.out.println(adjlist.E());
        System.out.println(adjlist.hasEdge(1,2));
        System.out.println(adjlist.adj(1));
        System.out.println(adjlist.degree(1));
    }
}
