import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //문자열 길이가 짧은 순인데, 길이가 같으면 사전순
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.length()==o2.length()){
                for(int i=0; i<o1.length(); i++){
                    if(o1.charAt(i)!=o2.charAt(i)){
                        return o1.charAt(i)-o2.charAt(i);
                    }
                }
            }
            return o1.length()-o2.length();
        });

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(br.readLine());
        }
            while(!pq.isEmpty()){
                String peek = pq.peek();
                sb.append(pq.poll());
                sb.append('\n');
                while(peek.equals(pq.peek())){
                    pq.poll();
                    //똑같은 거 있으면 비운다.
                }
            }
        System.out.println(sb);
    }
}
