import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main18406 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String N = br.readLine();
        int sum1=0;
        int sum2=0;

        for(int i=0; i<N.length()/2; i++){
            sum1+= N.charAt(i);
        }
        for(int i=N.length()/2; i<N.length(); i++){
            sum2+= N.charAt(i);
        }
        if(sum1==sum2){
            System.out.println("LUCKY");
        }else {
            System.out.println("READY");
        }
    }
}
