import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] Volume;
    static int[] Need;
    static int[][] price;
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        Volume = new int[N + 1];
        Need = new int[N + 1];
        price = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            Volume[i] = Integer.parseInt(input.nextToken());
            Need[i] = Integer.parseInt(input.nextToken());
            Arrays.fill(price[i], -1);
        }
        int res = 0;
        res = Math.max(res, pack(K, 1));
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.flush();
    }

    // weight 만큼 무게가 남은 경우! 최적해를 구한다.
    private static int pack(int weight, int stuff) {
        // 담을 물건이 없음.
        if (stuff == N + 1) {
            return 0;
        }
        // 무게가 weight인 stuff의 가치 price[stuff][wight]
        // 이미 할당된 값이면 검사하지말고 반환할거임
        if (price[stuff][weight] != -1) {
            return price[stuff][weight];
        }
        // 할당 안됨. 근데 이거 안담을거임.
        price[stuff][weight] = pack(weight, stuff + 1);

        // 할당 안됨. 이거 담을거임. (처음이라면 0부터 올거임)
        // 조건. 무게가 넘치면 안됨. 남은 무게가 Volume[stuff]보다 크거나 같아야 함.
        // weight 무게만큼 남았을 때 담는 경우임.
        if (weight >= Volume[stuff]) {
            //
            price[stuff][weight] = Math.max(
                // 저장되어있던 weight일 때 해당 stuff의 가치
                price[stuff][weight],
                // 남은 무게에서 뽑아낼 수 있는 가치 + 현재 물건의 가치를 더한 값
                pack(weight - Volume[stuff], stuff + 1) + Need[stuff]
            );
        }
        // 현재 물건의 가치
        return price[stuff][weight];
    }
}
