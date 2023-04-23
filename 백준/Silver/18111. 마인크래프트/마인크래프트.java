import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    static int time = Integer.MAX_VALUE;
    static int height;
    static int N, M, B;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N + 1][M + 1];
        int max_height = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(stk.nextToken());
                arr[i][j] = a;
                max_height = Math.max(max_height, a);
            }
        }

        doSomething(max_height);

        bufferedWriter.write(time + " " + height);
        bufferedWriter.flush();
    }

    private static void doSomething(int max_height) {
        // 높이별 시간, 높이를 비교한다.
        // 시간을 먼저 비교한 뒤 높이를 비교한다.
        // 비교 : 작은 시간인가? -> 큰 높이인가?
        for (int i = 0; i <= max_height; i++) {
            int[] time_height = calculate(i);

            // 작은 시간을 만족하면 시간, 높이 저장
            if (time > time_height[0]) {
                time = time_height[0];
                height = time_height[1];
            } else if (time == time_height[0] && height < time_height[1]) {
                // 시간이 같다면
                // 높이를 비교, 더 높다면 저장
                height = time_height[1];
            }
        }
    }

    private static int[] calculate(int target_height) {
        int cal_time = 0;
        int cal_block = B;
        int[] result = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int current_height = arr[i][j];
                if (current_height == target_height) {
                    continue;
                }

                // 블럭을 빼는 경우 시간 + 2, block + 1
                if (current_height > target_height) {
                    int diff = current_height - target_height;
                    cal_time += (diff * 2);
                    cal_block += diff;
                }
                // 블럭을 놓는 경우 시간 + 1, block -1
                else {
                    int diff = target_height - current_height;
                    cal_time += diff;
                    cal_block -= diff;
                }
            }
        }

        // block이 모자란 경우 time은 최댓값
        if (cal_block < 0) {
            cal_time = Integer.MAX_VALUE;
        }

        result[0] = cal_time;
        result[1] = target_height;

        return result;
    }
}
