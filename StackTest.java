import java.util.Stack;

public class StackTest {
    static class Point{
        int index;
        int value;
        Point(int index, int value){
            this.index=index;
            this.value=value;
        }
    }
    public static void main(String[] args) {
        Stack<Point> st = new Stack<>();
        st.push(new Point(1,1));
        st.push(new Point(2,2));
        st.push(new Point(3,3));
        while (!st.isEmpty()){
            System.out.println(st.peek().index);
            st.pop();
        }
    }
}
