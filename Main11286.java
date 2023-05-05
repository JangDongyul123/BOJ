//1. 속도 360
//        bw.write(sb+"");
//        bw.flush();
//        bw.close();
//2. 속도 328
//        System.out.print(sb);

import java.io.*;
import java.util.PriorityQueue;

public class Main11286 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs==secondAbs){
                //절대값이 같으면 음수 우선(o1-o2)가 오름차순
                return o1-o2;
            }
            return firstAbs-secondAbs;
            //철대값이 다르면 절대값이 작은 게 우선(오름차순)
        });

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll());
                    sb.append('\n');
                }else{
                    sb.append(0);
                    sb.append('\n');
                }
            }else{
                pq.offer(number);
            }

        }
   /*     bw.write(sb+"");
        bw.flush();
        bw.close();*/
        System.out.print(sb);
    }
}
