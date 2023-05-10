import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1456_RE2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        //좌변을 long으로 우변을 Integer.parseInt()로 썼다가 NumberFormatException 생김
        long B = Long.parseLong(st.nextToken());
        long[] arr = new long[(int) Math.sqrt((double) B)+2];

        for(int i=0; i<arr.length; i++){
            arr[i]=i;
        }


        //에라토스테네스의 체
        for(int i=2; i<arr.length; i++){
            if(arr[i]==0) continue;//소수가 아니면 스킵
            for(int j=i+i; j< arr.length; j=j+i){
                arr[j]=0;//소수가 아니면 0 표시
            }
        }

      /*  for(int i=2; i< arr.length; i++){
            if(arr[i]==0) continue;//소수가 아니면 스킵
            for(int j=i+i; j< arr.length; j=j+i){
                arr[j]=0;
            }
        }*/

        int cnt=0;
        //이제 거의 소수 판별
        //일단 소수는 2부터 해당
        for(int i=2; i< arr.length; i++){
            if(arr[i]==0) continue;//소수가 아니면 스킵
            for(long j=arr[i]; (double)j<=(double) B/(double) arr[i]; j=j*arr[i]){
                if((double)j<(double) A/(double) arr[i]) continue;
                cnt++;
            }
        }
        System.out.println(cnt);

    /*    int cnt=0;
        for(int i=2; i< arr.length; i++){
            if(arr[i]==0) continue;
            for(long j=arr[i]; (double)j<=(double) B/(double) arr[i]; j=j*arr[i]){
               *//* if((double)A/(double) (arr[i])<=(double)j){
                    //double과 long을 비교하면 numberformat 에러 생기는 듯
                  cnt++;
                }*//*
                if((double)j<(double) A/(double) arr[i]) continue;
                cnt++;
            }
        }
        System.out.println(cnt);*/
    }
}