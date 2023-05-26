import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2745 {
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int sum=0;
        int j=0;
        for(int i=N.length()-1; 0<=i; i--){
            char cn = N.charAt(i);
            if('0'<=cn && cn<='9'){
                sum+=Character.getNumericValue(cn)*Math.pow(B, j);
            }else if('A'<=cn && cn<='Z'){
                sum+=Character.getNumericValue(cn)*Math.pow(B, j);
            }
            j++;
        }
        System.out.println(sum);
    }
}
