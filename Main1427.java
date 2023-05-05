import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main1427 {
    static String N;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        //OutputStreamWriter os = new OutputStreamWriter(System.out);
        //BufferedWriter bw = new BufferedWriter(os);
        N= br.readLine();
        Integer[] intArr = new Integer[N.length()];
        for(int i=0; i<N.length(); i++){
            intArr[i]=Character.getNumericValue(N.charAt(i));
        }
        Arrays.sort(intArr, Comparator.reverseOrder());

        for(int i:intArr){
            System.out.print(i);
            //bw.write(i+"");
        }
        //bw.flush();
        //bw.close();
    }
}
