import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is =new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long[]arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if(N<=2){
            System.out.println(0);
        }else{
            int cnt=0;
            int target=0;
            int p1=0;
            int p2=arr.length-1;
            while(target<arr.length && p1<arr.length && 0<=p2){
                //포인터들이 배열의 범위를 넘어가면 안된다.
                if(target!=p1 && target!=p2 && p1!=p2) {
                    //셋 다 다른 수여야만 한다.
                    if ((arr[p1] + arr[p2]) < arr[target]) {
                        p1++;
                    } else if ((arr[p1] + arr[p2]) == arr[target]) {
                        cnt++;
                        p1 = 0;
                        p2 = arr.length - 1;
                        target++;
                    } else if ((arr[p1] + arr[p2]) > arr[target]) {
                        p2--;
                    }
                }
                else if(target==p1){
                    p1++;
                }
                else if(target==p2){
                    p2--;
                }
                else if(p1==p2){
                    target++;
                    p1=0;
                    p2=arr.length-1;
                }
            }
            System.out.println(cnt);
        }
    }
}
