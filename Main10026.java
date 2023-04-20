import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt1, cnt2;
    public static void dfs(int x, int y, char color){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if((!visit[ny][nx]) && (color == map[ny][nx])){
                    visit[ny][nx]=true;
                    dfs(nx,ny, color);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        //일반인
        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = str.charAt(x);
            }
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(!visit[y][x]){
                    cnt1++;
                    visit[y][x] = true;
                    dfs(x,y, map[y][x]);
                }
            }
        }
        //System.out.println(cnt1);

        //방문 초기화
        visit = new boolean[N][N];
        //
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(map[y][x] == 'R'){
                   map[y][x] = 'G';
                }
            }
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(!visit[y][x]){
                    cnt2++;
                    visit[y][x] = true;
                    dfs(x,y, map[y][x]);
                }
            }
        }
        System.out.println(cnt1+" "+cnt2);
    }
}
