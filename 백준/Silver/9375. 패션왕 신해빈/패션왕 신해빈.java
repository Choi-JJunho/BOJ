import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
                String wear = stk.nextToken();
                String type = stk.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            int res = 1;
            for (Integer val : map.values()) {
                res *= (val + 1);
            }
            sb.append(res - 1).append('\n');
        }

        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}
