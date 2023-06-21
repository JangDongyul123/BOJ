//이 문제 중요하니 복습해라

import java.io.*;

public class Main10974 {
    public static int N;
    public static int arr[];
    public static boolean visited[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];

        dfsPermutation(1);
        System.out.println(sb.toString());
    }

    public static void dfsPermutation(int depth) {
        if(depth == N+1) {
            for(int i=1; i<=N; i++)
                sb.append(arr[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(visited[i])//방문했으면 컨티뉴
                continue;
            //방문 안했으면
            arr[depth] = i;
            visited[i] = true;
            dfsPermutation(depth + 1);
            visited[i] = false;
        }
    }
}