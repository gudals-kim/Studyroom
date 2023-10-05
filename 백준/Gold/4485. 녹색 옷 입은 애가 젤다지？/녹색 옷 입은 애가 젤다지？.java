import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] map;
    static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int t = 1;
        while (N!=0){
            sb.append("Problem ").append(t++).append(": ");
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] minDist = getMinDist(new Node(0, 0, map[0][0]));
            sb.append(minDist[N-1][N-1]).append("\n");

            N = Integer.parseInt(br.readLine());
        }


        System.out.println(sb);
    }
    static int[][] getMinDist(Node startNode){
        int[][] minDist = new int[N][N];
        for (int[] ints : minDist) {
            Arrays.fill(ints, INF);
        }
        minDist[startNode.x][startNode.y] = map[startNode.x][startNode.y];
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(startNode);
        while (!q.isEmpty()){
            Node node = q.poll();

            if (visit[node.x][node.y]) continue;
            visit[node.x][node.y] = true;

            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];
                if (dx<0||dx>=N||dy<0||dy>=N||visit[dx][dy]) continue;
                if (minDist[dx][dy]<=minDist[node.x][node.y]+map[dx][dy])continue;
                minDist[dx][dy] = minDist[node.x][node.y]+map[dx][dy];
                q.add(new Node(dx,dy,minDist[dx][dy]));
            }

        }
        return minDist;
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

