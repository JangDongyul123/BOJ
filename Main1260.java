import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    static int N,M,V;
    static List<List<Integer>> graph;
    static boolean [] visit;

    public static void dfs(int start){
        System.out.print(start+" ");
        for(int i=0 ; i<graph.get(start).size(); i++){
            int node = graph.get(start).get(i);
            if(!visit[node]){
                visit[node]=true;
                dfs(node);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            System.out.print(x+" ");
            for(int i=0; i<graph.get(x).size();i++){
                int node = graph.get(x).get(i);
                if(!visit[node]){
                    visit[node] = true;
                    q.offer(node);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        V= Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int n=0; n<=N; n++){
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        for(int m=0; m<M; m++){
            int u,v;
            st = new StringTokenizer(br.readLine()," ");
            u= Integer.parseInt(st.nextToken());
            v= Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int n=0; n<=N; n++){
            graph.get(n).sort(Comparator.naturalOrder());
        }
  /*      for(int y=1; y<=N; y++){
            System.out.print(y+" ");
            for(int x=0; x< graph.get(y).size(); x++){
                System.out.print(graph.get(y).get(x)+" ");
            }
            System.out.println();
        }*/

        visit[V]=true;
        dfs(V);
        System.out.println();
        visit = new boolean[N+1];
        visit[V]=true;
        bfs(V);
    }
}
