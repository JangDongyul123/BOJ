import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1747_RE {

    static String N;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int intN = Integer.parseInt(br.readLine());
        N = Integer.toString(intN);
        //숫자를 문자열로 받고
        int start = 0;
        //문자열의 1번째 인덱스 받고
        int end = N.length()-1;
        //마지막 인덱스 받고

        int result = 0;

        int[] arr = new int[1300005];

        for(int i=2; i<arr.length; i++){
            arr[i] = i;
        }

        for(int i=2; i<=10001; i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j<arr.length; j=j+i){
                arr[j] = 0;
            }
        }

        for(int i=intN; i<arr.length; i++){
            if(arr[i]==0) continue;
            N = Integer.toString(i);
            start = 0;
            //문자열의 1번째 인덱스 받고
            end = N.length()-1;
            //마지막 인덱스 받고
            int flag=0;
            while(start<end){
                if(N.charAt(start)!=N.charAt(end)){
                    flag=1;
                    break;
                }
                start++;
                end--;
            }
            if(flag==0){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
