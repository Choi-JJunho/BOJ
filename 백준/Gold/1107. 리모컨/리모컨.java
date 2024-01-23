import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        List<Integer> broken = new ArrayList<>();
        if (M != 0) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            while (input.hasMoreTokens()) {
                broken.add(Integer.parseInt(input.nextToken()));
            }
        }

        int res = Math.abs(100 - N);

        for (int i = 0; i <= 999999; i++) {
            String target = String.valueOf(i);
            boolean flag = false;

            for (int j = 0; j < target.length(); j++) {
                if (broken.contains(target.charAt(j) - '0')) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            int temp = Math.abs(N - i) + target.length();
            res = Math.min(res, temp);
        }

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.flush();
    }
}
