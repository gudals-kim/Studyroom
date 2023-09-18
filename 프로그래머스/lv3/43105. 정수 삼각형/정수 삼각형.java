import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[triangle.length-1] = triangle[triangle.length-1];
        for(int i=triangle.length-2; i > -1; i--){
            dp[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++){
                dp[i][j] = Math.max(triangle[i][j] + dp[i+1][j], triangle[i][j] + dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}