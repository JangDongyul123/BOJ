import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

    static int[] arr;
    static int N,M;

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M= Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++) {
            int q = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = arr.length-1;
            int mid = (start+end)/2;
            int flag=0;
            while(start<=end) {
                if(q==arr[mid] ) {
                    sb.append(1);
                    sb.append("\n");
                    flag=1;
                    break;
                }else if(q<arr[mid]) {
                    end = mid-1;
                    mid = (start+end)/2;
                }else if(q>arr[mid]) {
                    start = mid+1;
                    mid = (start+end)/2;
                }
            }
            if(flag==0) {
                sb.append(0);
                sb.append("\n");
                //flag=1;
            }
        }
        System.out.println(sb);
    }
}
