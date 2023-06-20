import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3449 {

    static int T;

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String s1 = br.readLine();
            String s2 = br.readLine();
            int count=0;
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    count++;
                }
            }
            sb.append("Hamming distance is ");
            sb.append(count);
            sb.append(".");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
