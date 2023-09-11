import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Main {
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    static int M, N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) continue;

                ans ++;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.add(new int[] {i,j});
                int ans2 = 0;
                while (!q.isEmpty()){
                    int[] node = q.poll();
                    if (visited[node[0]][node[1]]) continue;
                    visited[node[0]][node[1]] = true;
                    ans2++;
                    for (int[] mv : move) {
                        int dx = mv[0] + node[0];
                        int dy = mv[1] + node[1];
                        if (dx<0||dx>=M||dy<0||dy>=N||visited[dx][dy])continue;
                        q.add(new int[] {dx,dy});
                    }
                }
                ansList.add(ans2);
            }
        }
        Collections.sort(ansList);
        for (Integer integer : ansList) {
            sb.append(integer).append(" ");
        }


        System.out.println(ans);
        System.out.println(sb);


    }

}
