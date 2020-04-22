import java.util.Arrays;

public class massiv4iki {
    public static void main(String[] args) {
        int[][] a;
        a = new int[9][9];
        System.out.println(Arrays.deepToString(a));

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                a[i-1][j-1]=i*j;
            }
        }

        for (int i = 0; i < 9; i++)
            System.out.println(Arrays.toString(a[i]));

    }
}
