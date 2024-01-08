import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bufferedReader.readLine();
        StringTokenizer numbers = new StringTokenizer(input, "+-");

        Queue<Boolean> plus = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                plus.add(true);
            } else if (input.charAt(i) == '-') {
                plus.add(false);
            }
        }

        Deque<Integer> sum = new ArrayDeque<>();

        while (numbers.hasMoreTokens()) {
            int num = Integer.parseInt(numbers.nextToken());
            if (sum.isEmpty()) {
                sum.add(num);
                continue;
            }
            if (!plus.isEmpty()) {
                Boolean isPlus = plus.poll();
                if (isPlus) {
                    sum.addLast(sum.pollLast() + num);
                } else {
                    sum.addLast(num);
                }
            }
        }

        int result = sum.pollFirst();
        while(!sum.isEmpty()) {
            result -= sum.pollFirst();
        }
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }
}