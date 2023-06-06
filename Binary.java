public class Binary {
    public static void main(String[] args) throws Exception {

        System.out.println(Integer.parseInt("100",7));
        //7진수로 100을 10진수로 만든다.
        System.out.println(Integer.toString(100,2));
        //10진수로 100을 2진수로 만든다.

        System.out.println(Long.parseLong("100", 8));
        //8진수로 100인 수를 10진수로 만든다.
        System.out.println(Long.toString(100,2));
        //10진수 100을 2진수로 만든다.

    }
}
