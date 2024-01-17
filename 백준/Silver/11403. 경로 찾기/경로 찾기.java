import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(input.nextToken());
                arr[i][j] = a;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (
                int i = 0;
                i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}

/**
 * 1 -> 2 2 -> 3 3 -> 1
 */
