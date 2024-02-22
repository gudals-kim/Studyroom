import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String comb = st.nextToken();
            if (comb.equals("push"))stack.addFirst(Integer.parseInt(st.nextToken()));
            else if (comb.equals("pop"))sb.append(stack.isEmpty() ? -1 : stack.pollFirst()).append("\n");
            else if (comb.equals("size"))sb.append(stack.size()).append("\n");
            else if (comb.equals("empty"))sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            else if (comb.equals("top"))sb.append(stack.isEmpty() ? -1 : stack.peekFirst()).append("\n");
        }
        System.out.println(sb);
    }

}