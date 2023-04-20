import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2583 {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visit;
    static int lx,ly,rx,ry;
    static int cnt1,cnt2;
    static int []dx={1,0,-1,0};
    static int []dy={0,1,0,-1};
    static List<Integer> count;

    public static void dfs(int x, int y){
        cnt2++;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<M) {
                if (!visit[ny][nx] && map[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[M][N];
        count = new ArrayList<>();
        for(int y=0; y<M; y++){
            for(int x=0; x<N; x++){
                map[y][x] = 1;
            }
        }

       /* for(int y=0; y<M;y++){
            for(int x=0; x<N; x++) {
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }*/

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            lx=Integer.parseInt(st.nextToken());
            ly=Integer.parseInt(st.nextToken());
            rx=Integer.parseInt(st.nextToken());
            ry=Integer.parseInt(st.nextToken());
            for(int y=0; y<(ry-ly); y++){
                for(int x=0; x<(rx-lx); x++){
                    int nx = lx+x;
                    int ny = ly+y;
                    map[ny][nx]=0;
                }
            }
        }

     /*   for(int y=0; y<M;y++){
            for(int x=0; x<N; x++) {
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }*/

        for(int y=0; y<M;y++){
            for(int x=0; x<N; x++) {
                if(!visit[y][x] && map[y][x] ==1)
                {
                    cnt1++;
                    visit[y][x]=true;
                    dfs(x,y);
                    count.add(cnt2);
                    cnt2=0;
                }
            }
        }
        count.sort(Comparator.naturalOrder());
        System.out.println(count.size());
        for(int i=0 ; i<count.size(); i++){
            System.out.print(count.get(i)+" ");
        }
    }
}
