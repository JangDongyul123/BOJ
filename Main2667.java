import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main2667 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int cnt;
    static int total;
    static ArrayList<Integer> complexes = new ArrayList<>();

    public static void dfs(int x, int y){
        total++;
        for(int i=0; i<4; i++){
            int nx= x+dx[i];
            int ny= y+dy[i];
            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(map[ny][nx]==1 && !visit[ny][nx]){
                    visit[ny][nx]=true;
                    dfs(nx,ny);
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

        for(int y=0; y<N; y++)
        {
            String str = br.readLine();
            for(int x=0; x<N; x++)
            {
                int m = Character.getNumericValue(str.charAt(x));
                map[y][x] = m;
            }
        }
        for(int y=0; y<N; y++)
        {
            for(int x=0; x<N; x++)
            {
                if(map[y][x]==1 && !visit[y][x]) {

                    visit[y][x] = true;
                    dfs(x, y);
                    complexes.add(total);
                    total=0;
                }
            }
        }
        System.out.println(complexes.size());

        complexes.sort(Comparator.reverseOrder());//내림차순
        //Collections.sort(complexes);
        complexes.sort(Comparator.naturalOrder());//오름차순

        for(int i=0; i<complexes.size(); i++){
            System.out.println(complexes.get(i));
        }
    }
}
/*
if(map[y][x]==1 && (!visit[y][x]))
        {
        visit[y][x] = true;
        dfs(x,y);
        }*/
