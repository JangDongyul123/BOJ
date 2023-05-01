import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {

    static int N,M;
    static long[] sum;
    static long[] C;
    static long answer;

    public static long combination(long n, long p){
        long N=1;
        long P =1;
        for(long i=p; 0<i; i--){
            P*=i;
        }
        for(long i=n; p<=i; i--){
            N*=i;
        }
        return (N/P);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new long[N];
        C = new long[M];
        st = new StringTokenizer(br.readLine(), " ");

        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            long remainder = (sum[i] %M);
            if(remainder == 0){
                answer++;
            }
            C[(int)remainder]++;
        }

        for(int i=0; i<M; i++){
            if(C[i]>1){
               answer = answer+combination(C[i],2);
            }
        }
        System.out.println(answer);
    }
}
