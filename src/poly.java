import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class poly { //класс хранящий массивы
    int[] counts; //степени по убыванию
    int[] factor; //множители


    public poly() { //пустой конструктор
    }

    public poly(int[] cou, int[] fac) {

    }


    public Integer NewN(poly s) { //размер нового полинома. f - first, s - second (полиномы)
        poly f = this;
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

    public poly Summ(poly s) {
        poly f = this;
        int n = f.NewN(s);

        poly t = new poly();//third
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

    public poly Res(poly s) {
        poly f = this;
        int n = f.NewN(s);

        poly t = new poly();//third
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

    public poly Mult(poly s) {    //полноценное умножение                                          //умножение VVVVVVVVV
        poly f = this;
        int fn = f.counts.length; //размер first
        int sn = s.counts.length; //размер second
        int n = fn*sn;  //максимальный размер нового
        int[] nCounts = new int[n];
        int[] nFactor = new int[n]; //!!!!!! факторы которые надо собрать в кучу. ПРИВЯЗАН К nCounts
        n = 0;
        for (int i = 0; i<fn; i++) {        //все подряд шоб картина была
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



        poly who = new poly();                //массив для ретёрна
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


        for (i = 0; i<who.counts.length; i++) { //тут буду пихать факторы для конечного вывода
            int cou = who.counts[i];
            for (int j = 0; j<nCounts.length; j++) {
                if (cou == nCounts[j] ) {
                    who.factor[i] += nFactor[j];
                }
            }
        }

        return who;
    }                                                                                      //умножение ^^^^^^^^^^^^^^^^^


    public static void main(String[] args) { //коммент

        poly first = new poly();
        first.counts = new int[]{10, 9, 8, 7, 5}; //степени {10%, 6%, 5%, 4%, 3%};
        first.factor = new int[]{5, 4, 2, 3, 6}; //множители

        poly second = new poly();
        second.counts = new int[]{10, 8, 7, 6, 3, 0}; //{9%, 7%, 3%, 2, 1, 0};
        second.factor = new int[]{1, 2, 5, 1, 3, 5};






    }
}