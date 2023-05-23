import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1931 {
    static int N;

    static class Meeting{
        boolean visit;
        int start;
        int end;
        Meeting(boolean visit, int start, int end){
            this.visit = visit;
            this.start = start;
            this.end = end;
        }

        public int getStart(){
            return start;
        }
        public int getEnd(){
            return end;
        }
        public boolean getVisit(){
            return visit;
        }
    }
    static Meeting[] meetingArray;
    static int[] maxList;


    public static void dfs(int index, Meeting m, int cnt){
        m.visit = true;
        for(int i=index+1; i<meetingArray.length; i++){
            if(meetingArray[i].visit == false){


            }
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        N =Integer.parseInt(br.readLine());
        meetingArray = new Meeting[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            meetingArray[i] = new Meeting(false, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetingArray,Comparator.comparing(Meeting::getStart).thenComparing(Meeting::getEnd));

        for(Meeting m : meetingArray){
            System.out.println(m.getStart()+" "+m.getEnd());
        }
        for(int i=0; i<meetingArray.length; i++){
           dfs(i, meetingArray[i],1);
        }


    }
}
