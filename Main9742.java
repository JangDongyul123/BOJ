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
    static String s1;
    static int num, cnt, s1Length;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = "";
        while((line=br.readLine())!=null){
            flag = 0;
            cnt=0;
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(line," ");
            if(!st.hasMoreTokens()){
                break;
            }
            s1 = st.nextToken();
            num = Integer.parseInt(st.nextToken());
            s1Length = s1.length();
            cArr = new char[s1Length];
            visit = new boolean[s1Length];
            sb.append(s1);
            sb.append(" ");
            sb.append(num);
            sb.append(" = ");
            dfsPermutation(0);
            if(cnt<num){
                sb.append("No permutation");
            }
            System.out.println(sb);
        }
    }
    static int flag = 0;
    public static void dfsPermutation(int depth){
        if(flag==1){
            return;
        }
        if(depth == s1Length){
            cnt++;
            if(cnt == num){
                for(int i=0; i<cArr.length; i++){
                    sb.append(cArr[i]);
                    flag=1;
                }
            }
        }
        for(int i=0; i<s1Length; i++){
            if(!visit[i]) {
                cArr[depth] = s1.charAt(i);
                visit[i] = true;
                dfsPermutation(depth + 1);
                cArr[depth]='_';
                visit[i] = false;
            }
        }
    }
}
