import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2750_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N= Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<N-i; j++){
                int tmp = arr[j+1];
                if(arr[j]>arr[j+1]){
                    arr[j+1] = arr[j];
                    arr[j]=tmp;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}
