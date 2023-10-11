import java.io.*;
import java.util.*;

public class Main {
    static int ans, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c=='W') map[i][j] = true;
                else map[i][j] = false;
            }
        }
        ans = 99999;
        for (int x = 0; x < N-7; x++) {
            for (int y = 0; y < M-7; y++) {
                ans = Math.min(ans, find(map, x, y));
            }
        }

        System.out.println(ans);
    }
    static int find(boolean[][] map, int x, int y){
        int startTResult = 0;
        int startFResult = 0;
        boolean start = true;
        for (int i = x; i < x + 8; i++) {
            start = !start;
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != start) startTResult++;
                if (map[i][j] != !start) startFResult++;
                start = !start;
            }
        }
        return Math.min(startTResult, startFResult);
    }

}
