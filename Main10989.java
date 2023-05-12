import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        //우선순위큐 메모리 초과
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        for(int i=0; i<N; i++){
           pq.offer(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll());
            sb.append('\n');
        }
        System.out.println(sb);
        /*//배열 사용
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            sb.append(arr[i]);
            sb.append('\n');
        }
        System.out.println(sb);*/
    }
}
