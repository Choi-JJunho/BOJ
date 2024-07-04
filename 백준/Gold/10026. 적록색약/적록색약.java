import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visit;
    static int N;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arr[i][j] = chars[j];
                arr[i][j] = chars[j];
            }
        }
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    search(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");
        cnt = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    search(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }

    public static void search(int y, int x) {
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (
                y + dy[i] >= N || x + dx[i] >= N || y + dy[i] < 0 || x + dx[i] < 0
                    || visit[y + dy[i]][x + dx[i]]
            ) {
                continue;
            }
            if (arr[y][x] == arr[y + dy[i]][x + dx[i]]) {
                search(y + dy[i], x + dx[i]);
            }
        }
    }
}
