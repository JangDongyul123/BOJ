import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3085 {
    static int N;
    static char[][]map;
    static int maxLength;
    static int cnt;

    static void swapAndCheck(){
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                char swap1 = map[y][x];
                if(x+1<N){
                    char swap2 = map[y][x+1];
                    map[y][x] = swap2;
                    map[y][x+1] = swap1;
                    check();
                    map[y][x] = swap1;
                    map[y][x+1] = swap2;
                }
               if(y+1<N){
                   char swap3 = map[y+1][x];
                   map[y][x] = swap3;
                   map[y+1][x] = swap1;
                   check();
                   map[y][x] = swap1;
                   map[y+1][x] = swap3;
               }
            }
        }
    }

    static void check(){
        //가로 검사
        for(int y=0; y<N; y++){
            cnt=1;
            for(int x=0; x+1<N; x++){
                if(map[y][x] == map[y][x+1]){
                    cnt++;
                    if(maxLength<cnt){
                        maxLength = cnt;
                    }
                }else{
                    cnt=1;
                    continue;
                }
            }
        }
        //세로 검사
        for(int x=0; x<N; x++){
            cnt=1;
            for(int y=0; y+1<N; y++){
                if(map[y][x] == map[y+1][x]){
                    cnt++;
                    if(maxLength<cnt){
                        maxLength = cnt;
                    }
                }else{
                    cnt=1;
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        String st;
        for(int y=0; y<N; y++){
            st = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = st.charAt(x);
            }
        }
        swapAndCheck();
        //System.out.println(maxLength);//속도 240
        bw.write(maxLength+"");
        bw.flush();
        bw.close();
    }
}
