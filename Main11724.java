import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main11724 {
    static int N,M,u,v, cnt;
    static List<List<Integer>> graph;
    static boolean [] visit;

    static void dfs(int node){
        for(int i=0; i<graph.get(node).size(); i++){
            int node2 = graph.get(node).get(i);//node와 인접정점 node2
            if(!visit[node2]){
                visit[node2] = true;
                dfs(node2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int n=0; n<= N; n++){
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        for(int m = 0; m<M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1; i<=N ; i++){
            if(!visit[i]){
                visit[i] = true;
                cnt++;
                dfs(i);
            }
        }
  /*      for(int y=0; y<=N; y++){
            System.out.print(y+" 정점: ");
            for(int x=0; x<graph.get(y).size(); x++){
                System.out.print(graph.get(y).get(x)+" ");
            }
            System.out.println();
        }*/
        System.out.println(cnt);

    }
}
