public class mmfor {
    public static void main(String[] args) {
        int a = 512*7;
        int n = 1;
        while (a%2==0) {
            a/=2;
            n*=2;
        }
        System.out.println(n);
    }
}
