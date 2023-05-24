import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;

public class Main1744 {

    static int N;
    static PriorityQueue<Integer> plusMaxPQ;
    static PriorityQueue<Integer> minusMinPQ;
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        plusMaxPQ = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        minusMinPQ = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        for(int i=0; i<N; i++){
            Integer number = Integer.parseInt(br.readLine());
            if(0<number){
                plusMaxPQ.offer(number);
            }else if(number<=0){
                minusMinPQ.offer(number);
            }
        }
        int sum=0;

        while(1<plusMaxPQ.size()){
            int n1 = plusMaxPQ.poll();
            int n2 = plusMaxPQ.poll();
            if((n1+n2)<(n1*n2)){
                sum+=(n1*n2);
            }else{
                sum+=(n1+n2);
            }

         /*   if(0==plusMaxPQ.size()){
                break;
            }
            if(1==plusMaxPQ.size()){
                sum+=plusMaxPQ.poll();
                break;
            }*/
        }
        while(1<minusMinPQ.size()){
            int n1 = minusMinPQ.poll();
            int n2 = minusMinPQ.poll();
            if((n1+n2)<(n1*n2)){
                sum+=(n1*n2);
            }else{
                sum+=(n1+n2);
            }

          /*  if(0==minusMinPQ.size()){
                break;
            }
            if(1==minusMinPQ.size()){
                sum+=minusMinPQ.poll();
                break;
            }*/
        }
        if(1==plusMaxPQ.size()){
            sum+=plusMaxPQ.poll();
        }
        if(1==minusMinPQ.size()){
            sum+=minusMinPQ.poll();
        }
        System.out.println(sum);

    }
}
