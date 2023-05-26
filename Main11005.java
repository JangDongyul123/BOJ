import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11005 {

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Deque<String> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int d = N/B;
        int p = N%B;
        if(10<=p){
           /* char cp = Character.forDigit(p,B);
            String s = String.valueOf(cp).toUpperCase();*/
            dq.offerFirst(Integer.toString(p,B).toUpperCase());
        }else {
            dq.offerFirst(Integer.toString(p));
        }
        while(d!=0){
            p = d%B;
            if(10<=p){
                dq.offerFirst(Integer.toString(p,B).toUpperCase());
            }else {
                dq.offerFirst(Integer.toString(p));
            }
            d/=B;
        }
       for(String s : dq){
           sb.append(s);
       }
        System.out.println(sb);

    }
}
