import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1748 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N  = Integer.parseInt(br.readLine());
        long sum = 0;
        int cnt=1;
        int length=10;
        for(int i=1; i<=N; i++){
            if(i==length){
                length*=10;
                cnt++;
            }
            sum+=cnt;
        }
        System.out.println(sum);
    }
}