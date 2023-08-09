
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        boolean[][] sq = new boolean[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int maxX =0;
        int maxY =0;
        int ans = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maxX = Math.max(maxX,x+10);
            maxY = Math.max(maxY,y+10);

            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    if (!sq[i][j])ans++;
                    sq[i][j] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
