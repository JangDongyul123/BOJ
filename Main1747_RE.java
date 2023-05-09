import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1747_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[1200001];
        for(int i=2; i<arr.length; i++){
            arr[i]=i;
        }
        for(int i=2; i< arr.length; i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j< arr.length; j=i+j){
                arr[j]=0;
            }
        }
        int result = 0;
        for(int i=N; i< arr.length; i++){
            //i=N+1 로 잡으면 71퍼에서 틀린다. 크거나 같은 건데, 큰 걸로 범위를 잡아서 틀린 것
            if(arr[i]!=0){
               String str = Integer.toString(arr[i]);
               int p1=0;
               int p2=str.length()-1;
               int flag=0;
                   while(p1<p2)
                   {
                       if(str.charAt(p1)!=str.charAt(p2)){
                           flag=1;
                           break;
                       }
                       p1++;
                       p2--;
                   }
                   if(flag==0){
                       result =arr[i];
                       break;
                   }
            }
        }
        System.out.println(result);
    }
}
