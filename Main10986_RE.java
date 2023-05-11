import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        long[] sum = new long[N+1];
        for(int i=1; i<=N; i++){
            sum[i]= sum[i-1]+Integer.parseInt(st.nextToken());
        }
        long[] sumPerM = new long[M];
        for(int i=0; i<=N; i++){
            sumPerM[(int)(sum[i]%(long)M)]++;
        }
        long total=0;
        for(int i=0; i<M; i++){
            total+=(((sumPerM[i])*(sumPerM[i]-1))/2);
        }
        System.out.println(total);

    }
}