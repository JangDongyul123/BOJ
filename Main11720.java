import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11720 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int sum=0;
        for(int i=0; i<M.length(); i++){
            sum+=Character.getNumericValue(M.charAt(i));
        }
        System.out.println(sum);

    }
}
