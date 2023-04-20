import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2606 {

    public static int T, E, u, v, cnt;
    public static List<List<Integer>> graph;
    public static boolean[] visit;

    public static void dfs(int node){
        cnt++;
        for(int i=0; i<graph.get(node).size(); i++){
            int node2 = graph.get(node).get(i);
            if(!visit[node2]){
                visit[node2] = true;
                dfs(node2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        T= Integer.parseInt(br.readLine());
        E= Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visit = new boolean[T+1];
        for(int i=0; i<=T; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st=new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

                visit[1] = true;
                dfs(1  );
        System.out.println(cnt-1);
        }
    }

