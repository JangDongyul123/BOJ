import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17928_RE {
    static class Number{
        int index;
        int Number;
        Number(int index, int Number){
            this.index = index;
            this.Number = Number;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N+1];
        Stack<Number> stack = new Stack<>();
        for(int i=1; i<=N; i++){
            int newNumber = Integer.parseInt(st.nextToken());
            while((!stack.isEmpty()) && (stack.peek().Number<newNumber)){
                arr[stack.peek().index] = newNumber;
                stack.pop();
            }
            stack.push(new Number(i, newNumber));
        }
        while(!stack.isEmpty()){
            arr[stack.peek().index] = -1;
            stack.pop();
        }
        for(int i=1; i<=N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
