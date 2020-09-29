public class bisection {
    static double f(double x) {
        return x * x * x * x * x * x * x + 2 * x * x * x;
    }

    public static void main(String[] args) {
        double a = -10000.0, b = 10000, c, y, eps = 1e-8;
        do {
            c = (a + b) / 2;
            y = f(c);
            if (Math.abs(y) < eps) break;
            if (f(a) * y < 0) b = c;
            else a = c;
        } while (Math.abs(b - a) >= eps);
        System.out.println(c);
    }
}
