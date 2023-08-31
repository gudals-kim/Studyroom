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


        //맵 입력 받기
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                int wall = input.charAt(j)-'0';
                if (wall==0){
                    map[i][j] = true;
                }
            }
        }
        //맵 입력 받기 끝

        //bfs 탐색
        boolean[][][] visited = new boolean[2][N][M];//드릴 사용 유무, 좌표 x, 좌표 y 가 들어간다.
        ArrayDeque<Node> q = new ArrayDeque<>();// bfs 에서 사용할 큐
        q.add(new Node(0, 0, 1, 0));// 시작 노드
        while (!q.isEmpty()){
            Node node = q.poll();//노드 뽑기

            if (!isArea(node.x, node.y)) continue;//영역 밖이면 탐색 x
            if (visited[node.can][node.x][node.y]) continue;//이미 방문한 노드 재 탐색 x
            visited[node.can][node.x][node.y] = true;// 방문 처리

            if (node.x==N-1&&node.y==M-1){//종료 조건
                ans = node.cnt;//bfs이기 때문에 가장 먼저 탐색 되었을때가 최저값이며 정답이다.
                break;
            }


            if (!map[node.x][node.y]) {//현재 노드가 벽일때,
                if (node.can==0){//벽을 뚫은 적이 없을때
                    for (int[] mv : move) {//사방탐색을 한다.
                        int dx = node.x + mv[0];
                        int dy = node.y + mv[1];
                        if (!isArea(dx,dy))continue;//다음 노드가 영역 밖이면 탐색 x
                        if (visited[node.can][dx][dy])continue; // 다음 노드가 탐색한 곳이라면 탐색 x
                        q.add(new Node(dx, dy, node.cnt+1, 1)); //(can 부분 1로 처리 -> 드릴 뚫었다는 처리) 다음 노드로
                    }
                }
                //벽이면서, 벽을 뚫은 적이 있다면 더이상 갈곳이 없다.
                continue;
            }
            //현재 노드가 벽이 아닐때는 사방탐색한다.
            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];
                if (!isArea(dx,dy))continue;//다음 노드가 영역 밖이면 탐색 x
                if (visited[node.can][dx][dy])continue;// 다음 노드가 탐색한 곳이라면 탐색 x
                q.add(new Node(dx, dy, node.cnt+1, node.can));
            }
        }
        //bfs 끝


        //
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