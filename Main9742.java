//10974 문제와 연계
//중요하다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main9742 {

    static char[] cArr;
    static boolean[] visit;
    static StringBuilder sb;
    static String s1;
    static int s1Length;
    static int cnt, num;
    static int flag;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String s = "";
        while((s = br.readLine())!= null){
            sb =  new StringBuilder();
            flag = 0;
            cnt=0;
            StringTokenizer st = new StringTokenizer(s," ");
            s1 = st.nextToken();
            s1Length = s1.length();
            cArr= new char[s1Length];
            visit = new boolean[s1Length];
            num = Integer.parseInt(st.nextToken());
            sb.append(s1);
            sb.append(" ");
            sb.append(num);
            sb.append(" = ");
            dfsPermutation(0);
            if(cnt<num){
                sb.append("No permutation");
            }
            System.out.println(sb.toString());
        }
    }

    public static void dfsPermutation(int depth){
        if(flag==1){
            return;
        }

        if(depth == s1Length){
            cnt++;
            if(cnt == num){
                for(int i = 0; i<s1Length; i++){
                    sb.append(cArr[i]);
                }
                flag=1;
                return;
            }
        }
        for(int i=0; i<s1Length; i++){
            if(!visit[i]){
                cArr[depth] = s1.charAt(i);
                visit[i] = true;
                dfsPermutation(depth+1);
                cArr[depth] = '_';
                visit[i] = false;
            }
        }
    }
}
