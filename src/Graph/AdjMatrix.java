package Graph;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

//从文件中读取信息，并整理成邻接矩阵的形式
public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) {
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if(V < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new int[V][V];
            E = scanner.nextInt();
            if(E < 0) {
                throw new IllegalArgumentException("E must be non-negative");
            }
            for(int i = 0; i < E; i++) {
                //a和b必须在0到V-1之间
                int a = scanner.nextInt();
                validateVertex(a);  //需要验证每一个a的合法性
                int b = scanner.nextInt();
                validateVertex(b);  //需要验证每一个b和合法性
                if(a == b) {        //验证图是否为自环边，即a=b
                    throw new IllegalArgumentException("Self Loop is Detected!");
                }
                if(adj[a][b] == 1) {
                    throw new IllegalArgumentException("Parallel Edge is Detected!");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if(v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex" + v + "is invalid");
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    //两个顶点之间是否有边
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }
    //返回与v相邻的顶点
    public ArrayList<Integer> adj(int v) {
        validateVertex(v);      //验证v的合法性
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }
    //返回v的度
    public int degree(int v) {
        return adj(v).size();
    }

    //打印邻接矩阵
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
