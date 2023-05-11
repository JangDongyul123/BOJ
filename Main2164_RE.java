import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        if(q.size()==1){
            System.out.println(q.peek());
        }
    }
}
