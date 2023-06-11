import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map,dist;
    static boolean[][] visit;

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while (!q.isEmpty()){
            int peekY = q.peek()[0];
            int peekX = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int ny = peekY+dy[i];
                int nx = peekX+dx[i];
                if(0<=ny && 0<= nx && ny<N && nx<M){
                    if( (map[ny][nx]==1) && (dist[ny][nx]==0)){
                        dist[ny][nx] = dist[peekY][peekX]+1;
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
        dist = new int[N][M];
        visit = new boolean[N][M];

        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<M; x++){
                map[y][x] = Character.getNumericValue(str.charAt(x));
            }
        }
        dist[0][0] =1;
        bfs(0,0);

        System.out.println(dist[N-1][M-1]);
    }
}
