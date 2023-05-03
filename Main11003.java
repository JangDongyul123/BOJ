import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11003 {

    static class Point{
        int index;
        int value;
        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    static int N;
    static int L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

       for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Point> dq = new LinkedList<>();
        for(int i=0; i<N; i++){

            int newNumber=arr[i];
            while((!dq.isEmpty()) && newNumber<=dq.peekLast().value){
                dq.pollLast();
            }
            if((!dq.isEmpty()) && (i-dq.peekFirst().index==L)){
                dq.pollFirst();
            }
            dq.offer(new Point(i,newNumber));
            bw.write(dq.peekFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }
}
