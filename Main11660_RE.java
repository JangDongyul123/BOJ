import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];
        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine()," ");
            for(int x=1; x<=N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for(int y=1; y<=N; y++){
            for(int x=1; x<=N; x++){
                sum[y][x] = sum[y-1][x]+sum[y][x-1]-sum[y-1][x-1]+map[y][x];
            }
        }
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
