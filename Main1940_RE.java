import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1940_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int p1 = 0;
        int p2 = arr.length-1;
        int sum=0;
        int cnt=0;
        while(p1<p2){
            sum=arr[p1]+arr[p2];
            if(sum<M){
                p1++;
            }else if(sum==M){
                cnt++;
                p1++;
            }else if(sum>M){
                p2--;
            }
        }
        System.out.println(cnt);
    }
}
