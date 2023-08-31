import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][M];
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = input.charAt(j)-'0';
                if (i<1||j<1) {
                    dp[i][j] = num;
                    maxNum = Math.max(maxNum, dp[i][j]);
                    continue;
                }
                if (num==0) continue;
                dp[i][j] = num + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                maxNum = Math.max(maxNum, dp[i][j]);
            }
        }
        System.out.println(maxNum * maxNum);
    }


}

