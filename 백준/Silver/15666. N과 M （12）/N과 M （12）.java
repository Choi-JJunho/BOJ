import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int[] arr;
    static int[] to;
    static boolean[] visit;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N];
        to = new int[M];
        visit = new boolean[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        bufferedWriter.write(String.join("\n", list));
        bufferedWriter.flush();
    }

    public static void dfs(int at, int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : to) {
                sb.append(i).append(" ");
            }
            var res = sb.toString();
            if (!list.contains(res)) {
                list.add(sb.toString());
            }
            return;
        }
        for (int i = at; i < N; i++) {
            to[cnt] = arr[i];
            dfs(i, cnt + 1);
        }
    }
}
