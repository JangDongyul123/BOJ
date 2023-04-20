import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {

    static int T, L, x1, y1, x2, y2;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});

        while(!q.isEmpty()){
            int peekX = q.peek()[1];
            int peekY = q.peek()[0];
            q.poll();

            for(int i=0; i<8; i++){
                int nx = peekX+dx[i];
                int ny = peekY+dy[i];
                if(0<=nx && nx<L && 0<=ny && ny<L){
                    if(!visit[ny][nx]){
                        visit[ny][nx] = true;
                        map[ny][nx] = map[peekY][peekX]+1;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            L = Integer.parseInt(br.readLine());
            map = new int[L][L];
            visit = new boolean[L][L];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            visit[y1][x1] = true;
            bfs(y1, x1);
            System.out.println(map[y2][x2]);
        }

    }
}