import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int[][] arr;
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new int[N][3];
        dist = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(input.nextToken());
            int g = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }

        dist[0][0] = arr[0][0];
        dist[0][1] = arr[0][1];
        dist[0][2] = arr[0][2];

        for (int j = 1; j < N; j++) {
            for (int i = 0; i < 3; i++) {
                int min = Math.min(dist[j - 1][(i + 1) % 3], dist[j - 1][(i + 2) % 3]);
                dist[j][i] = min + arr[j][i];
            }
        }
        int result = Math.min(Math.min(dist[N - 1][0], dist[N - 1][1]), dist[N - 1][2]);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }
}
