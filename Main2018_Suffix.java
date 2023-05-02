//시간초과
//누적합 문제 같다고 무조건 누적합만 쓰면 안된다.
//누적합 공식을 쓸 때 느려지면 투포인터를 쓰라는 좋은 교훈이자 반례 코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2018_Suffix {
    static int N;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1];
        for(int i=1; i<N+1; i++){
            sum[i] = sum[i-1]+i;
        }
        int cnt=0;
        for(int y=0; y<N;y++){
            for(int x=N; 0<x; x--){
                if((sum[x]-sum[y])==N){
                  cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
