import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1541 {

    static List<String> list;

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
    /*    OutputStreamWriter os = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(os);*/

        list = new LinkedList<>();

        while(st.hasMoreTokens()){
            String str = st.nextToken();
            list.add(str);
        }

        for(int i=0; i<list.size(); i++){
            if((i+2)<list.size()){
                if("-".equals(list.get(i))){
                    int index = i;
                    int sum = Integer.parseInt(list.get(index+1));
                    while((index+3)<list.size()){
                        if("+".equals(list.get(index+2))){
                            sum = sum + Integer.parseInt(list.get(index+3));
                            list.remove(index+2);
                            list.remove(index+2);
                        }else if("-".equals(list.get(index+2))){
                            break;
                        }
                        //index+=2;
                    }
                    list.set(i+1, Integer.toString(sum));
                }
            }
        }
        int sum=Integer.parseInt(list.get(0));
        for(int i=1; i<list.size(); i++){
            if("-".equals(list.get(i))){
                sum-=Integer.parseInt(list.get(i+1));
            }else if("+".equals(list.get(i))){
                sum+=Integer.parseInt(list.get(i+1));
            }
        }
        System.out.println(sum);
      /*  bw.write(sum+"");
        bw.flush();
        bw.close();*/
    }
}
