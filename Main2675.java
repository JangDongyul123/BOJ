import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2675 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine()," ");
            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i=0; i<s.length(); i++){
                for(int r=0; r<R; r++){
                    sb.append(s.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
