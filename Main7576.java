import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
    static int N, M, Z;
    static int[][] map;
    static boolean[][] visit;

    static int[][][] map1;
    static boolean[][][] visit1;

    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};

    public static void bfs(int z, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int peekY = q.peek()[0];
            int peekX = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nx = peekX+dx[i];
                int ny = peekY+dy[i];
                if(0<=ny && ny<N && 0<=nx && nx<M){
                    if(!visit1[z][ny][nx] && map1[z][ny][nx] != -1){
                        visit1[z][ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                        map1[z][ny][nx] = map1[z][peekY][peekX]+1;
                    }
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
        map = new int[N][M];
        visit = new boolean[N][M];

        int flag2=0;
        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int x=0; x<M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x]==1){
                    //1의 개수 만큼 시작점의 개수인 Z가 늘어난다.
                    Z++;
                }
                if(map[y][x]==0){
                    //문제의 마지막 조건인, 이미 처음부터 다 익은 상태면 flag2는 0을 유지
                    flag2=1;
                }
            }
        }
        map1 = new int[Z][N][M];
        visit1 = new boolean[Z][N][M];

        //map 에 -1 대입
        zLoop:for(int z=0; z<Z; z++){
            yLoop:for(int y=0; y<N; y++){
                xLoop:for(int x=0; x<M; x++){
                    if(map[y][x]==-1){
                        map1[z][y][x] =-1;
                    }
                }
            }
        }

        //map 에 시작점 1 대입
        zLoop:for(int z=0; z<Z; z++){
            yLoop:for(int y=0; y<N; y++){
                xLoop:for(int x=0; x<M; x++){
                    if(map[y][x]==1 && !visit[y][x]){
                        visit[y][x]=true;
                        map1[z][y][x] = 1;
                        break yLoop;
                    }
                }
            }
        }

       /* //잘 되었는지 출력
        zLoop:for(int z=0; z<Z; z++){
            yLoop:for(int y=0; y<N; y++){
                xLoop:for(int x=0; x<M; x++){
                        System.out.print(map1[z][y][x]+ " ");
                    }
                System.out.println();
                }
            System.out.println();
            System.out.println();
            }*/

        //bfs
        zLoop:for(int z=0; z<Z; z++) {
            yLoop:for (int y = 0; y < N; y++) {
                xLoop:for (int x = 0; x < M; x++) {
                    if((!visit1[z][y][x]) && map1[z][y][x]==1){
                        visit1[z][y][x]=true;
                        bfs(z,y,x);
                    }
                }
            }
        }

/*        //잘 되었는지 출력
        zLoop:for(int z=0; z<Z; z++){
            yLoop:for(int y=0; y<N; y++){
                xLoop:for(int x=0; x<M; x++){
                    System.out.print(map1[z][y][x]+ " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }*/

        //각 1에서 시작한 일수들 중 제일 낮은 일수로 대입
            yLoop:for(int y=0; y<N; y++){
                xLoop:for(int x=0; x<M; x++){
                    int min=2000;
                    for(int z=0; z<Z; z++){
                        if(map1[z][y][x]<min){
                            min = map1[z][y][x];
                        }
                    }
                   map[y][x] = min;
                }
        }

        //map에서 가장 큰 녀석 가져오기
        int max=0;
        int flag=0;
        yLoop:for(int y=0; y<N; y++){
            xLoop:for(int x=0; x<M; x++){
                if(max<map[y][x]){
                    max=map[y][x];
                }
                if(map[y][x]==0){
                    //지리적 위치 상 익을 수 없는 토마토 발견
                    flag=1;
                }
            }
        }
    /*    //잘 되었는지 출력
        yLoop:for(int y=0; y<N; y++){
            xLoop:for(int x=0; x<M; x++){
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }*/

        //flag =1 지리적 위치상 익을 수 없는 토마토 발견
        //flag2 =0 이미 시작부터 모든 토마토가 익은 것
        if((flag==0) && (flag2==1)){
            System.out.println(max-1);
        } else if (flag2 == 0) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

    }
}