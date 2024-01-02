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
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
            String email = input.nextToken();
            String pw = input.nextToken();
            map.put(email, pw);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String key = bufferedReader.readLine();
            builder.append(map.get(key)).append('\n');
        }
        bufferedWriter.write(builder.toString());

        bufferedWriter.flush();
    }
}
