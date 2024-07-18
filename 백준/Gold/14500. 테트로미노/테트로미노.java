import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

  public static int[] dx = {0, 0, -1, 1};
  public static int[] dy = {1, -1, 0, 0};
  static int max = 0;
  static boolean[][] visit;
  static int[][] arr;
  static int N;
  static int M;

  public static void main(String[] args) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
    N = Integer.parseInt(stk.nextToken());
    M = Integer.parseInt(stk.nextToken());
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      stk = new StringTokenizer(bufferedReader.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(stk.nextToken());
      }
    }
    visit = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visit[i][j] = true;
        solve(j, i, arr[i][j], 1);
        visit[i][j] = false;
      }
    }
    bufferedWriter.write(String.valueOf(max));
    bufferedWriter.flush();
  }

  public static void solve(int x, int y, int sum, int count) {
    if (count == 4) {
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nextX = dx[i] + x;
      int nextY = dy[i] + y;
      if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) {
        continue;
      }
      if (!visit[nextY][nextX]) {
        if (count == 2) {
          visit[nextY][nextX] = true;
          solve(x, y, sum + arr[nextY][nextX], count + 1);
          visit[nextY][nextX] = false;
        }
        visit[nextY][nextX] = true;
        solve(nextX, nextY, sum + arr[nextY][nextX], count + 1);
        visit[nextY][nextX] = false;
      }
    }
  }
}
