import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] arr;
    static Stack<Integer> stack = new Stack();
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    public static void dfs( int cnt) {
        if (cnt == M) {
            for(int num : stack) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                stack.push(arr[i]);
                dfs(cnt + 1);
                stack.pop();
                visit[i] = false;
            }
        }
    }
}
