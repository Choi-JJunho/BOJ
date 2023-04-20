import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> origin = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            origin.add(target);
            sorted.add(target);
        }
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        for (Integer integer : sorted) {
            if (!map.containsKey(integer)) {
                map.put(integer, rank++);
            }
        }

        for (Integer integer : origin) {
            bufferedWriter.write(map.get(integer) + " ");
        }

        bufferedWriter.flush();
    }
}
