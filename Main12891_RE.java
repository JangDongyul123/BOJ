import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891_RE {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] cArr = new char[S];
        String str = br.readLine();
        for(int i=0; i<S; i++){
            cArr[i] = str.charAt(i);
        }
        st = new StringTokenizer(br.readLine()," ");
        int minA = Integer.parseInt(st.nextToken());
        int minC = Integer.parseInt(st.nextToken());
        int minG = Integer.parseInt(st.nextToken());
        int minT = Integer.parseInt(st.nextToken());
        int Acnt=0;
        int Ccnt=0;
        int Gcnt=0;
        int Tcnt=0;
        int p1=0;
        int p2=P-1;
        int cnt=0;
        for(int i=p1; i<=p2; i++){
            if(cArr[i]=='A'){
                Acnt++;
            }else if(cArr[i]=='C'){
                Ccnt++;
            }else if(cArr[i]=='G'){
                Gcnt++;
            }else if(cArr[i]=='T'){
                Tcnt++;
            }
        }
        if(minA<=Acnt && minC<=Ccnt && minG<=Gcnt && minT<=Tcnt){
            cnt++;
        }
        p1++;
        p2++;
        while(p2<S){
            if(cArr[p1-1]=='A'){
                Acnt--;
            }else if(cArr[p1-1]=='C'){
                Ccnt--;
            }else if(cArr[p1-1]=='G'){
                Gcnt--;
            }else if(cArr[p1-1]=='T'){
                Tcnt--;
            }
            if(cArr[p2]=='A'){
                Acnt++;
            }else if(cArr[p2]=='C'){
                Ccnt++;
            }else if(cArr[p2]=='G'){
                Gcnt++;
            }else if(cArr[p2]=='T'){
                Tcnt++;
            }
            if(minA<=Acnt && minC<=Ccnt && minG<=Gcnt && minT<=Tcnt){
                cnt++;
            }
            p1++;
            p2++;
        }
        System.out.println(cnt);
    }
}
