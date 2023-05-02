import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt=0;//좋은 수 개수
        for(int goodIndex=0; goodIndex<N; goodIndex++){
            //goodIndex은 좋은 수의 인덱스
            int s1=0;//왼 쪽부터
            int s2=N-1;//오른 쪽부터
            if(s1==goodIndex){
                //겹치는 경우
                //goodIndex = 0 일 떼
                s1++;
            }
            if(s2==goodIndex){
                //겹치는 경우
                //goodIndex =N-1 일 때
                s2--;
            }
            while(s1<s2)//s1과 s2가 겹치는 순간 해당 goodIndex에 대해 모든 경우 다 탐색한 것
            {
                if((arr[s1]+arr[s2])==arr[goodIndex]){
                    cnt++;
                    break;
                }else if((arr[s1]+arr[s2])<arr[goodIndex]){
                    s1++;
                    if(s1==goodIndex){
                        //겹치는 경우
                        //goodIndex = 0 일 떼
                        s1++;
                    }
                }
                else if((arr[s1]+arr[s2])>arr[goodIndex]){
                    s2--;
                    if(s2==goodIndex){
                        //겹치는 경우
                        //goodIndex = 0 일 떼
                        s2--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}