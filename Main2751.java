import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main2751 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is =new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i=0; i<N; i++){
            sb.append(arr[i]);
            sb.append('\n');
            //System.out.println(arr[i]);
            //쓰면 시간 초과
            //System.out.println()은 최대한 적게 쓰는 게 좋다.
        }
        System.out.print(sb);
    }
}
