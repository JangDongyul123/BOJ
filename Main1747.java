import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1747 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        String strN = br.readLine();
        int N = Integer.parseInt(strN);
        int[] decimal = new int[1300000];
        for(int i=2; i<decimal.length; i++){
            decimal[i]=i;
        }
        for(int i=2; i<decimal.length; i++){
            if(decimal[i]==0) continue;
            for(int j=i+i; j< decimal.length; j=j+i){
                decimal[j] = 0;
            }
        }
        int result=0;
        for(int i = N ; i< decimal.length; i++){
            if(decimal[i]==0) continue;
            String newDecimal = Integer.toString(decimal[i]);
            char[] cString = new char[newDecimal.length()];
            for(int j=0; j<newDecimal.length(); j++){
                cString[j] = newDecimal.charAt(j);
            }
            int flag=0;
            //펠린드롬이면 그대로 0, 아니면 1
            int p1 =0;
            int p2 =(newDecimal.length()-1);
            while(p1<p2){
                if(cString[p1] != cString[p2]){
                    flag=1;
                }
                p1++;p2--;
            }
            if(flag==0){
                result=decimal[i];
                break;
            }
        }
        System.out.println(result);
    }
}
