import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929_RE {
    public static void main(String[] args) throws IOException {
        int M, N;
        int[]arr;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb =new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=0; i< arr.length; i++){
            arr[i]=i;
        }
        arr[1]=0;//소수가 아님

        //에라토스테네스의 체
        for(int i=2; i< arr.length; i++){
            if(arr[i]==0)continue;//소수가 아니면 지나간다.
            for(int j=i+i; j< arr.length; j=j+i){
                arr[j]=0;
            }
        }

        for(int i=M; i<= N; i++){
            if(arr[i]!=0){
                sb.append(arr[i]);
                sb.append('\n');

            }
        }
        System.out.println(sb);
    }
}
