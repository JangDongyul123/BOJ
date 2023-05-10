import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11003_RE {

    static class Number{
        int index;
        int number;
        Number(int index, int number){
            this.index=index;
            this.number=number;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Number> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int newNumber = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty()&&(dq.peekLast().number>=newNumber)){
                   dq.pollLast();
            }
            if(!dq.isEmpty()&&(i-dq.peekFirst().index==L)){
                    dq.pollFirst();
            }
            dq.offer(new Number(i,newNumber));
            sb.append(dq.peekFirst().number+" ");
        }
        System.out.println(sb);
    }
}
