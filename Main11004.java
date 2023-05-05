import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main11004 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        List<Integer> intList = new ArrayList<>();
        for(int i=0; i<N;i++){
            intList.add(Integer.valueOf(st.nextToken()));
        }
        intList.sort(Comparator.naturalOrder());
        System.out.println(intList.get(K-1));
    }
}
