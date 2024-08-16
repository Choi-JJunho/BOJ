import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        visit = new boolean[N + 1];
        arr = new int[M];

        dfs(1, 0);

        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    public static void dfs(int at, int cnt) {
        if (cnt == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[cnt] = i;
            dfs(i, cnt + 1);
        }
    }
}
