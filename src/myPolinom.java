import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


class MyP { //класс хранящий массивы
    int[] counts; //степени по убыванию
    int[] factor; //множители


    public MyP() {
    }

    public MyP Summ(MyP second) {
        MyP q = this;
        for (int i = 0; i<this.counts.length; i++) {
            for (int j = 0; j<second.counts.length; i++) {
                if
            }
        }


        return q;
    }


    public static void main(String[] args) { //коммент

        MyP first = new MyP();
        first.counts = new int[]{10, 6, 5, 4, 3}; //степени
        first.factor = new int[]{5, 4, 2, 3, 6}; //множители

        MyP second = new MyP();
        second.counts = new int[]{9, 7, 3, 2, 1, 0};
        second.factor = new int[]{1, 2, 5, 1, 3, 5};

        MyP third = first.Summ(second);





        System.out.println(Arrays.toString(third.counts));


//        Scanner num = new Scanner(System.in);
//        int one, two, result;
//        one = num.nextInt();
//        two = num.nextInt();
//        System.out.println(one+two);


    }
}