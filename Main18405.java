import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18405 {

    static int N,K;
    static int[][] map;
    static int S,X,Y;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Node{
        int x;
        int y;
        int time;
        int virus;
        Node(int x, int y, int time, int virus){
            this.x = x;
            this.y = y;
            this.time = time;
            this.virus = virus;
        }
        public int getX(){
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }

        public int getVirus() {
            return virus;
        }
    }

    static Queue<Node> q = new LinkedList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1,o2)->{
                return o1.virus - o2.virus;
            }
    );

    public static void bfs(){
        while (!q.isEmpty()){
            Node peekNode = q.poll();
            if(peekNode.time==S){
                return;
            }
            int peekY = peekNode.getY();
            int peekX = peekNode.getX();
            for(int i=0; i<4; i++){
                int ny = peekY + dy[i];
                int nx = peekX + dx[i];
                if(0<=ny && 0<= nx && ny<N && nx<N){
                    if(map[ny][nx] == 0){
                        map[ny][nx] = peekNode.getVirus();
                        q.offer(new Node(nx,ny,peekNode.getTime()+1, peekNode.getVirus()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine()," ");
            for(int x=0; x<N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x]>0){
                    pq.offer(new Node(x,y,0,map[y][x]));
                }
            }
        }

        while(!pq.isEmpty()){
            q.offer(pq.poll());
        }

        st = new StringTokenizer(br.readLine()," ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs();

/*
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }
*/

        System.out.println(map[X-1][Y-1]);
    }
}