import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();
        int j=1;
        for(int i=1; i<=n; i++){
                st.push(i);
                sb.append('+');
                sb.append('\n');
                while((!st.isEmpty()) && (st.peek() == arr[j])){
                    st.pop();
                    sb.append('-');
                    sb.append('\n');
                    j++;
                }
        }
        int flag=0;
        while (!st.isEmpty()){
            if(st.peek() != arr[j]){
                flag=1;
            }
            st.pop();
            sb.append('-');
            sb.append('\n');
            j++;
        }
        if(flag==0) {
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}