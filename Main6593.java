import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {
    static int L,R,C;
    static char[][][] map;
    static int[][][] minute;
    static boolean[][][] visit;
    static int[] dx = {0,0,1,0,-1,0};
    static int[] dy = {0,0,0,1,0,-1};
    static int[] dz = {1,-1,0,0,0,0};

    public static void bfs(int z, int y, int x){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{z,y,x});
        while(!q.isEmpty()){
            int peekZ = q.peek()[0];
            int peekY = q.peek()[1];
            int peekX = q.peek()[2];
            q.poll();
            for(int i=0; i<6; i++){
                int nz = peekZ + dz[i];
                int ny = peekY + dy[i];
                int nx = peekX + dx[i];
                if((0<=nz) && (nz<L) && (0<=ny) && (ny<R)&& (0<=nx) && (nx<C) ){
                    if((!visit[nz][ny][nx])&&(map[nz][ny][nx]!='#')){
                        visit[nz][ny][nx] = true;
                        minute[nz][ny][nx] = minute[peekZ][peekY][peekX]+1;
                        q.offer(new int[]{nz,ny,nx});
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        //System.in 바이트 단위 콘솔 입력객체
        //이걸 Char 단위로 받게 보조스트림 InputStreamReader
        BufferedReader br = new BufferedReader(is);
        //버퍼 사용으로 속도 향상

        while(true) {
            String str = br.readLine();
            if("".equals(str)){
                str = br.readLine();
            }
            if ("0 0 0".equals(str)) {
                //System.out.println(str);
                break;
            }
            StringTokenizer st = new StringTokenizer(str, " ");
            //br이 콘솔창의 모든 문장을 cb에 담는데,
            //br.readLine()이 cb로부터 한줄씩 읽고,
            //StringTokenizer가 " " 단위로 nextToken()으로 가리킴

            L =Integer.parseInt(st.nextToken());
            //문자열 정수를 Integer 정수로 Integer.parseInt(문자열 정수)
            //문자 정수를 Integer 정수로 Character.getNumericValue(문자 정수)
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[L][R][C];
            minute = new int[L][R][C];
            visit = new boolean[L][R][C];
            int[] S= new int [3];
            int[] E= new int [3];
            for(int z=0; z<L; z++){
                for(int y=0; y<R; y++){
                    String str1 = br.readLine();
                    if("".equals(str1)){
                        str1 = br.readLine();
                    }
                    for(int x=0; x<C; x++){
                        map[z][y][x] = str1.charAt(x);
                        if(map[z][y][x] == 'S'){
                            S[0]=z;
                            S[1]=y;
                            S[2]=x;
                        }else if(map[z][y][x] == 'E'){
                            E[0]=z;
                            E[1]=y;
                            E[2]=x;
                        }
                    }
                }
            }

            visit[S[0]][S[1]][S[2]]=true;
            bfs(S[0],S[1],S[2]);

            if(minute[(E[0])][(E[1])][(E[2])] ==0){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in "+minute[(E[0])][(E[1])][(E[2])]+" minute(s).");
            }
        }
    }
}
