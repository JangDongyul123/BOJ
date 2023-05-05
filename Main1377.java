import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main1377 {

    static class Number implements Comparable<Number> {
        int index;
        int value;
        Number(int index, int value){
            this.index=index;
            this.value=value;
        }
        int getIndex(){
            return index;
        }
        int getValue(){
            return value;
        }

        @Override
        public int compareTo(Number o) {
            return this.value-o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        int N;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);

        N = Integer.parseInt(br.readLine());
        Number[] numberArray1 = new Number[N];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            numberArray1[i]=new Number(i,arr[i]);
        }
        Arrays.sort(numberArray1,Comparator.comparing(Number::getValue));
        //Arrays.sort(numberArray1,Comparator.comparing((Number number) -> number.getValue()).thenComparing(Comparator.comparing(Number::getIndex).reversed()));
        //Arrays.sort(numberArray1);
        int max=0;
        for(int i=0; i<N;i++){
            int count=numberArray1[i].getIndex()-i;
            if(max<count){
                max=count;
            }
        }
        System.out.println(max+1);
    }
}