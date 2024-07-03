import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[3];
        nums[0] = bufferedReader.readLine();
        nums[1] = bufferedReader.readLine();
        nums[2] = bufferedReader.readLine();
        if (nums[0].contains("Fizz")) {
            sb.append("Fizz");
        }
        int num = 0;
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            try {
                num = Integer.parseInt(nums[i]);
                if (num % 5 == 2 + i) {
                    flag = true;
                }
            } catch (NumberFormatException ignore) {
            }
        }
        if (flag) {
            sb.append("Buzz");
        }
        if (sb.length() == 0) {
            if (Objects.equals(String.valueOf(num), nums[0])) {
                num += 3;
            }
            if (Objects.equals(String.valueOf(num), nums[1])) {
                num += 2;
            }
            if (Objects.equals(String.valueOf(num), nums[2])) {
                num += 1;
            }
            sb.append(num);
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
    }
}
