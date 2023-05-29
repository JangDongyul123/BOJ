import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9093 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] stArr1;
        String[] stArr2;
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine()," ",true);
            stArr1 = new String[st.countTokens()];
            int cnt = st.countTokens();
            for(int i=0; i<cnt; i++){
                stArr1[i] = st.nextToken();
                char[] cArr = new char[stArr1[i].length()];
                for(int j=0; j<stArr1[i].length(); j++){
                    cArr[j] = stArr1[i].charAt(stArr1[i].length()-1-j);
                }
                stArr1[i] = new String(cArr);
                sb.append(stArr1[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
