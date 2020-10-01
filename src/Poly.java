import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Poly { //класс хранящий массивы
    int[] counts; //степени по убыванию
    int[] factor; //множители


    public Poly() { //пустой конструктор
    }

    public Poly(int[] cou, int[] fac) {

    }


    public Integer NewN(Poly s) { //размер нового полинома. f - first, s - second (полиномы)
        Poly f = this;
        int n = 0;
        int flast = f.counts.length - 1;
        int slast = s.counts.length - 1;
        int fu = 0;
        int su = 0;
        while (fu <= flast || su <= slast) {
            if (fu <= flast) {
                if (su > slast || f.counts[fu] > s.counts[su]) {
                    n++;
                    fu++;
                    continue;
                }
            }
            if (su <= slast) {
                if (fu > flast || f.counts[fu] < s.counts[su]) {
                    n++;
                    su++;
                    continue;
                }
            }
            if (fu <= flast && su <= slast) {
                if (f.counts[fu] == s.counts[su]) {
                    n++;
                    fu++;
                    su++;
                }
            }
        }
        return n;
    }

    public Poly Summ(Poly s) {
        Poly f = this;
        int n = f.NewN(s);

        Poly t = new Poly();//third
        t.counts = new int[n];
        t.factor = new int[n];

        int flast = f.counts.length - 1;
        int slast = s.counts.length - 1;
        int fu = 0;
        int su = 0;
        n = 0;
        while (fu <= flast || su <= slast) {
            if (fu <= flast) {
                if (su > slast || f.counts[fu] > s.counts[su]) {
                    t.counts[n] = f.counts[fu];
                    t.factor[n] = f.factor[fu];
                    n++;
                    fu++;
                    continue;
                }
            }
            if (su <= slast) {
                if (fu > flast || f.counts[fu] < s.counts[su]) {
                    t.counts[n] = s.counts[su];
                    t.factor[n] = s.factor[su];
                    n++;
                    su++;
                    continue;
                }
            }
            if (fu <= flast && su <= slast) {
                if (f.counts[fu] == s.counts[su]) {
                    t.counts[n] = s.counts[su];
                    t.factor[n] = s.factor[su] + f.factor[fu];
                    n++;
                    fu++;
                    su++;
                }
            }
        }


        return t;

    }

    public Poly Res(Poly s) {
        Poly f = this;
        int n = f.NewN(s);

        Poly t = new Poly();//third
        t.counts = new int[n];
        t.factor = new int[n];

        int flast = f.counts.length - 1;
        int slast = s.counts.length - 1;
        int fu = 0;
        int su = 0;
        n = 0;
        while (fu <= flast || su <= slast) {
            if (fu <= flast) {
                if (su > slast || f.counts[fu] > s.counts[su]) {
                    t.counts[n] = f.counts[fu];
                    t.factor[n] = f.factor[fu];
                    n++;
                    fu++;
                    continue;
                }
            }
            if (su <= slast) {
                if (fu > flast || f.counts[fu] < s.counts[su]) {
                    t.counts[n] = s.counts[su];
                    t.factor[n] = -s.factor[su];
                    n++;
                    su++;
                    continue;
                }
            }
            if (fu <= flast && su <= slast) {
                if (f.counts[fu] == s.counts[su]) {
                    t.counts[n] = s.counts[su];
                    t.factor[n] = s.factor[su] - f.factor[fu];
                    n++;
                    fu++;
                    su++;
                }
            }
        }


        return t;

    }

    public Poly Mult(Poly s) {    //полноценное умножение                                          //умножение VVVVVVVVV
        Poly f = this;
        int fn = f.counts.length; //размер first
        int sn = s.counts.length; //размер second
        int n = fn * sn;  //максимальный размер нового
        int[] nCounts = new int[n];
        int[] nFactor = new int[n]; //!!!!!! факторы которые надо собрать в кучу. ПРИВЯЗАН К nCounts
        n = 0;
        for (int i = 0; i < fn; i++) {        //все подряд шоб картина была
            for (int j = 0; j < sn; j++) {
                nCounts[n] = f.counts[i] + s.counts[j];
                nFactor[n] = f.factor[i] * s.factor[j];
                n++;
            }
        }

        Set<Integer> mySet = new HashSet<>();
        for (int q : nCounts) {       //удаляю дубликаты
            mySet.add(q);
        }


        Poly who = new Poly();                //массив для ретёрна
        who.counts = new int[mySet.size()];   //из сета будет массив (степеней)
        who.factor = new int[mySet.size()];   //а это факторы будут

        int i = 0;
        for (int q : mySet) {                 //сет -> массив
            who.counts[i] = q;
            i++;
        }

        Arrays.sort(who.counts);             //сортировка по возрастанию
        for (i = 0; i < who.counts.length / 2; i++) {  //переворот
            int tmp = who.counts[i];
            who.counts[i] = who.counts[who.counts.length - i - 1];
            who.counts[who.counts.length - i - 1] = tmp;
        }


        for (i = 0; i < who.counts.length; i++) { //тут буду пихать факторы для конечного вывода
            int cou = who.counts[i];
            for (int j = 0; j < nCounts.length; j++) {
                if (cou == nCounts[j]) {
                    who.factor[i] += nFactor[j];
                }
            }
        }

        return who;
    }                                                                                      //умножение ^^^^^^^^^^^^^^^^^


    public static int[] trans(Poly sec) {  //из двух массивов в 1. так легче сделать деление и иногда ввести полином
        int maxs = sec.counts[0];    //максимальная степень
        int[] s = new int[maxs + 1]; //массив хранящий коэфиценты (факторы) всех одночленов в тч нулевых
        int n = 0;                   //для пробегания по двум старым массивам (с остановками)
        for (int i = 0; i <= maxs; i++) { //i для пробегания нового массива (без остановок)
            if (maxs - i == sec.counts[n]) {   //max-i - степень по ячейке i. maxs 10. i 1. -> вторая ячейка степень 9. vVv
                s[i] = sec.factor[n]; //и если эта степень соответствует степени в оригинале, то записывается значение, иначе 0

                n++; //следующая ячейка в старом массиве
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

        Poly one = transBack(new int[]{1,0,0,0,0,1,10,50,0,0,0,0,0,0});
        Poly dva = transBack(new int[]{1,2,3,4,5});
        Poly ans = one.delenie(dva);

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