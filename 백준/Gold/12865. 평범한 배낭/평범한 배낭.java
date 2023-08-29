import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[n+1][k+1];
		
		for (int row = 1; row < (n+1); row++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for (int col = 1; col < (k+1); col++) {
				if (col < weight) {
					dp[row][col] = dp[row-1][col];
				} else {
					dp[row][col] = Math.max(dp[row-1][col], (dp[row-1][col-weight]+value));
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}