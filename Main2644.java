import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2644 {

    static int n, h1,h2, m;
    static List<List<Integer>> graph;
    static boolean[] visit;
    static int[] map;
    public static void bfs(int h1){
        Queue<Integer> q = new LinkedList<>();
        q.offer(h1);
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int i=0; i<graph.get(node).size(); i++){
                int adv = graph.get(node).get(i);
                if(!visit[adv]){
                    visit[adv] = true;
                    map[adv] = map[node]+1;
                    q.offer(adv);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h1 = Integer.parseInt(st.nextToken());
        h2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        map = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visit[h1] = true;
        bfs(h1);
        if(map[h2]!=0 || (h2==h1)){
        System.out.println(map[h2]);
        }else{
            System.out.println(-1);
        }
    }
}