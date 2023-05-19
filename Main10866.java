import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main10866 {

    static int N;

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<	N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            if("push_front".equals(str)) {
                dq.offerFirst(Integer.parseInt(st.nextToken()));
            }else if("push_back".equals(str)) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }else if("pop_front".equals(str)) {
                if(dq.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                }else {
                    sb.append(dq.pollFirst());
                    sb.append("\n");
                }
            }else if("pop_back".equals(str)) {
                if(dq.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                }else {
                    sb.append(dq.pollLast());
                    sb.append("\n");
                }
            }else if("size".equals(str)) {
                sb.append(dq.size());
                sb.append("\n");
            }else if("empty".equals(str)) {
                if(dq.isEmpty()) {
                    sb.append(1);
                    sb.append("\n");
                }else {
                    sb.append(0);
                    sb.append("\n");
                }
            }else if("front".equals(str)) {
                if(dq.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                }else {
                    sb.append(dq.peekFirst());
                    sb.append("\n");
                }
            }else if("back".equals(str)) {
                if(dq.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                }else {
                    sb.append(dq.peekLast());
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
