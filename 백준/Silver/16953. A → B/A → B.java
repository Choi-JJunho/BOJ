import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int FROM, TARGET;
    static boolean flag;
    static long INF = Long.MAX_VALUE;
    static long ans = INF;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        FROM = Integer.parseInt(stringTokenizer.nextToken());
        TARGET = Integer.parseInt(stringTokenizer.nextToken());
        dfs(FROM, 1);
        bufferedWriter.write(!flag ? "-1" : String.valueOf(ans));
        bufferedWriter.flush();
    }

    public static void dfs(long at, int cnt) {
        if (at > TARGET) {
            return;
        }
        if (at == TARGET) {
            ans = Math.min(cnt, ans);
            flag = true;
            return;
        }

        dfs(at * 10 + 1, cnt + 1);
        dfs(at * 2, cnt + 1);
    }
}
