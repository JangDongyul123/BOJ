import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931 {

    static int N;
    static Meeting[] meetings;
    static class Meeting{
        int start;
        int end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int getStart(){
            return start;
        }
        public int getEnd(){
            return end;
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings,Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart));
        int end = -1;
        int count = 0;
        for(int i=0; i< meetings.length; i++){
            if(end<= meetings[i].getStart()){
                end = meetings[i].getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}
