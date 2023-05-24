import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929_RE {

    static int s;
    static int e;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        s=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        arr= new int[e+1];
        for(int i=2; i<=e; i++){
            arr[i]=i;
        }
        for(int i=2; i<=Math.sqrt(e); i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j<=e; j+=i){
                arr[j]=0;
            }
        }
        for(int i=s; i<=e; i++){
            if(arr[i]!=0){
                sb.append(arr[i]);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
