import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {

    public static long[] s;
    public static long[] c;
    public static int N,M;

   //콤비네이션 함수 만들 때 자칫하면 long 범위를 초과하면 큰일이니, 신중하게 잘 만들어야 한다.

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new long[N+1];
        //sum을 담습니다.
        c = new long[M];
        //sum%3 결과의 개수를 담습니다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            s[i] = s[i-1]+ Long.parseLong( st.nextToken());
        }
        for(int i=0; i<=N; i++){
            c[(int)(s[i]%M)]++;
        }
        long answer=0;
        for(int i=0; i<M; i++){
            if(1<c[i]){
                //answer+=combination(c[i],2);
                answer+=c[i]*(c[i]-1)/2;

            }
        }

        System.out.println(answer);
    }
}
