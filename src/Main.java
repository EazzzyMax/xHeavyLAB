import java.util.Random;

public class Main {

//    public static void main(String[] args) {
//
//        double a = 10, b = -17, c = -6, eps = 1e-8;
//        if (Math.abs(a) < eps)
//            if (Math.abs(b) < eps)
//                if (Math.abs(c) < eps)
//                    System.out.println("(+-бесконесноть)");
//                else
//                    System.out.println("решений нет");
//            else System.out.println(-c / b);
//        else {
//            double d = b * b - 4 * a * c;
//            System.out.println(Math.sqrt(d));
//            if (d < 0) System.out.println("корней нет");
//            else if (d == 0) System.out.println(-b/2*a);
//            else System.out.println(((-b-Math.sqrt(d))/(2*a)) +" "+ ((-b+Math.sqrt(d))/(2*a)));
//        }
//
//    }


    public static void main(String[] args) {

        int a = 1;
        int i = 0;
        while (a<32){
            a*=2;
            i++;
        }
        System.out.println(i);


    }


}

