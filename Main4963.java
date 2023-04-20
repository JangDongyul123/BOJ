import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4963 {
    static int w,h;
    static int[][] map;
    static boolean[][] visit;
    static boolean loop=true;
    static int count;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};

    static void dfs(int x, int y){
        visit[y][x] = true;
        for(int i=0; i <8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx< w && 0<=ny && ny<h){
                if(map[ny][nx]==1 && !visit[ny][nx]){
                    dfs(nx,ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        while (loop) {
            count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                loop = false;
                break;
            }

            map = new int[h][w];
            visit = new boolean[h][w];
            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if(map[y][x]==1 && !visit[y][x]){

                        count++;
                        dfs(x,y);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
