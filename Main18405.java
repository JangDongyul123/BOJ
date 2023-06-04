//미완성
//빅오 n^3 시간초과 SIB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main18405 {
    static int[][] map, map0;
    static int[][] sec;
    static int N,K;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void bfs(){
        LinkedList<int []> q = new LinkedList<>();
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(0<map[y][x]){
                    if(q.isEmpty()){
                        q.offer(new int[]{y,x});
                    }else{//비어있지 않다면 비교
                        int index = q.size();
                        while(0<=index){
                            if(map[y][x] <map[q.get( index-1)[0]][q.get( index-1)[1]]  ){
                                //작은 게 앞으로
                                index--;//new int[]{y,x}를 넣을 인덱스 감소
                                if(index==0){
                                    break;
                                }
                            }else{
                                break;
                            }
                        }
                        if(index<0){
                            q.add(0, new int[]{y,x});
                        }
                        q.add(index, new int[]{y,x});
                    }
                }
            }
        }

        //람다와 effectively final에 대해 공부하자
        /* q.sort(Comparator.comparing((o1, o2) -> {
            return (map[o1[0]][o1[1]] -  map[o2[0]][o2[1]]);
        }));*/
        while(!q.isEmpty()){
            int peekY = q.peekFirst()[0];
            int peekX = q.peekFirst()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int ny = peekY + dy[i];
                int nx = peekX + dx[i];
                if((0<=ny) && (ny<N) && (0<=nx) && (nx<N)){
                    if(0==map[ny][nx]){
                        map[ny][nx] = map[peekY][peekX];
                        sec[ny][nx] = sec[peekY][peekX]+1;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        map0 = new int[N][N];
        sec = new int[N][N];

        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine()," ");
            for(int x=0; x<N; x++){
                int num = Integer.parseInt(st.nextToken());
                map[y][x] =  num;
                map0[y][x] =  num;
            }
        }
        bfs();
        st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        if(sec[X-1][Y-1]<=S){
            System.out.println(map[X-1][Y-1]);
        }else{
            System.out.println(map0[X-1][Y-1]);
        }
    }
}
