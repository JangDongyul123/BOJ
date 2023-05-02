import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1940 {
    static int N;
    static int M;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int cnt=0;
        while(start<end){
            if(arr[start]+arr[end]<M){
                start++;
            }else if(arr[start]+arr[end]>M){
                end--;
            }else if(arr[start]+arr[end]==M){
                start++;
                end--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}