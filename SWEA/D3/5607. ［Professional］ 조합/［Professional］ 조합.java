
import java.util.*;
import java.io.*;

public class Solution {
    static Long ans;
    static int MOD = 1234567891;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            ans = comb(N,R);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
    static Long comb(int n, int r){
        long[] fact = new long[n + 1];
        fact[0] = 1;

        // Factorial을 계산합니다.
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long inverseR = modInverse(fact[r]);
        long inverseNR = modInverse(fact[n - r]);

        // N Combination R을 계산합니다.
        long result = (fact[n] * inverseR) % MOD;
        result = (result * inverseNR) % MOD;

        return result;
    }

    //dp 를 사용해서 nCr 조합 개수를 찾는법
    static int combDp(int[][] dp, int n, int r){
        if (dp[n][r] > 0){//이미 저장된 값이 있다면 리턴한다.
            return dp[n][r];
        }
        if (n==r||r==0){//n개중 n개를 뽑는 경우와 n개중 0개를 뽑는 경우는 1이다.
            return dp[n][r] = 1;
        }
        //저장된 값이 없다면 -> 0이라면 -> 값을 찾아준다.
        return dp[n][r] = combDp(dp,n-1,r-1) + combDp(dp,n-1,r);
    }

}
