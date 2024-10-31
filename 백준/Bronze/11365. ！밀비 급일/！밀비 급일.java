import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        while (!"END".equals(line)) {
            var chars = line.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            sb.append("\n");
            line = sc.nextLine();
        }
        System.out.println(sb);
    }
}
