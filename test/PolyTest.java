import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PolyTest {

    Poly p1 = new Poly(new double[]{10, 0, 0, 0, 4, 5, 4, 3, 2, 1, 0, 0, 0});
    Poly p2 = new Poly(new double[]{99999, 0, 0, 0, 1, 2, 3, 4, 5});
    Poly p3 = new Poly(new double[]{1});
    Poly p4 = new Poly(new double[]{5, 0});

    @Test
    void summ() {


        Poly ans12 = p1.summ(p2);
        Poly ans13 = p1.summ(p3);
        Poly ans14 = p1.summ(p4);
        Poly ans23 = p2.summ(p3);
        Poly ans24 = p2.summ(p4);
        Poly ans34 = p3.summ(p4);
        System.out.println();

        Poly a12 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new double[]{10, 100003, 5, 4, 3, 3, 3, 3, 4, 5});
        Poly a13 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 0}, new double[]{10, 4, 5, 4, 3, 2, 1, 1});
        Poly a14 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 1}, new double[]{10, 4, 5, 4, 3, 2, 1, 5});
        Poly a23 = new Poly(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 4, 6});
        Poly a24 = new Poly(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 9, 5});
        Poly a34 = new Poly(new double[]{5, 1});


        Assert.assertEquals(Arrays.toString(Poly.trans(a12)), Arrays.toString(Poly.trans(ans12)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a13)), Arrays.toString(Poly.trans(ans13)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a14)), Arrays.toString(Poly.trans(ans14)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a23)), Arrays.toString(Poly.trans(ans23)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a24)), Arrays.toString(Poly.trans(ans24)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a34)), Arrays.toString(Poly.trans(ans34)));


    }

    @Test
    void res() {
        Poly ans12 = p1.res(p2);
        Poly ans13 = p1.res(p3);
        Poly ans14 = p1.res(p4);
        Poly ans23 = p2.res(p3);
        Poly ans24 = p2.res(p4);
        Poly ans34 = p3.res(p4);

        Poly a12 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new double[]{10, -99995, 5, 4, 3, 1, -1, -3, -4, -5});
        Poly a13 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 0}, new double[]{10, 4, 5, 4, 3, 2, 1, -1});
        Poly a14 = new Poly(new int[]{12, 8, 7, 6, 5, 4, 3, 1}, new double[]{10, 4, 5, 4, 3, 2, 1, -5});
        Poly a23 = new Poly(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 4, 4});
        Poly a24 = new Poly(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, -1, 5});
        Poly a34 = new Poly(new double[]{-5, 1});


        Assert.assertEquals(Arrays.toString(Poly.trans(a12)), Arrays.toString(Poly.trans(ans12)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a13)), Arrays.toString(Poly.trans(ans13)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a14)), Arrays.toString(Poly.trans(ans14)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a23)), Arrays.toString(Poly.trans(ans23)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a24)), Arrays.toString(Poly.trans(ans24)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a34)), Arrays.toString(Poly.trans(ans34)));

    }

    @Test
    void mult() {
        p1 = new Poly(new double[]{1, 2, 3, 4, 5});

        Poly ans12 = p1.mult(p2);
        Poly ans13 = p1.mult(p3);
        Poly ans14 = p1.mult(p4);
        Poly ans23 = p2.mult(p3);
        Poly ans24 = p2.mult(p4);
        Poly ans34 = p3.mult(p4);

        Poly a12 = new Poly(new double[]{99999, 199998, 299997, 399996, 499996, 4, 10, 20, 35, 44, 46, 40, 25});
        Poly a13 = new Poly(new double[]{1, 2, 3, 4, 5});
        Poly a14 = new Poly(new double[]{5, 10, 15, 20, 25, 0});
        Poly a23 = new Poly(new double[]{99999, 0, 0, 0, 1, 2, 3, 4, 5});
        Poly a24 = new Poly(new double[]{499995, 0, 0, 0, 5, 10, 15, 20, 25, 0});
        Poly a34 = new Poly(new double[]{5, 0});


        Assert.assertEquals(Arrays.toString(Poly.trans(a12)), Arrays.toString(Poly.trans(ans12)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a13)), Arrays.toString(Poly.trans(ans13)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a14)), Arrays.toString(Poly.trans(ans14)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a23)), Arrays.toString(Poly.trans(ans23)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a24)), Arrays.toString(Poly.trans(ans24)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a34)), Arrays.toString(Poly.trans(ans34)));

    }

    @Test
    void delenie() {
        p2 = new Poly(new double[]{1, 2, 3, 4, 5});

        Poly ans12 = p1.delenie(p2);
        Poly ans13 = p1.delenie(p3);
        Poly ans14 = p1.delenie(p4);
        Poly ans23 = p2.delenie(p3);
        Poly ans24 = p2.delenie(p4);
        Poly ans34 = p3.delenie(p4);

        Poly a12 = new Poly(new double[]{10, -20, 10, 0, 4, 57, -172, 160, -50});
        Poly a13 = p1;
        Poly a14 = new Poly(new double[]{2, 0, 0, 0, 0.8, 1, 0.8, 0.6, 0.4, 0.2, 0, 0});
        Poly a23 = new Poly(new double[]{1, 2, 3, 4, 5});
        Poly a24 = new Poly(new double[]{499995, 0, 0, 0, 5, 10, 15, 20, 25, 0});
        Poly a34 = new Poly(new double[]{5, 0});


        Assert.assertEquals(Arrays.toString(Poly.trans(a12)), Arrays.toString(Poly.trans(ans12)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a13)), Arrays.toString(Poly.trans(ans13)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a14)), Arrays.toString(Poly.trans(ans14)));
        Assert.assertEquals(Arrays.toString(Poly.trans(a23)), Arrays.toString(Poly.trans(ans23)));
//        Assert.assertEquals(Arrays.toString(Poly.trans(a24)), Arrays.toString(Poly.trans(ans24)));
//        Assert.assertEquals(Arrays.toString(Poly.trans(a34)), Arrays.toString(Poly.trans(ans34)));
    }
}