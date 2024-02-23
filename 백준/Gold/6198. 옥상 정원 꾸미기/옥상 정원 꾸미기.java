import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()){
                if (stack.peekFirst() <= h ) stack.pollFirst();
                else break;
            }
            ans += stack.size();
            stack.offerFirst(h);
        }
        System.out.println(ans);
    }
}