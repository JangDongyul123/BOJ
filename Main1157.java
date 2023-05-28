import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1157 {
    public static void main(String[] args) throws Exception {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        s=s.toUpperCase();
        Integer [] visit = new Integer[27];
        for(int i=0; i<visit.length; i++){
           visit[i] = 0;
        }
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'A';
            int q = visit[index].intValue();
            q++;
            visit[index] = q;
        }
        int max=0;
        int flag=0;
        int maxIndex=0;
        for(int i=0; i<visit.length; i++){
            if(max<visit[i].intValue()){
                max = visit[i].intValue();
                maxIndex = i;
            }
        }
        for(int i=0; i<visit.length; i++){
            if(max==visit[i].intValue()){
               flag++;
            }
        }
        if(flag>1){
            System.out.println("?");
        }else{
            System.out.println((char)(maxIndex+'A'));
        }

    }
}
