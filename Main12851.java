import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main12851 {
    static int N,K;
    static int []dx = {1,-1};
    static int []map; //맵
    static int []seconds; //걸린 시간
    static boolean []visit; //방문 여부
    static List<Integer> answerList;
    static int cnt=0;
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visit[N] = true;
        q.offer(N);
        while (!q.isEmpty()){
            int peekX= q.peek();
            q.poll();
            //visit[peekX] = true;
            for(int i=0; i<3; i++) {
                int nx;
                if((0<=i) && (i<2)){
                    nx = peekX+dx[i];
                }else{
                    nx = peekX*2;
                }
                if((0<=nx) &&(nx<=100000)){
                    if(!visit[nx]){
                        visit[nx] = true;
                        //방문표시
                        seconds[nx] = 1+seconds[peekX];
                        //최단 시간 갱신
                        if(nx==K){
                            cnt++;
                            //최단 경로 개수 증가
                        }
                        q.offer(nx);
                    }
                    else if(visit[nx]){
                        //이미 최단 시간이 저장된 상태
                        if((seconds[nx] >= (1+seconds[peekX]))){
                            //이미 기존의 최단 시간과 현재 도착한 시간이 같으면
                                if(nx==K){
                                    cnt++;
                                    //최단 경로 개수 증가
                                }
                                q.offer(nx);
                        }
                    }
                }
            }
        }
    };

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        map= new int[100001];
        seconds= new int[100001];
        visit= new boolean[100001];
        answerList = new ArrayList<>();

        bfs();
        if(N==K){
            //여기 반례에서 막혔음
            //입력값 0 0 이면
            //출력값 0
            //      1
            //이어야 하는데 맨 마지막에 0이 나왔다.
            cnt++;
        }
        System.out.println(seconds[K]);
        System.out.println(cnt);

     /*   for(int i =0; i< 30; i++ ){
            System.out.print(seconds[i]+" ");
        }*/
       /* System.out.println();
        for(int i=0; i<answerList.size(); i++){
            System.out.println(answerList.get(i));
        }*/
    }
}
