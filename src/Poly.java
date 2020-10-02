import java.util.Arrays;

class Poly { //класс хранящий массивы
    int[] counts; //степени по убыванию
    int[] factor; //множители


    public Poly() { //пустой конструктор
    }

    public Poly(int[] cou, int[] fac) {
        this.counts = cou;
        this.factor = fac;
    }

    public Poly (int [] all) {
        Poly a = transBack(all);
        this.counts = a.counts;
        this.factor = a.factor;
    }


    public static int[] trans(Poly sec) {       //из двух массивов в 1. так легче сделать деление и иногда ввести полином
        int maxs = sec.counts[0];               //максимальная степень
        int[] s = new int[maxs + 1];            //массив хранящий коэфиценты (факторы) всех одночленов в тч нулевых
        int n = 0;                              //для пробегания по двум старым массивам (с остановками)
        for (int i = 0; i <= maxs; i++) {       //i для пробегания нового массива (без остановок)
            if (maxs - i == sec.counts[n]) {    //max-i - степень по ячейке i. maxs 10. i 1. -> вторая ячейка степень 9. vVv
                s[i] = sec.factor[n];           //и если эта степень соответствует степени в оригинале, то записывается значение, иначе 0

                n++;                            //следующая ячейка в старом массиве
            }
            if (n == sec.counts.length) break;
        }
        return s;
    }

    public static Poly transBack(int[] s) {  //обратно из одного массива в 2 (Poly)
        int n = 0;
        for (int i : s)
            if (i != 0)
                n++;


        Poly back = new Poly();
        back.counts = new int[n];
        back.factor = new int[n];

        int st = 0;
        int j = s.length - 1;
        for (int i : s) {
            if (i != 0) {
                back.counts[st] = j;
                back.factor[st] = i;
                st++;
            }
            j--;
        }

        return back;
    }

    public Poly summ(Poly sec) {
        int[] f = trans(this);
        int[] s = trans(sec);
        int d = f.length - s.length;
        if (d >= 0) {
            for (int i = 0; i < s.length; i++) {
                f[d + i] += s[i];
            }
            return transBack(f);
        } else {
            d = -d;
            for (int i = 0; i < f.length; i++) {
                s[d + i] += f[i];
            }
            return transBack(s);
        }

    }

    public Poly res(Poly sec) {
        int[] f = trans(this);
        int[] s = trans(sec);
        int d = f.length - s.length;
        if (d >= 0) {
            for (int i = 0; i < s.length; i++) {
                f[d + i] -= s[i];
            }
            return transBack(f);
        } else {
            d = -d;
            for (int i = 0; i < f.length; i++) {
                s[d + i] -= f[i];
            }
            return transBack(s);
        }

    }

    public Poly mult(Poly sec) {                                                         //умножение vvvvvvvvvvvv
        int[] f = trans(this);
        int[] s = trans(sec);
        int n = f.length + s.length - 1;
        int[] ans = new int[n];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < s.length; j++) {
                ans[i+j] += f[i] * s[j];
            }

        }
        return transBack(ans);
    }                                                                                      //умножение ^^^^^^^^^^^^^^^^^



    public Poly delenie(Poly sec) { //                                        деление VVVVVV
        int[] f = trans(this);      //!!!! f делится на s !!!!
        int[] s = trans(sec);
        int n = f.length - s.length;
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = f[i] / s[0];  //тут записывается результат (a). по нему расчитывается s[] для некст шага
            for (int j = 0; j < s.length; j++) { //вычитаться будет столько раз сколько одночленов в s[]
                //вычитание будет из массива f со смещение на i (по f)
                //i относится только к f
                //j к обоим
                f[i + j] -= s[j] * a[i];
            }
        }

        return transBack(a);
    } //                                                                      деление ^^^^^

    public static void main(String[] args) { //коммент

        Poly first = new Poly();
        first.counts = new int[]{4, 3, 1, 0}; //степени {10%, 6%, 5%, 4%, 3%};
        first.factor = new int[]{3, 5, 2, 4}; //множители

        Poly second = new Poly();
        second.counts = new int[]{2, 1, 0}; //{9%, 7%, 3%, 2, 1, 0};
        second.factor = new int[]{1, 2, 1};

//        System.out.println(Arrays.toString(trans(first.delenie(second))));

        Poly one = transBack(new int[]{5, 4, 3, 3, 0, 0});
        Poly dva = transBack(new int[]{1, 2, 3, 4, 5});
        Poly ans = dva.mult(one);

        System.out.println(Arrays.toString(one.counts));
        System.out.println(Arrays.toString(one.factor));
        System.out.println("");

        System.out.println(Arrays.toString(dva.counts));
        System.out.println(Arrays.toString(dva.factor));
        System.out.println("");

        System.out.println(Arrays.toString(ans.counts));
        System.out.println(Arrays.toString(ans.factor));
        System.out.println("");
        System.out.println(Arrays.toString(trans(ans)));


    }
}