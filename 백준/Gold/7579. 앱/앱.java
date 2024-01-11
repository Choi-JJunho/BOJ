import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;
    static int MEM[];
    static int C[];
    static int CACHE[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        MEM = new int[N + 1];
        C = new int[N + 1];
        CACHE = new int[N + 1][10001];

        StringTokenizer inputA = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer inputB = new StringTokenizer(bufferedReader.readLine());
        for (int j = 1; j <= N; j++) {
            MEM[j] = Integer.parseInt(inputA.nextToken());
            C[j] = Integer.parseInt(inputB.nextToken());
        }

        int res = Integer.MAX_VALUE;
        for (int stuff = 1; stuff <= N; stuff++) {
            for (int cost = 0; cost <= 10000; cost++) {
                if (stuff == 1) {
                    if (cost >= C[stuff]) {
                        CACHE[stuff][cost] = MEM[stuff];
                    }
                } else {
                    // 비용이 cost 일 때 idx 앱에서 취할 수 있는 가장 큰 메모리 수를 구한다.
                    if (cost >= C[stuff]) {
                        CACHE[stuff][cost] = Math.max(
                            CACHE[stuff - 1][cost - C[stuff]] + MEM[stuff],
                            CACHE[stuff - 1][cost]
                        );
                    } else {
                        CACHE[stuff][cost] = CACHE[stuff - 1][cost];
                    }
                }

                if (CACHE[stuff][cost] >= M) {
                    res = Math.min(res, cost);
                }
            }
        }

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.flush();
    }
}
