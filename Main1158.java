import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1158 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int s=0;
        LinkedList list =new LinkedList<>();
        for(int i=0; i<N; i++){
            list.add(i+1);
        }
        while (list.size()!=0){
            s+=K-1;
            s%=list.size();
            sb.append(list.get(s));
            list.remove(s);
            if(list.size()==0){
                break;
            }
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
