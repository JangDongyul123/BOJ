import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {
    static int F,S,G,U,D;
    static int[] startLink;
    static boolean[] visit;

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int peekStart = q.peek();
            q.poll();
            for(int i=0; i<2; i++){
                int newStart;
                if(i==0){
                   newStart = peekStart+U;
                }else{
                    newStart = peekStart-D;
                }
                if(1<=newStart && newStart<=F){
                    if(!visit[newStart]){
                        visit[newStart] = true;
                        startLink[newStart] = startLink[peekStart]+1;
                        q.offer(newStart);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F= Integer.parseInt(st.nextToken());
        S= Integer.parseInt(st.nextToken());
        G= Integer.parseInt(st.nextToken());
        U= Integer.parseInt(st.nextToken());
        D= Integer.parseInt(st.nextToken());
        startLink = new int[F+1];
        visit = new boolean[F+1];
        visit[S] = true;
        bfs(S);
        if((S==G) || (0<startLink[G])) {
            System.out.println(startLink[G]);
        }
        else {
            System.out.println("use the stairs");
        }
    }
}
