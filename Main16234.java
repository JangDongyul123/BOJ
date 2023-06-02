
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16234 {
    static int N,L,R;
    static int[][] map;
    static int[][] possible;//0으로 초기화 방문이 가능하면 1이 됨
    static int dayCount;//인구이동 날 계산
    static int flag;
    static int possibleNumber;

    static List<int[]> list;//국경 열린 애들 좌표 저장
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int totalSum;
    static int cnt;


    public static void dfs2(int y, int x){
        visit[y][x] = true;
        possible[y][x] = possibleNumber;
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if((0<=ny) && (ny<N) && (0<=nx) && (nx<N)){
                if( (L<=Math.abs(map[y][x]-map[ny][nx])) && (R>=Math.abs(map[y][x]-map[ny][nx])) && (!visit[ny][nx]) ){
                    dfs2(ny,nx);
                }
            }
        }

    }

    public static void isPossible(){

        visit = new boolean[N][N];

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                for(int i=0; i<4; i++){
                    int ny = y+dy[i];
                    int nx = x+dx[i];
                    if((0<=ny) && (ny<N) && (0<=nx) && (nx<N)){
                        if( (L<=Math.abs(map[y][x]-map[ny][nx])) && (R>=Math.abs(map[y][x]-map[ny][nx])) && (!visit[y][x]) ){
                            possibleNumber++;
                            flag=1;
                            dfs2(y,x);
                        }
                    }
                }

            }
        }

 /*       //가로 검사
        for(int y=0; y<N; y++){
            for(int x=0; x+1<N; x++){
                if((L<=Math.abs(map[y][x]-map[y][x+1])) && (R>=Math.abs(map[y][x]-map[y][x+1]))){
                    possible[y][x] = 1;
                    possible[y][x+1] = 1;
                    flag=1;
                }
            }
        }

        //세로 검사
        for(int x=0; x<N; x++){
            for(int y=0; y+1<N; y++){
                if((L<=Math.abs(map[y][x]-map[y+1][x])) && (R>=Math.abs(map[y][x]-map[y+1][x]))){
                    possible[y][x] = 1;
                    possible[y+1][x] = 1;
                    flag=1;
                }
            }
        }*/

        if(flag==1){
            dayCount++;//인구이동 발생한 날 하루 추가
            flag=0;
        }else{
            flag = 2;
        }
    }

    public static void ingusujojung(){
        visit = new boolean[N][N];
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(!visit[y][x] && (0<possible[y][x])){
                    list = new ArrayList<>();
                    totalSum = 0;
                    cnt = 0;
                    dfs(y,x);
                    for(int i=0; i<list.size(); i++){
                        map[list.get(i)[0]][list.get(i)[1]] = totalSum/cnt;
                    }
                }
            }
        }
    }

    public static void dfs(int y, int x){
        totalSum +=map[y][x];
        cnt++;
        visit[y][x] = true;
        list.add(new int[]{y,x});
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(0<=ny && ny<N && 0<=nx && nx<N)
                if(!visit[ny][nx] && (possible[ny][nx]==possible[y][x])){
                    dfs(ny,nx);
                }
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        possible = new int[N][N];
        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine()," ");
            for(int x=0; x<N; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        while(flag!=2){
            isPossible();
            //국경 여는 게 가능한지
            //가능하면 possible[y][x] =1;
            //그리고 국경 개방일 +1;
            if(flag==2){
                break;
            }

            //국경 열린 국가들끼리 인구수 조정
            ingusujojung();

            //국경선 닫기
            possible = new int[N][N];
        }
        System.out.println(dayCount);
    }
}