import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891 {

    static int S,P;
    static char[] arr;
    static int minA,minC,minG,minT;

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S= Integer.parseInt(st.nextToken());
        P= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        arr = new char[S];
        String str = st.nextToken();
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }
        st = new StringTokenizer(br.readLine(), " ");
        minA = Integer.parseInt(st.nextToken());
        minC = Integer.parseInt(st.nextToken());
        minG = Integer.parseInt(st.nextToken());
        minT = Integer.parseInt(st.nextToken());

        int count=0;
        //int index1 = 0;
        //int index2 = P;
        int[] DNACount = new int[4];
        //0번째는 A개수, 1번째는 C개수, 2번째는 G개수, 3번째는 T개수
        for(int i=0; i<P; i++){
            if(arr[i]=='A'){
                DNACount[0]++;
            }else if(arr[i]=='C'){
                DNACount[1]++;
            }else if(arr[i]=='G'){
                DNACount[2]++;
            }else if(arr[i]=='T'){
                DNACount[3]++;
            }
        }
        if((minA<=DNACount[0])&&(minC<=DNACount[1])&&(minG<=DNACount[2])&&(minT<=DNACount[3])){
            count++;
        }

        for(int index1=1; index1 <= (S-P); index1++){
            int index2 = index1+(P-1);
            if(arr[index1-1]=='A'){
                DNACount[0]--;
            }else if(arr[index1-1]=='C'){
                DNACount[1]--;
            }else if(arr[index1-1]=='G'){
                DNACount[2]--;
            }else if(arr[index1-1]=='T'){
                DNACount[3]--;
            }
            if(arr[index2]=='A'){
                DNACount[0]++;
            }else if(arr[index2]=='C'){
                DNACount[1]++;
            }else if(arr[index2]=='G'){
                DNACount[2]++;
            }else if(arr[index2]=='T'){
                DNACount[3]++;
            }
            if((minA<=DNACount[0])&&(minC<=DNACount[1])&&(minG<=DNACount[2])&&(minT<=DNACount[3])){
                count++;
            }
        }

        System.out.println(count);

    }
}
