import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11576 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int sum=0;

        for(int i=m-1; 0<=i; i--){
            int n1 = Integer.parseInt(st.nextToken());
            double n2 = Math.pow(A,i);
            sum+=n1*n2;
        }

        String str = Integer.toString(sum,B);

        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) >='a') {
                sb.append(str.charAt(i)-'a'+10);
                sb.append(" ");
            /*    sb.append((char) str.charAt(i));
                sb.append(" ");
                sb.append((int)str.charAt(i));
                sb.append(" ");*/
            }else {
                sb.append(str.charAt(i)+" ");
            }

        }
        System.out.println(sb);
    }
}
