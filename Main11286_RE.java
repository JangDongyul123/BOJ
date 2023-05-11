import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main11286_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1,o2)->{
                    int firstAbs = Math.abs(o1);
                    int secondAbs = Math.abs(o2);
                    if(firstAbs==secondAbs){
                        return o1-o2;
                        //절대값이 같으면 가장 작은 수 출력
                    }
                    return firstAbs-secondAbs;
                    //절대값이 작은 수 출력
                }
        );
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            int x=Integer.parseInt(br.readLine());
            if(x!=0){
                pq.offer(x);
            }else{
                if(pq.isEmpty()){
                    sb.append(0);
                    sb.append('\n');
                }else{
                    sb.append(pq.poll());
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
