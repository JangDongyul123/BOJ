import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2740 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] A,B;

        st = new StringTokenizer(br.readLine()," ");
        int N1 =Integer.parseInt(st.nextToken());
        int M1 =Integer.parseInt(st.nextToken());
        A =new int[N1][M1];
        for(int n=0; n<N1; n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0; m<M1; m++){
                A[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int N2 =Integer.parseInt(st.nextToken());
        int M2 =Integer.parseInt(st.nextToken());
        B =new int[N2][M2];
        for(int n=0; n<N2; n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0; m<M2; m++){
                B[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] C = new int[N1][M2];
        for(int y=0; y<N1; y++){
            for(int x=0; x<M2; x++){
                C[y][x] = 0;
                for(int i=0; i<N2; i++){
                    C[y][x]+= A[y][i]*B[i][x];
                }
            }
        }
        for(int y=0; y<N1; y++){
            for(int x=0; x<M2; x++){
                sb.append(C[y][x]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
