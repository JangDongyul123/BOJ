import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1016 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        // 최댓값과 최솟값의 차이만큼 배열 선언하기
        boolean[] Check = new boolean[(int)(max-min+1)];
        // 2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기

       for(long i=2; i*i<=max; i++){
             long pow = i*i;//제곱수
             long start_index = min/pow;//최솟값/제곱수
              if(min%pow!=0){
               start_index++;
              }
              //j가 1이 되면 안된다. 그러면 테스트 케이스 10000000000  1000001000000 을 입력했을 때 min 에서 max를 탐색해야 하는데
             // min을 탐색하기도 전에 시간초과가 생긴다..
             //그래서 시간 초과 방지용으로 start_index가 필요한 것이다.
            for(long j=start_index; (j*pow)<=max; j++){
                long t= j*pow;//제곱수의 배수
                if((min<=t) && (t<=max)){//제곱수의 배수가 min과 max 범위 안이면
                    Check[(int)(t-min)] = true; //제곱수의 배수 표시
                }
            }
        }
       //

        long count = 0;
        for(long i = 0; i<=max-min; i++){
            if(!Check[(int)i]){
                count++;
            }
        }
        System.out.println(count);
    }
}