import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int R;
    static int C;
    static int answer;
    static char[][] arr;
    static boolean[] visit = new boolean[26];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        visit[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.flush();
    }

    public static void dfs(int x, int y, int cnt) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextX < C && nextX >= 0
                    && nextY < R && nextY >= 0
                    && !visit[arr[nextY][nextX] - 'A']) {
                visit[arr[nextY][nextX] - 'A'] = true;
                dfs(nextX, nextY, cnt + 1);
                visit[arr[nextY][nextX] - 'A'] = false;
                flag = true;
            }
        }
        // 상하좌우를 다 돌았는데도 더이상 탐색할 곳이 없는 경우 결과값을 계산한다.
        if (!flag) {
            answer = Math.max(answer, cnt);
        }
    }
}
