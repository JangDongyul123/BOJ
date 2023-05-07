import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1456 {

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        //long[] arr = new long[(int)(B+1)];
        //여기서 ArrayIndexOutOfBounds 런타임 예외가 생겼었다.
        //왜냐하면 배열의 크기는 int 범위이므로, long에서 int 범위보다 큰 숫자를 int로 형변환하면 문제가 생기는 듯
       
        long[] arr = new long[10000001];
        //숫자의 제곱근이 소수인 것을 확인하는 문제
        //즉 최대 범위인 10^14 의 제곱근인 10^7 범위 내에서 소수를 확인한다.

        //i가 소수가 아니면 arr[i]는 0 처리
        for(int i=2; i<10000001; i++){
            arr[i] = i;
        }
        //에라토스테네스의 체는 최대 범위의 제곱근까지만 있어도 소수 여부 판별 가능
        for(int i=2; i<Math.sqrt(10000001); i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j<10000001; j=j+i){
                //소수의 배수는 0처리
                arr[j] = 0;
            }
        }
        int cnt=0;
        for(long i=2; i<10000001; i++){
            if(arr[(int)i]==0) continue;//소수가 아니고
            for(long j=arr[(int)i]; j<=(double)B/(double) arr[(int)i]; j=j*arr[(int)i]){ //소수의 제곱이 B 이하고,
                if((double)j<A/(double)arr[(int)i]) continue; //입력값 A보다 커야 하므로
                    cnt++;
            }
        }

        System.out.println(cnt);
        /*for(int i=2; i<=B; i++){
            System.out.print(arr[i]+" ");
        }*/

    }
}
