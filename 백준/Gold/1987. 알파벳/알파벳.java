import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int ans = Integer.MIN_VALUE;
    static char[][] map;
    static int[][] move = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        dfs(0,0, 1, new boolean[R][C], new boolean['z'+1]);
        System.out.println(ans);
    }
    static void dfs(int x, int y, int cnt, boolean[][] visited, boolean[] chk){
        visited[0][0] = true;
        chk[map[0][0]] = true;
        ans = Math.max(cnt,ans);

        for (int[] mv : move) {
            int dx = mv[0] + x;
            int dy = mv[1] + y;

            if (dx<0||dx>=R||dy<0||dy>=C||visited[dx][dy]||chk[map[dx][dy]]) continue;
            visited[dx][dy] = true;
            chk[map[dx][dy]] = true;
            dfs(dx,dy,cnt+1,visited,chk);
            visited[dx][dy] = false;
            chk[map[dx][dy]] = false;
        }

    }
}
