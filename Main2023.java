import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2023 {
    static int N;
    static StringBuilder sb;
    public static boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int number, int jarisu) {
        if(jarisu == N) {
            if(isPrime(number)) {
                sb.append(number+"\n");
            }
        }
        for(int i=0; i<10; i++) {
            if(i%2==0) continue; //짝수는 안된다.
            int k = number*10 +i;
            if(isPrime(k)) {
                dfs(k,jarisu+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        sb= new StringBuilder();
        N= Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
        System.out.println(sb);
    }
}