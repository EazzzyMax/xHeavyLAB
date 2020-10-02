import java.util.Arrays;

class Polynomial { //класс хранящий массивы
    int[] counts; //степени по убыванию
    double[] factor; //множители


    public Polynomial() { //пустой конструктор
    }

    public Polynomial(int[] cou, double[] fac) { //конструктор через два массива
        this.counts = cou;
        this.factor = fac;
    }

    public Polynomial(double[] all) {   //конструктор через 1 массив
        Polynomial a = transBack(all);
        this.counts = a.counts;
        this.factor = a.factor;
    }

    public boolean isEqual(Polynomial sec) {
        return (this.toString().equals(sec.toString()));
    }

    public String toString() {
        return Arrays.toString(trans(this));
    }

    public static double[] trans(Polynomial sec) {    //из двух массивов в 1. так легче сделать деление и иногда ввести полином
        int maxs = sec.counts[0];               //максимальная степень
        double[] s = new double[maxs + 1];      //массив хранящий коэфиценты (факторы) всех одночленов в тч нулевых
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

    public static Polynomial transBack(double[] s) {  //обратно из одного массива в 2 (Poly)
        int n = 0;
        for (double i : s)
            if (i != 0)
                n++;


        Polynomial back = new Polynomial();
        back.counts = new int[n];
        back.factor = new double[n];

        int st = 0;
        int j = s.length - 1;
        for (double i : s) {
            if (i != 0) {
                back.counts[st] = j;
                back.factor[st] = i;
                st++;
            }
            j--;
        }

        return back;
    }

    public Polynomial addition(Polynomial sec) {
        double[] f = trans(this);
        double[] s = trans(sec);
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

    public Polynomial subtraction(Polynomial sec) {

        double[] f = trans(this);
        double[] s = trans(sec);


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
            for (int i = 0; i < s.length; i++) {
                s[i] *= -1;
            }
            return transBack(s);
        }

    }

    public Polynomial multiplication(Polynomial sec) {
        double[] f = trans(this);
        double[] s = trans(sec);
        if (f.length == 1 && f[0] == 0 || s.length == 1 && s[0] == 0) { //умножение на 0
            return new Polynomial();
        }
        int n = f.length + s.length - 1;
        double[] ans = new double[n];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < s.length; j++) {
                ans[i + j] += f[i] * s[j];
            }

        }
        return transBack(ans);
    }


    public Polynomial divide(Polynomial sec) {
        double[] f = trans(this);      //!!!! f делится на s !!!!
        double[] s = trans(sec);
        if (f.length < s.length) //деление меньшего на большее
            return new Polynomial();
        int n = f.length - s.length;
        double[] a = new double[n + 1];
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
    }

}