import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2577 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String str = Integer.toString(A*B*C);
        int[] arr = new int[10];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'0']++;
        }
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
