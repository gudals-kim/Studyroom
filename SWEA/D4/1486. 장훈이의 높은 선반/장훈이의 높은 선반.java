import java.util.*;
import java.io.*;
public class Solution {
    static int[] arr;
    static int N, B;
    static int minValue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            minValue = Integer.MAX_VALUE;
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0,new boolean[N]);
            sb.append(minValue-B).append("\n");
        }


        System.out.println(sb.toString());
    }
    static void dfs(int sum,int start, boolean[] visited){
        if (sum>=B){
            minValue = Math.min(minValue, sum);
            return;
        }
        if (minValue<sum){
            return;
        }
        for (int i = start; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(sum+arr[i], i+1, visited);
            visited[i] = false;
        }

    }
}
