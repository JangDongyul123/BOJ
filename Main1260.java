import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    static int N,M,V;
    static List<List<Integer>> graph;
    static boolean[] visit;

    public static void dfs(int node) {
        visit[node] = true;
        System.out.print(node+" ");
        for(int i=0; i<graph.get(node).size(); i++) {
            int node2 = graph.get(node).get(i);
            if(!visit[node2]) {
                dfs(node2);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        System.out.print(node+" ");
        while(!q.isEmpty()) {
            int peekNode = q.peek();
            q.poll();
            for(int i=0; i<graph.get(peekNode).size(); i++) {
                int node2 = graph.get(peekNode).get(i);
                if(!visit[node2]) {
                    q.offer(node2);
                    visit[node2]=true;
                    System.out.print(node2+" ");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visit = new boolean[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0; i<=N; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }


        dfs(V);
        System.out.println();
        visit = new boolean[N+1];
        bfs(V);
    }
}
