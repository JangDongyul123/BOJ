import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1707 {
    static int K;
    static List<List<Integer>> nodeList;
    static boolean[] visit;
    static char[] colorList;
    static StringBuilder sb;
    static int flag = 0;

    public static void dfs(int node, char color){
        if(flag==1){
            //이분그래프가 아닌 것으로 판명되었으니 더이상 탐색 하지 말라는 뜻
            return;
        }
        char color2;
        //맞물린 노드가 다른 색이어야 한다.
        if(color == 'R'){
           color2 = 'B';
        }else{
            color2 = 'R';
        }
        visit[node] = true;
        colorList[node] = color;
        for(int i=0; i<nodeList.get(node).size(); i++){
            //인접 노드 탐색
            int node2 = nodeList.get(node).get(i);
            //인접노드 발견
            if(!visit[node2]){
                //아직 방문하지 않은 노드면
                visit[node2] = true;
                //방문 표시 및 색칠
                if(color == 'R'){
                    colorList[node2] = color2;
                }else{
                    colorList[node2] = color2;
                }

            for(int j=0; j<nodeList.get(node2).size(); j++){
                //해당 인접노드인 node2와 인접한 노드들의 색깔 검사
                //맞물린 노드끼리 같은 색이면 이분 그래프가 아니다.
                if(visit[nodeList.get(node2).get(j)]){
                    //방문했던 노드들이 색깔이 있으므로
                    //그리고 방문하지 않은 노드들은 색깔도 없어서 탐색이 필요 없을 뿐더러 불필요한 탐색으로 시간도 오래 걸림
                    if(colorList[node2] == colorList[nodeList.get(node2).get(j)]){
                        flag=1;//이분 그래프가 아니면 flag=1 표시
                        //나중에 YES 출력할 거다.
                        return;
                    }
                }
            }
            dfs(node2,color2);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        K = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        for(int k=0; k<K; k++){
            flag = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            nodeList = new ArrayList<>();
            visit = new boolean[V+1];
            colorList = new char[V+1];
            for(int V1=0; V1<=V; V1++){
                nodeList.add(new ArrayList<>());
            }
            for(int e=0; e<E; e++){
                st = new StringTokenizer(br.readLine()," ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                nodeList.get(u).add(v);
                nodeList.get(v).add(u);
            }
            for(int i=1; i<=V; i++){
                if(!visit[i]){
                    dfs(i, 'B');
                }
            }
            if(flag==1){
                //아까 dfs()함수에서 이분 그래프가 아니면 flag=1 표시를 했었음
                sb.append("NO");//이분그래프가 아니라는 뜻
                sb.append("\n");
            }else {
                sb.append("YES");//flag=1이 아니면 이분그래프이므로 YES 문자열을 sb에 append(더한다.)
                sb.append("\n");
            }
        }
        System.out.println(sb);//문자열 출력
    }
}
