import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N,M;
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + arr[i];
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int q= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            sb.append(sum[w]-sum[q-1]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
