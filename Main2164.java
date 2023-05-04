import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {
    static int N;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);

        N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            q.poll();
            if(!q.isEmpty()){
                int n = q.peek();
                q.poll();
                q.offer(n);
            }

            if(q.size()==1){
                bw.write(q.peek()+"");
                bw.flush();
                bw.close();
                return;
            }
        }
        bw.write(1+"");
        bw.flush();
        bw.close();
    }
}
