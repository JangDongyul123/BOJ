import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17928 {

    static class Number{
        int index;
        int value;
        Number(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Stack<Number> stack = new Stack<>();
    
        int [] rgNUMBER = new int[N];
        //오큰수

        rgNUMBER[N-1] = -1;

        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            //새로 들어온 값
            if(stack.isEmpty()){
                stack.push(new Number(i,value));
            }else{
                if(stack.peek().value>=value){
                    stack.push(new Number(i,value));
                }else{
                    while((!stack.isEmpty())&&(stack.peek().value<value)){
                        rgNUMBER[stack.peek().index] = value;
                        stack.pop();
                    }
                    stack.push(new Number(i,value));
                }

            }
        }

        while(!stack.isEmpty()){
            Number number = stack.peek();
            rgNUMBER[stack.peek().index] = -1;
            stack.pop();
        }
        for(int i=0; i<N;i++){
            bw.write(rgNUMBER[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
