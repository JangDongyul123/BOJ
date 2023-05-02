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
        for (int i=0; i<arr.length; i++){
            arr[i]= Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);

        int cnt=0;
        if(N<3){
            cnt=0;
        }else{
            int s1= 0; //좋은 수를 만들 숫자1 인덱스
            int s2= 1; //좋은 수를 만들 숫자2 인덱스
            for(int goodIndex= 0; goodIndex<N; goodIndex++){
                //goodIndex 좋은 수의 인덱스
                if(goodIndex==0){
                    s1=1; s2=N-1;
                    while (true) {
                        if((arr[s1]+arr[s2])<arr[goodIndex]){
                            s1++;
                            if(s1==goodIndex){
                                s1++;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                        else if((arr[s1]+arr[s2])==arr[goodIndex]){
                            cnt++;
                            break;
                        }
                        else if((arr[s1]+arr[s2])>arr[goodIndex]){
                            s2--;
                            if(s2==goodIndex){
                                s2--;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                    }
                }else if(goodIndex==1){
                    s1=0;  s2=N-1;
                    while (true) {
                        if((arr[s1]+arr[s2])<arr[goodIndex]){
                            s1++;
                            if(s1==goodIndex){
                                s1++;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                        else if((arr[s1]+arr[s2])==arr[goodIndex]){
                            cnt++;
                            break;
                        }
                        else if((arr[s1]+arr[s2])>arr[goodIndex]){
                            s2--;
                            if(s2==goodIndex){
                                s2--;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                    }
                }else if(1<goodIndex){
                    s1=0; s2=N-1;
                    if(goodIndex == (N-1)){
                        //반례
                        //입력 4
                        //    0 -5 -5 -5
                        s2--;
                    }
                    while (true) {
                        if((arr[s1]+arr[s2])<arr[goodIndex]){
                            s1++;
                            if(s1==goodIndex){
                                s1++;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                        else if((arr[s1]+arr[s2])==arr[goodIndex]){
                            cnt++;
                            break;
                        }
                        else if((arr[s1]+arr[s2])>arr[goodIndex]){
                            s2--;
                            if(s2==goodIndex){
                                s2--;
                            }
                            if(s1==s2){//없는 것
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}