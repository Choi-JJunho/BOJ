import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 98765432;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(input.nextToken());
            int B = Integer.parseInt(input.nextToken());

            arr[A][B] = arr[B][A] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }
            if (result > sum) {
                result = sum;
                idx = i;
            }
        }

        bufferedWriter.write(String.valueOf(idx));
        bufferedWriter.flush();
    }
}
