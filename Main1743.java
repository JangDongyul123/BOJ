import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main1743 {
    static char[][] map;
    static boolean[][] visit;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int cnt,N,M,K;
    static List<Integer> cntList = new ArrayList<>();

    static void dfs(int y, int x){
        cnt++;
        visit[y][x]=true;
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(0<=ny && ny<N && 0<=nx && nx<M){
                if(!visit[ny][nx] && map[ny][nx]=='#'){
                    dfs(ny,nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                map[y][x] = '.';
            }
        }
        visit = new boolean[N][M];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine()," ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1]='#';
        }
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(!visit[y][x] && map[y][x] =='#'){
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
