import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i=2; i<=N; i++){
            arr[i] =i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){
            if(arr[i]==0)
                continue;//소수가 아니면 넘어간다.
            for(int j=i+i; j<=N; j=j+i){
                arr[j] = 0;
            }
        }

        for(int i=M; i<=N; i++){
            if(arr[i]!=0){
                System.out.println(arr[i]);
            }
        }

    }
}
