//이 문제 중요하니 복습해라

import java.io.*;

public class Main10974 {
    static int N;
    static int arr[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visit = new boolean[N+1];
        dfsPermutation(1);
        System.out.println(sb);
    }
    public static void dfsPermutation(int depth){
        if(depth == N+1){
            for(int i=1; i<=N; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                arr[depth] = i;
                //depth자리에 i숫자
                visit[i] = true;
                //i숫자 사용 완료
                dfsPermutation(depth+1);
                //arr[depth] = 0;
                //depth 자리 다시 비게 세팅
                visit[i] = false;
                //i숫자 다시 반납 완료
            }
        }
    }
}