import java.io.*;
import java.util.Stack;

public class Main1874 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        OutputStreamWriter os = new OutputStreamWriter(System.out);
        //BufferedWriter bw = new BufferedWriter(os);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        n=Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int index=1;
        for(int i=1; i<=n; i++){
            stack.push(i);
            sb.append("+");
            sb.append("\n");
            //bw.write("+");
            //bw.newLine();
            while((!stack.isEmpty())&&(stack.peek() == arr[index])){
                stack.pop();
                sb.append("-");
                //bw.write("-");
                if(index!=n){
                    sb.append("\n");
                    //bw.newLine();
                }
                index++;
            }
        }
        while(!stack.isEmpty()){
            if((stack.peek() == arr[index])){
                stack.pop();
                sb.append("-");
                sb.append("\n");
                //bw.write("-");
                //bw.newLine();
                index++;
            }else{
                break;
            }
        }
        if(index<n){
            BufferedWriter bw2 = new BufferedWriter(os);
            bw2.write("NO");
            bw2.flush();
            bw2.close();
        }else{
            System.out.print(sb);
        }
    }
}
