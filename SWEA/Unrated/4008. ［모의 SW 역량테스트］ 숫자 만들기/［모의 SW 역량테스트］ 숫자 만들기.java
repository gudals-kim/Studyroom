import java.io.*;
import java.util.*;

public class Solution {

    static int ans, maxNum, minNum;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            int[] cals = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cals[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            maxNum = Integer.MIN_VALUE;
            minNum = Integer.MAX_VALUE;
            dfs(cals, nums, nums[0], 1);
            ans = maxNum - minNum;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int[] cals, int[] nums, int result, int count){
        if (count==nums.length){
            maxNum = Math.max(maxNum, result);
            minNum = Math.min(minNum, result);
            return;
        }
        if (cals[0]>0){
            cals[0]--;
            dfs(cals, nums,result+nums[count],count+1);
            cals[0]++;
        }
        if (cals[1]>0) {
            cals[1]--;
            dfs(cals, nums,result-nums[count],count+1);
            cals[1]++;
        }
        if (cals[2]>0) {
            cals[2]--;
            dfs(cals, nums,result*nums[count],count+1);
            cals[2]++;
        }
        if (cals[3]>0) {
            cals[3]--;
            dfs(cals, nums,result/nums[count],count+1);
            cals[3]++;
        }
    }
}


