import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {

    static char[][] map;

    public static int solution(int y, int x) {
        String[] whiteBoard = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSolution=0;
        for(int dy=0; dy<8; dy++) {
            for(int dx=0; dx<8; dx++) {
                int ny = y+dy;
                int nx = x+dx;
                if(map[ny][nx] != whiteBoard[dy%2].charAt(dx)) {
                    whiteSolution++;
                }
            }
        }
        int blackSolution = 64 - whiteSolution;
        return Math.min(whiteSolution, blackSolution);
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int y=0; y<N; y++) {
            String str = br.readLine();
            for(int x=0; x<M; x++) {
                map[y][x] = str.charAt(x);
            }
        }
        int minSol = Integer.MAX_VALUE;
        for(int y=0; y<=(N-8); y++) {
            for(int x=0; x<=(M-8); x++) {
                int sol = solution(y, x);
                if(sol<minSol) {
                    minSol = sol;
                }
            }
        }
        System.out.println(minSol);
    }
}
