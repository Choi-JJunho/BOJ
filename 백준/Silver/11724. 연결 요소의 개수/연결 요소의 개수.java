import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static boolean[] check;
    private static int n;
    private static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                result++;
            }
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }

    private static void dfs(int i) {
        if (check[i]) {
            return;
        } else {
            check[i] = true;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    dfs(j);
                }
            }
        }
    }
}
