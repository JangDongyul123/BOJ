import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1377_RE {
    static class Number{
        int index;
        int number;
        Number(int index, int number){
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int N = Integer.parseInt(br.readLine());
        Number[] arr = new Number[N];
        for(int i=0; i< N; i++){
            arr[i] = new Number(i,Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr, Comparator.comparing(Number::getNumber));
        int max=0;
        for(int i=0; i< N; i++){
            if(max<(arr[i].getIndex()-i)){
                max = arr[i].getIndex()-i;
            }
        }
        System.out.println(max+1);
    }
}
