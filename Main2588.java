import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2588 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N1 = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[] arr = new int[str.length()];
        for(int i=(arr.length-1); 0<=i; i--){
            arr[i] = Character.getNumericValue(str.charAt(i));
            //Character.getNumericValue() 가 없으면 아스키코드로 받아서, char 형 숫자를 int 형 숫자로 형변환
            System.out.println(N1*arr[i]);
        }
        System.out.println(N1*n);

    }
}
