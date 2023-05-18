//반례 입력
//4
//30
//40
//50
//60
//
//출력
//360

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1715 {

    static int N;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N= Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        long total=0;
        long sum=0;
        for(int i=1; i<=N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        while(pq.size()>1) {
            sum = pq.poll()+pq.poll();
            pq.offer(sum);
            total+=sum;
        }
        System.out.println(total);
    }
}
