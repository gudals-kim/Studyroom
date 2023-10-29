import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int N, M;
    static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());
        Node startNode = new Node(startX, startY, startD);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==0)visit[i][j]=true;
            }
        }
        process(startNode, visit);
        System.out.println(ans);
    }
    static void process(Node node, boolean[][] visit){
        if (visit[node.x][node.y]){
            ans++;
            visit[node.x][node.y] = false;
        }
        int d = node.d;

        for (int i = 0; i < 4; i++) {
            d = d-1; //왼쪽으로 돌리기
            if (d<0) d=3; // 0미만이면 3부터 시작
            int dx = node.x + move[d][0];
            int dy = node.y + move[d][1];
            if (inArea(dx,dy)&&visit[dx][dy]){ // 청소를 할 수 있는 곳이 있는 경우
                process(new Node(dx,dy,d),visit); // 청소 로봇 현재 방향으로 보내고
                return;//리턴
            }
        }
        // 청소를 할 수 있는 곳이 없는경우
        int dx = node.x - move[node.d][0];
        int dy = node.y - move[node.d][1];
        if (!inArea(dx,dy)||map[dx][dy]==1) return; // 벽인경우는 작동 멈추기
        process(new Node(dx,dy,node.d),visit);
    }
    static boolean inArea(int dx, int dy){
        return dx >= 0 && dx < N && dy >= 0 && dy < M;
    }



}
class Node{
    int x;
    int y;
    int d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", d=" + d +
                '}';
    }
}