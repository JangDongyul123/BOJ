import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws IOException {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int y1=0; y1<N ;y1++){
            int rank=1;
            for(int y2=0; y2<N; y2++){
                if(y1==y2){
                    continue;
                }
                if((arr[y2][0]>arr[y1][0]) && (arr[y2][1]>arr[y1][1])){
                    rank++;
                }
            }
            sb.append(rank);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}