import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4153 {

    static int heru,auset,ausar;

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
          /*  auset = Integer.parseInt(st.nextToken());
            ausar = Integer.parseInt(st.nextToken());
            heru = Integer.parseInt(st.nextToken());*/
            int[] arr = new int[3];
            for(int i=0; i<3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if(arr[0] ==0 && arr[1] ==0 && arr[2]==0){
                break;
            }
            if((arr[2]*arr[2]) == ((arr[1]*arr[1])+(arr[0]*arr[0]))){
                sb.append("right");
                sb.append("\n");
            }else{
                sb.append("wrong");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
