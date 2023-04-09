import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String t = bufferedReader.readLine();
        int i = Integer.parseInt(t);
        for (int j = 0; j < i; j++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            boolean[][] arr = new boolean[n][m];

            for (int l = 0; l < k; l++) {
                StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                arr[y][x] = true;
            }

            int result = removeBaeChu(arr, m, n);
            bufferedWriter.write(String.valueOf(result) + System.lineSeparator());
        }
        bufferedWriter.flush();
    }

    private static int removeBaeChu(boolean[][] arr, int x_len, int y_len) {
        int count = 0;
        for (int i = 0; i < y_len; i++) {
            for (int j = 0; j < x_len; j++) {
                if (arr[i][j]) {
                    moveAround(arr, i, j, y_len, x_len);
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean moveAround(final boolean[][] arr, final int y, final int x, final int y_len, final int x_len) {
        arr[y][x] = false;

        if (x + 1 < x_len && arr[y][x + 1]) moveAround(arr, y, x + 1, y_len, x_len);
        if (x - 1 >= 0 && arr[y][x - 1]) moveAround(arr, y, x - 1, y_len, x_len);
        if (y + 1 < y_len && arr[y + 1][x]) moveAround(arr, y + 1, x, y_len, x_len);
        if (y - 1 >= 0 && arr[y - 1][x]) moveAround(arr, y - 1, x, y_len, x_len);

        return false;
    }
}
