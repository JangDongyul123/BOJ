import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if("push".equals(command)){
                int pushNumber = Integer.parseInt(st.nextToken());
                stack.push(pushNumber);
            }else if("top".equals(command)){
                if(stack.isEmpty()){
                    sb.append(-1);
                    sb.append('\n');
                }else{
                    sb.append(stack.peek());
                    sb.append('\n');
                }
            }else if("size".equals(command)){
                    sb.append(stack.size());
                    sb.append('\n');

            }else if("pop".equals(command)){
                if(stack.isEmpty()){
                    sb.append(-1);
                    sb.append('\n');
                }else{
                    sb.append(stack.pop());
                    sb.append('\n');
                }
            }else if("empty".equals(command)){
                if(stack.isEmpty()){
                    sb.append(1);
                    sb.append('\n');
                }else{
                    sb.append(0);
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
