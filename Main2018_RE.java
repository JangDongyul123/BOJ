import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2018_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
        int sum=1;
        int p1=1;
        int p2=1;
        int cnt=0;
        while(p1<=N){
            if(sum<N){
                p2++;
                sum+=arr[p2];
            }else if(sum==N){
                cnt++;
                sum-=arr[p1];
                p1++;
            }else if(sum>N){
                sum-=arr[p1];
                p1++;
            }
        }
        System.out.println(cnt);
    }
}
