import java.io.*;
import java.util.*;

public class Main{

    static int N, M, startX, startY, endX, endY;
    static int ans = -1;
    static boolean[][] map;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 미로의 세로 길이
        M = Integer.parseInt(st.nextToken()); // 미로의 가로 길이

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken())-1; //startX
        startY = Integer.parseInt(st.nextToken())-1; //startY

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken())-1; //endX
        endY = Integer.parseInt(st.nextToken())-1; //endY

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int wall = Integer.parseInt(st.nextToken());
                if (wall==0){
                    map[i][j] = true;
                }
            }
        }

        boolean[][][] visited = new boolean[2][N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(startX, startY, 0, 0));
        while (!q.isEmpty()){
            Node node = q.poll();

            if (!isArea(node.x, node.y)) continue;
            if (visited[node.can][node.x][node.y]) continue;
            visited[node.can][node.x][node.y] = true;

            if (node.x==endX&&node.y==endY){
                ans = node.cnt;
                break;
            }


            if (!map[node.x][node.y]) {//벽이라면?
                if (node.can==0){//벽을 뚫은 적이 없을때,
                    for (int[] mv : move) {
                        int dx = node.x + mv[0];
                        int dy = node.y + mv[1];
                        if (!isArea(dx,dy))continue;
                        if (visited[node.can][dx][dy])continue;
                        q.add(new Node(dx, dy, node.cnt+1, 1));
                    }
                }
                continue;
            }
            //벽이 아닐때
            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];
                if (!isArea(dx,dy))continue;
                if (visited[node.can][dx][dy])continue;
                q.add(new Node(dx, dy, node.cnt+1, node.can));
            }
        }
        System.out.println(ans);
    }



    static boolean isArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}
class Node{

    int x;
    int y;
    int cnt;
    int can;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", cnt=" + cnt +
                ", can=" + can +
                '}';
    }

    public Node(int x, int y, int cnt, int can) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.can = can;
    }
}