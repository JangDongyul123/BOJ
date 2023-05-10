import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1546 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Double[] arr = new Double[N];
        double sum=0;
        double avg=0;
        for(int i=0; i< arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        for(int i=0; i< arr.length; i++){
            sum+=((double)arr[i]/(double) arr[0]);
        }
        avg=sum/N;
        System.out.println(avg*100);
    }
}
