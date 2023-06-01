public class StringBuildet_Equals {
    public static void main(String args[]) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");

        System.out.println("sb1: " + sb1);
        System.out.println("sb2: " + sb2);
        System.out.println("sb1 == sb2: " + (sb1 == sb2));
    }
}
