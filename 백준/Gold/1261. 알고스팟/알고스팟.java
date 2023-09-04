import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map;
    static final int INF = 99999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int[][] minDist = getMinDist(new Node(0, 0, 0));
        System.out.println(minDist[N-1][M-1]);


    }
    static int[][] getMinDist(Node startNode){
        int[][] minDist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minDist[i],INF);
        }
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        minDist[0][0] = 0;
        q.add(startNode);

        while (!q.isEmpty()){
            Node node = q.poll();
            if (visited[node.x][node.y])continue;
            visited[node.x][node.y] = true;

            if (node.x==N-1&&node.y==M-1) break;


            for (int[] mv : move) {
                int dx = mv[0] + node.x;
                int dy = mv[1] + node.y;
                if (!inArea(dx,dy)||visited[dx][dy]) continue;

                if (map[dx][dy]==1){//벽일 경우
                    if (minDist[dx][dy] <= minDist[node.x][node.y] + 1) continue;
                    minDist[dx][dy] = minDist[node.x][node.y] + 1;
                    q.add(new Node(dx,dy,minDist[dx][dy]));
                }else {//벽이 아닐 경우
                    if (minDist[dx][dy] < minDist[node.x][node.y]) continue;
                    minDist[dx][dy] = minDist[node.x][node.y];
                    q.add(new Node(dx,dy,minDist[dx][dy]));
                }
            }


        }
        return minDist;
    }
    static boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}
class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
