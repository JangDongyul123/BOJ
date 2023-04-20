import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10451 {
    static int T, N, cnt;
    static int [] v;
    static boolean [] visit;
    static List<List<Integer>> graph;

    static void dfs(int node){
        for(int i=0; i<graph.get(node).size(); i++){
            if(!visit[graph.get(node).get(i)]){
                visit[graph.get(node).get(i)]=true;
                dfs(graph.get(node).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        T= Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            cnt=0;
            graph = new ArrayList<>();
            N= Integer.parseInt(br.readLine());
            for(int i=0; i<=N; i++){
                graph.add(new ArrayList<>());
            }
            v=new int[N+1];
            visit = new boolean[N+1];

            st= new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=N; i++){
                v[i] = Integer.parseInt(st.nextToken());
                graph.get(i).add(v[i]);
                graph.get(v[i]).add(i);
            }
            for(int i=1; i<=N; i++){
                if(!visit[i]){
                    visit[i] = true;
                    cnt++;
                    dfs(i);
                }
            }
            System.out.println(cnt);
        }
    }
}
