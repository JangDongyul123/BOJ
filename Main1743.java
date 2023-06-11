import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main1743 {

    static int N,M,K;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> cntList;
    static int cnt;

    public static void dfs(int y, int x){
        visit[y][x] = true;
        cnt++;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<= nx && 0<=ny && nx<M && ny<N){
                if((!visit[ny][nx]) && (map[ny][nx] =='#')){
                    dfs(ny,nx);
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
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        cntList = new ArrayList<>();

        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                map[y][x] = '.';
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = '#';
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if((map[y][x] == '#') &&(!visit[y][x])){
                    cnt=0;
                    dfs(y,x);
                    cntList.add(cnt);
                }
            }
        }
        cntList.sort(Comparator.reverseOrder());
        System.out.println(cntList.get(0));
    }
}