import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                arr[j][i] = Integer.parseInt(stk.nextToken());
            }
        }

        partition(0, 0, n);

        bufferedWriter.write(String.valueOf(white) + System.lineSeparator());
        bufferedWriter.write(String.valueOf(blue));
        bufferedWriter.flush();
    }

    private static void partition(int x, int y, int n) {

        if (isSameColors(x, y, n)) {
            if (arr[x][y] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = n / 2;

        partition(x, y, newSize);
        partition(x + newSize, y, newSize);
        partition(x, y + newSize, newSize);
        partition(x + newSize, y + newSize, newSize);
    }

    private static boolean isSameColors(int x, int y, int n) {
        int color = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
