import java.util.*;
import java.io.*;
public class Main {

    static int N, M;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        boolean[][] canMove = new boolean[M][N];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int tomato = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==0){
                    canMove[i][j] = true;
                    tomato++;
                }
                if (map[i][j]==1){
                    tomato++;
                    q.add(new Pair(i,j,0));
                    canMove[i][j] = true;
                }
            }
        }
        int ans = 0;
        int dTomato = 0;
        while (!q.isEmpty()){

            Pair node = q.poll();

            if (!canMove[node.x][node.y]) continue;
            canMove[node.x][node.y] = false;
            ans = Math.max(ans, node.depth);
            dTomato++;

            for (int[] mv : move) {
                int dx = mv[0]+node.x;
                int dy = mv[1]+node.y;
                if (dx>=0&&dx<M&&dy>=0&&dy<N&&canMove[dx][dy]){
                    q.add(new Pair(dx, dy, node.depth+1));
                }
            }
        }
        if (dTomato==tomato){
            System.out.println(ans);
        }else {
            System.out.println(-1);
        }
    }



}
class Pair{
    int x;
    int y;
    int depth;
    public Pair(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}