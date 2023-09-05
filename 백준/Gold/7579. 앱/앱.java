import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] getAppUseByteAndCost;
    static int[][] dp;
    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//앱의 개수
        M = Integer.parseInt(st.nextToken());//확보해야하는 목표 바이트

        getAppUseByteAndCost = new int[N+1][2];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int costSum = 0;
        for (int i = 1; i < N+1; i++) {
            getAppUseByteAndCost[i][0] = Integer.parseInt(st.nextToken());
            getAppUseByteAndCost[i][1] = Integer.parseInt(st2.nextToken());
            costSum += getAppUseByteAndCost[i][1];
        }




        dp = new int[N+1][costSum+1];


        int ans = INF;
        for (int appNum = 1; appNum < N+1; appNum++) {
            for (int targetCost = 0; targetCost < costSum+1; targetCost++) {
                int remainCost = targetCost - getAppUseByteAndCost[appNum][1];
                if (remainCost>=0){
                    dp[appNum][targetCost] = Math.max(dp[appNum-1][targetCost], getAppUseByteAndCost[appNum][0]+dp[appNum-1][remainCost]);
                    if (dp[appNum][targetCost]>=M){
                        ans = Math.min(ans, targetCost);
                    }
                }else {
                    dp[appNum][targetCost] = dp[appNum-1][targetCost];
                }

            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        System.out.println(ans);
    }

}