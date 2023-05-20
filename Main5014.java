import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main5014 {

    static int F,S,G,U,D;
    static int[] dy;
    static int[] cnt;
    static boolean[] visit;

    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(S);
        visit[S] = true;
        while(!q.isEmpty()) {
            int peekY = q.peek();
            q.poll();
            for(int i=0; i<2; i++) {
                int ny = peekY+dy[i];
                if(1<=ny && ny<=F) {
                    if(!visit[ny]) {
                        visit[ny] = true;
                        cnt[ny]=cnt[peekY]+1;
                        q.offer(ny);
                    }
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dy = new int[] {U,-D};
        cnt = new int[F+1];
        visit = new boolean[F+1];
        bfs();
        if(cnt[G]!=0) {
            System.out.println(cnt[G]);
        }else {
            if(S==G) {
                System.out.println(0);
            }else {
                System.out.println("use the stairs");
            }
        }
    }
}