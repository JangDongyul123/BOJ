import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
    static int N, K;
    static int[] dx ={1,-1};
    static int[] map;
    static boolean[] visit;

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int peekX = q.peek();
            q.poll();
            for(int i=0; i<3;i++){
                int nx;
                if(i==2){
                    nx = peekX*2;
                }else{
                    nx = peekX+dx[i];
                }
                if(0<= nx && nx<=100000){
                    if(!visit[nx]){
                        visit[nx]= true;
                        map[nx] = map[peekX]+1;
                        q.offer(nx);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new int[100001];
        visit = new boolean[100001];
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit[N]=true;
        bfs(N);
        System.out.println(map[K]);
    }
}
