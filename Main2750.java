//Arrays.sort() 사용하면 되지만 버블정렬로 풀어봄

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2750 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        N = Integer.parseInt(br.readLine());
        arr=new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int y=(N-1); 0<y; y--){
            for(int x=0; x<y; x++){

                if(arr[x]>arr[x+1]){
                    int swap = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = swap;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
