import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1978 {

    static int cnt2;

    public static void isPrime(int[] arr){

        for(int i:arr){
            int cnt1=0;
            for(int j=1; j<=i; j++){
                if(i%j==0){
                    cnt1++;
                }
            }
            if(cnt1==2){
                cnt2++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        isPrime(arr);
        System.out.println(cnt2);
    }
}
