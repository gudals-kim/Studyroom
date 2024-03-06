import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        perm(new int[M], 0, new boolean[N+1], sb);
        System.out.println(sb);

    }
    static void perm(int[] arr, int cnt, boolean[] visit, StringBuilder sb){
        if (cnt==M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[cnt] = i;
            perm(arr, cnt+1, visit, sb);
            visit[i] = false;
        }
    }
}