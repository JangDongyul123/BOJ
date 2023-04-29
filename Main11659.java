import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
    static int M,N;
    static int[] arr;
    static int[] sum;

    //시간초과에서 속도 단축을 해야하는 문제였다.
    //테스트케이스마다 그때그때 더하는 것이 아니라
    //미리 SUM 배열을 만드는 게 좋다.
    //그러면 처음 한번만 느리지, 테스트케이스가 1000개 있으면
    // i부터 j까지 구간함이 sum[j] - sum[i-1] 로 금방 풀 수 있다.
    //즉 그때 그때 구간함을 구하기 위해 반복문을 사용하면 빅오가 O(N)인데
    //sum 배열을 이용하면 한번 빼면 끝이니까 O(1)이 되는 것이다.

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N];
        sum = new int[N];
        str = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
            if(i==0)
            {
                sum[i] = arr[i];
            }else{
                sum[i] = sum[i-1] +arr[i];
            }
        }

        for(int i=0; i<M; i++){
            str = new StringTokenizer(br.readLine(), " ");
            int n1=Integer.parseInt(str.nextToken());
            int n2=Integer.parseInt(str.nextToken());
            int sum2 = sum[n2-1];
            int sum1=0;
            if(n1==1)
            {
                sum1=0;
            }else{
                sum1=sum[n1-2];
            }
            System.out.println(sum2-sum1);
        }
    }
}
