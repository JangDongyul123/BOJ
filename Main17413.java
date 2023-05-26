import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17413 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), "<> ", true);
        String[] sArr = new String[st.countTokens()];
        StringBuilder sb = new StringBuilder();
        int flag=0;
        for(int i=0; i< sArr.length; i++){
            sArr[i] = st.nextToken();
            if("<".equals(sArr[i])){
                flag=1;
                sb.append(sArr[i]);
                continue;
            }else if(">".equals(sArr[i])){
                flag=0;
                sb.append(sArr[i]);
                continue;
            }
            if(flag ==1){
                sb.append(sArr[i]);
            }else if(flag ==0){
                StringBuilder rs = new StringBuilder();
                for(int j=sArr[i].length()-1; 0<=j; j--){
                    rs.append(sArr[i].charAt(j));
                }
                sb.append(rs);
            }
        }
        System.out.println(sb);
    }
}
