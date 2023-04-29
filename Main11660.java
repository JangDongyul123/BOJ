//문제가 악질이다.
//X를 행으로 Y를 열로 냈다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    static int[][] map;
    static int[][] sum;
    static boolean[][] visit;
    static int N,M;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new int[N][N];
        sum = new int[N][N];
        visit = new boolean[N][N];

        for(int y=0; y<N; y++){
            str = new StringTokenizer(br.readLine(), " ");
            for(int x=0; x<N; x++){
                map[y][x] = Integer.parseInt(str.nextToken());
                if(y==0 && x!=0){
                    sum[y][x] = sum[y][x-1] +map[y][x];
                }else if(x==0 && y!=0)
                {
                    sum[y][x] =sum[y-1][x] +map[y][x];
                }else if(x==0 && y==0){
                    sum[y][x] = map[y][x] ;
                }else{
                    sum[y][x] = sum[y][x-1] + sum[y-1][x] +map[y][x] -sum[y-1][x-1];
                }
            }
        }

        for(int i=0; i<M; i++){
            str = new StringTokenizer(br.readLine(), " ");
            int X1,Y1,X2,Y2;
            Y1 = Integer.parseInt(str.nextToken())-1;
            X1 = Integer.parseInt(str.nextToken())-1;

            Y2 = Integer.parseInt(str.nextToken())-1;
            X2 = Integer.parseInt(str.nextToken())-1;

            int result = 0;
            if(X1==0 && Y1!=0){
                result =sum[Y2][X2] - sum[Y1-1][X2] ;
            }else if(X1!=0 && Y1==0){
                result =sum[Y2][X2] - sum[Y2][X1-1] ;
            }else if(X1==0 && Y1==0){
                result =sum[Y2][X2] ;
            }else{
                result =sum[Y2][X2] - sum[Y2][X1-1] - sum[Y1-1][X2] + sum[Y1-1][X1-1];
            }

            System.out.println(result);
        }


    }
}
