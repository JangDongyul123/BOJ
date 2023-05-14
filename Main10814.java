import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main10814 {

    static class Member{
        int age;
        String name;
        int joinDate;

        public Member(int age, String name, int joinDate) {
            this.age = age;
            this.name = name;
            this.joinDate = joinDate;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getJoinDate() {
            return joinDate;
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Member> memberList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            memberList.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(),i));
        }
	/*	memberList.stream()
		.sorted(Comparator.comparing(Member::getAge)
		.thenComparing(Member::getJoinDate))
		.forEach(o->
		{sb.append(o.getAge()+" "+o.getName());
		sb.append('\n');}
		);*/

        //가입일은 역순으로 하고 싶으면
        memberList.stream()
                .sorted(Comparator.comparing(Member::getAge)
                        .thenComparing(Comparator.comparing(Member::getJoinDate).reversed()))
                .forEach(o->{
                    sb.append(o.getAge()+" "+o.getName());
                    sb.append('\n');
                });

        System.out.println(sb);
    }
}
