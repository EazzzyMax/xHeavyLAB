import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolynomialTest {

    Polynomial p1 = new Polynomial(new double[]{10, 0, 0, 0, 4, 5, 4, 3, 2, 1, 0, 0, 0});
    Polynomial p2 = new Polynomial(new double[]{99999, 0, 0, 0, 1, 2, 3, 4, 5});
    Polynomial p3 = new Polynomial(new double[]{1});
    Polynomial p4 = new Polynomial(new double[]{5, 0});

    @Test
    void addition() {  //сложение

        Polynomial ans12 = p1.addition(p2);
        Polynomial ans13 = p1.addition(p3);
        Polynomial ans14 = p1.addition(p4);
        Polynomial ans23 = p2.addition(p3);
        Polynomial ans24 = p2.addition(p4);
        Polynomial ans34 = p3.addition(p4);
        System.out.println();

        Polynomial a12 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new double[]{10, 100003, 5, 4, 3, 3, 3, 3, 4, 5});
        Polynomial a13 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 0}, new double[]{10, 4, 5, 4, 3, 2, 1, 1});
        Polynomial a14 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 1}, new double[]{10, 4, 5, 4, 3, 2, 1, 5});
        Polynomial a23 = new Polynomial(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 4, 6});
        Polynomial a24 = new Polynomial(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 9, 5});
        Polynomial a34 = new Polynomial(new double[]{5, 1});

        Assert.assertEquals(a12.toString(), ans12.toString());
        Assert.assertEquals(a13.toString(), ans13.toString());
        Assert.assertEquals(a14.toString(), ans14.toString());
        Assert.assertEquals(a23.toString(), ans23.toString());
        Assert.assertEquals(a24.toString(), ans24.toString());
        Assert.assertEquals(a34.toString(), ans34.toString());


    }

    @Test
    void subtraction() {   //вычитание

        Polynomial ans12 = p1.subtraction(p2);
        Polynomial ans13 = p1.subtraction(p3);
        Polynomial ans14 = p1.subtraction(p4);
        Polynomial ans23 = p2.subtraction(p3);
        Polynomial ans24 = p2.subtraction(p4);
        Polynomial ans34 = p3.subtraction(p4);

        Polynomial a12 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new double[]{10, -99995, 5, 4, 3, 1, -1, -3, -4, -5});
        Polynomial a13 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 0}, new double[]{10, 4, 5, 4, 3, 2, 1, -1});
        Polynomial a14 = new Polynomial(new int[]{12, 8, 7, 6, 5, 4, 3, 1}, new double[]{10, 4, 5, 4, 3, 2, 1, -5});
        Polynomial a23 = new Polynomial(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, 4, 4});
        Polynomial a24 = new Polynomial(new int[]{8, 4, 3, 2, 1, 0}, new double[]{99999, 1, 2, 3, -1, 5});
        Polynomial a34 = new Polynomial(new double[]{-5, 1});


        Assert.assertEquals(a12.toString(), ans12.toString());
        Assert.assertEquals(a13.toString(), ans13.toString());
        Assert.assertEquals(a14.toString(), ans14.toString());
        Assert.assertEquals(a23.toString(), ans23.toString());
        Assert.assertEquals(a24.toString(), ans24.toString());
        Assert.assertEquals(a34.toString(), ans34.toString());

    }

    @Test
    void multiplication() { //умножение

        p1 = new Polynomial(new double[]{1, 2, 3, 4, 5});

        Polynomial ans12 = p1.multiplication(p2);
        Polynomial ans13 = p1.multiplication(p3);
        Polynomial ans14 = p1.multiplication(p4);
        Polynomial ans23 = p2.multiplication(p3);
        Polynomial ans24 = p2.multiplication(p4);
        Polynomial ans34 = p3.multiplication(p4);

        Polynomial a12 = new Polynomial(new double[]{99999, 199998, 299997, 399996, 499996, 4, 10, 20, 35, 44, 46, 40, 25});
        Polynomial a13 = new Polynomial(new double[]{1, 2, 3, 4, 5});
        Polynomial a14 = new Polynomial(new double[]{5, 10, 15, 20, 25, 0});
        Polynomial a23 = new Polynomial(new double[]{99999, 0, 0, 0, 1, 2, 3, 4, 5});
        Polynomial a24 = new Polynomial(new double[]{499995, 0, 0, 0, 5, 10, 15, 20, 25, 0});
        Polynomial a34 = new Polynomial(new double[]{5, 0});


        Assert.assertEquals(a12.toString(), ans12.toString());
        Assert.assertEquals(a13.toString(), ans13.toString());
        Assert.assertEquals(a14.toString(), ans14.toString());
        Assert.assertEquals(a23.toString(), ans23.toString());
        Assert.assertEquals(a24.toString(), ans24.toString());
        Assert.assertEquals(a34.toString(), ans34.toString());

    }

    @Test
    void divide() {
        p2 = new Polynomial(new double[]{1, 2, 3, 4, 5});
        Polynomial p5 = new Polynomial(new double[]{27, 9, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 27});
        Polynomial p6 = new Polynomial(new double[]{3, 1, 0});

        Polynomial ans12 = p1.divide(p2);
        Polynomial ans13 = p1.divide(p3);
        Polynomial ans14 = p1.divide(p4);
        Polynomial ans23 = p2.divide(p3);
        Polynomial ans24 = p2.divide(p4);
        Polynomial ans56 = p5.divide(p6);


        Polynomial a12 = new Polynomial(new double[]{10, -20, 10, 0, 4, 57, -172, 160, -50});
        Polynomial a13 = p1;
        Polynomial a14 = new Polynomial(new double[]{2, 0, 0, 0, 0.8, 1, 0.8, 0.6, 0.4, 0.2, 0, 0});
        Polynomial a23 = new Polynomial(new double[]{1, 2, 3, 4, 5});
        Polynomial a24 = new Polynomial(new double[]{0.2, 0.4, 0.6, 0.8});
        Polynomial a56 = new Polynomial(new int[]{19,17,0}, new double[]{9,1,1});


        Assert.assertEquals(a12.toString(), ans12.toString());
        Assert.assertEquals(a13.toString(), ans13.toString());
        Assert.assertEquals(a14.toString(), ans14.toString());
        Assert.assertEquals(a23.toString(), ans23.toString());
        Assert.assertEquals(a24.toString(), ans24.toString());
        Assert.assertEquals(a56.toString(), ans56.toString());

    }
}