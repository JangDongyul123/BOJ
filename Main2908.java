import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2908 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String A = st.nextToken();
        String B = st.nextToken();
        char[] AC = new char[A.length()];
        char[] BC = new char[B.length()];
        int j=0;
        for(int i=(A.length()-1); 0<=i; i--){
            AC[j] = A.charAt(i);
            j++;
        }
        j=0;
        for(int i=(B.length()-1); 0<=i; i--){
            BC[j] = B.charAt(i);
            j++;
        }
        A= new String(AC);
        B= new String(BC);
        int Ai = Integer.parseInt(A);
        int Bi = Integer.parseInt(B);
        if(Ai>Bi){
            System.out.println(Ai);
        }else{
            System.out.println(Bi);
        }
    }
}