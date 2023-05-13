import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main2468 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, cnt;
    static List<Integer> cntList;
    public static void dfs(int y, int x, int safeHeight){
        visit[y][x]=true;
        for(int i=0; i<4; i++){
            int ny = y+ dy[i];
            int nx = x+ dx[i];
            if((0<=nx) && (nx<N) && (0<=ny) && (ny<N)){
                if((!visit[ny][nx]) && (safeHeight<map[ny][nx])){
                    dfs(ny,nx,safeHeight);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        cntList = new ArrayList<>();
        for(int y=0; y<N; y++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int x=0; x<N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for(int safeHeight=0; safeHeight<101; safeHeight++){
            //safeHeight=1로 해서 틀렸음 safeHeight=0의 의미는 아무 지역도 잠기지 않는 것. 비가 안온 날을 의미
            cnt=0;
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    if((safeHeight<map[y][x]) && (!visit[y][x])){
                        dfs(y,x, safeHeight);
                        cnt++;
                    }
                }
            }
            visit = new boolean[N][N];
            cntList.add(cnt);
        }
        cntList.sort(Comparator.reverseOrder());
        System.out.println(cntList.get(0));
    }
}
