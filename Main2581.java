import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2581 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[]  arr = new int[N+1];
        for(int i=2; i<=N; i++){
            arr[i] = i;
        }
        for(int i=2; i<=Math.sqrt(N) ; i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j<= N; j=j+i){
                arr[j]=0;
            }
        }
        int sum =0;
        int min =0;
        int flag=0;
        for(int i=M; i<=N; i++){
            if(arr[i]!=0) {
                if(flag==0){
                    min=arr[i];
                    flag=1;
                }
                sum+=arr[i];
            }
        }
        if(sum==0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
