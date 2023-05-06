import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1927 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        for(int i=0; i<N; i++){
            int inputNumber = Integer.parseInt(br.readLine());
            if(inputNumber==0){
                //0이면 출력인데
                if(!pq.isEmpty()){
                    sb.append(pq.poll());
                    sb.append('\n');
                }else{
                    sb.append(0);
                    sb.append('\n');
                }
            }else{
                pq.offer(inputNumber);
            }
        }
        System.out.print(sb);
    }
}
