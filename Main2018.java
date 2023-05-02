import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2018 {
    static int N;
    static int sum;
    static int end;
    static int cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (i+1);
        }
        for(int start = 0 ; start<N; start++){
            while(sum<N && end <N){
                sum+=arr[end];
                end++;
            }
            if(sum==N){
                cnt++;
            }
            sum-=arr[start];
        }
        System.out.println(cnt);
    }
}