import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static int M,N;
    static int [][]map;
    static boolean [][]visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while (!q.isEmpty()){
            int qy = q.peek()[0];
            int qx = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int ny = qy+dy[i];
                int nx = qx+dx[i];
                if(0<=nx && nx< M && 0<=ny && ny< N){
                    if(0<map[ny][nx] && !visit[ny][nx]){
                        visit[ny][nx]=true;
                        map[ny][nx] = map[qy][qx]+1;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<M; x++){
                map[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(!visit[y][x] && map[y][x]==1){
                    visit[y][x]=true;
                    bfs(y,x);
                }
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}
