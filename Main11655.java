import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11655 {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (((str.charAt(i) + 13) <= 'Z') && ((str.charAt(i)) >= 'A')) {
                sb.append((char) (str.charAt(i) + 13));
            } else if (((str.charAt(i)) >= 'A') && ((str.charAt(i) + 13) > 'Z')&&((str.charAt(i)) < 'a')) {
                sb.append((char) ('A' + (str.charAt(i) - 'Z') + 12));
            } else if (((str.charAt(i)) >= 'a') && ((str.charAt(i) + 13) <= 'z')) {
                sb.append((char) (str.charAt(i) + 13));
            } else if (((str.charAt(i)) >= 'a') && ((str.charAt(i) + 13) > 'z')) {
                sb.append((char) ('a' + (str.charAt(i) - 'z') + 12));
            } else{
                sb.append(str.charAt(i));
                continue;
            }
        }
        System.out.println(sb);
    }
}
