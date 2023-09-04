import java.io.*;
import java.util.*;

public class Main {
    static final int cost = 0;
    static final int client = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] citys = new int[N][2];

        int maxClient = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            citys[i][cost] = Integer.parseInt(st.nextToken());
            citys[i][client] = Integer.parseInt(st.nextToken());
            maxClient = Math.max(maxClient, citys[i][client]);
        }

        int ans = Integer.MAX_VALUE;
        int[] dp = new int[C+maxClient+1];
        Arrays.fill(dp,999999);
        dp[0] = 0;

        for (int targetClient = 1; targetClient <= C+maxClient; targetClient++) {
            for (int cityNum = 0; cityNum < N; cityNum++) {
                if (targetClient-citys[cityNum][client]>=0){
                    dp[targetClient] = Math.min(dp[targetClient],dp[targetClient-citys[cityNum][client]]+citys[cityNum][cost]);
                }
                if (targetClient>=C){
                    ans = Math.min(ans, dp[targetClient]);
                }
            }
        }
        System.out.println(ans);
    }


}