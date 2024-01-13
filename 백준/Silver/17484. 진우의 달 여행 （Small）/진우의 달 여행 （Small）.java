import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int result = 999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==0&&j==2) continue;
                if (i==m-1&&j==0) continue;
                dfs(0, i,j,map[0][i]);
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int dist, int sum){
        if (x == n-1){
            result = Math.min(result, sum);
            return;
        }
        for (int nextDist = -1; nextDist < 2; nextDist++) {
            int dy = y + nextDist;
            if (nextDist==dist||dy<0||dy>=m) continue;
            dfs(x+1,dy,nextDist,sum+map[x+1][dy]);
        }
    }

}