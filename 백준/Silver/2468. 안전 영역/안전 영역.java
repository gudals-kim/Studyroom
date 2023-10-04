import java.io.*;
import java.util.*;

public class Main {
    static int ans = -1;
    static int N;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int maxH = -1;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                maxH = Math.max(arr[i][j], maxH);
            }
        }

        for (int h = 0; h <= maxH; h++) {
            boolean[][] visit = new boolean[N][N];
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]||arr[i][j]<=h) continue;
                    temp++;
                    bfs(arr,h,i,j,visit);
                }
            }
//            System.out.println("현재 높이 : "+h+" 안전영역 개수 : "+temp);
            ans = Math.max(ans, temp);
        }



        System.out.println(ans);

    }
    static void bfs(int[][] map, int h, int x, int y, boolean[][] visit){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()){

            Node node = q.poll();
            if (visit[node.x][node.y])continue;
            visit[node.x][node.y] = true;

            for (int[] mv : move) {
                int dx = mv[0] + node.x;
                int dy = mv[1] + node.y;
                if (dx<0||dx>=N||dy<0||dy>=N||visit[dx][dy]||map[dx][dy]<=h)continue;
                q.add(new Node(dx,dy));
            }
        }
    }

}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}