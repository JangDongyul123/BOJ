import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10809 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String st = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] alphabetArr = new int[26];
        for(int i=0; i<alphabetArr.length; i++){
            alphabetArr[i]=-1;
        }
        for(int i=0; i<st.length(); i++){
            if(alphabetArr[st.charAt(i)-'a'] ==-1){
                alphabetArr[st.charAt(i)-'a']=i;
            }
        }
        for(int i=0; i<alphabetArr.length; i++){
            sb.append(alphabetArr[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
