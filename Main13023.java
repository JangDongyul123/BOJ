import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main13023 {

    static int N,M;
    static List<List<Integer>> graph;
    static boolean flag;
    static boolean[] visit;

    public static void dfs(int number, int cnt) {

        visit[number] = true;

        if(flag) {
            return;
        }

        if(cnt==5) {
            flag=true;
        }
        for(int i=0; i<graph.get(number).size(); i++) {
            int number2 = graph.get(number).get(i);
            if(!visit[number2]) {
                dfs(number2,cnt+1);
            }
        }

        visit[number] = false;

    }


    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visit = new boolean[N];

        for(int i=0; i<M ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<N; i++) {
            dfs(i,1);
            if(flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
