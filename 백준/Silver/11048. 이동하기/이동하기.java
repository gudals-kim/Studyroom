
import java.util.*;
import java.io.*;
public class Main {

    static int N, M;
    static int[][] map, dp;
    static int[][] move = {{1,0},{0,1},{1,1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = map[i][j];
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isArea(i+1,j)){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+map[i+1][j]);
                }
                if (isArea(i,j+1)){
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+map[i][j+1]);
                }
                if (isArea(i+1,j+1)){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+map[i+1][j+1]);
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }

    static boolean isArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}
