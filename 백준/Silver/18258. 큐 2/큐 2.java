import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comd = st.nextToken();
            if (comd.equals("push")) q.offerLast(Integer.parseInt(st.nextToken()));
            else if (comd.equals("front")) sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
            else if (comd.equals("back")) sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            else if (comd.equals("pop")) sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
            else if (comd.equals("empty")) sb.append(q.isEmpty() ? 1 : 0).append("\n");
            else if (comd.equals("size")) sb.append(q.size()).append("\n");
        }
        System.out.println(sb);
    }
}