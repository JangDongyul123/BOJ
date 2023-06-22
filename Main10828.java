import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {

    static int N;

    public static void main(String[] args) throws Exception {

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine()," ");
            String s1 = st.nextToken();
            if(s1.equals("push")){
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            }else if(s1.equals("pop")){
                if(!stack.isEmpty()){
                    sb.append(stack.pop());
                    sb.append("\n");
                }else{
                    sb.append(-1);
                    sb.append("\n");
                }
            }else if(s1.equals("size")){
                sb.append(stack.size());
                sb.append("\n");
            }else if(s1.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1);
                    sb.append("\n");
                }else{
                    sb.append(0);
                    sb.append("\n");
                }
            }else if(s1.equals("top")){
                if(stack.isEmpty()){
                    sb.append(-1);
                    sb.append("\n");
                }else{
                    sb.append(stack.peek());
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}