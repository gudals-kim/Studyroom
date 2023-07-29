import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        if (n==1){
            System.out.println(1);
            return;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[n]);

        // n = 1 -> 1 |
        // n = 2 -> 2 = || [1+1]
        // n = 3 -> 3 =| ||| |= [1+1+1]
        // n = 4 -> 5 =|| |||| ||= |=| ==
        // n = 5 -> 8 =||| ==| |=|| ||||| ||=| |== |||= =|=
        // n = n -> n-1 + n-2
    }
}