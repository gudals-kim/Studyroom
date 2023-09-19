import java.util.*;
import java.io.*;

class Solution {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node startNode = new Node(x, y, 0);
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Node endNode = new Node(x,y,0);


            sb.append(getMinDist(N,map, startNode, endNode)).append("\n");
        }
        System.out.println(sb);
    }
    static int getMinDist(int N, int[][] map, Node startNode, Node endNode){
        int[][] dist = new int[N][N];
        for (int[] ints : dist) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        dist[startNode.x][startNode.y] = 0;
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time,o2.time));
        q.add(startNode);

        while (!q.isEmpty()){
            Node node = q.poll();
            if (visit[node.x][node.y]) continue;
            visit[node.x][node.y] = true;

            for (int[] mv : move) {
                int dx = mv[0] + node.x;
                int dy = mv[1] + node.y;
                if (dx<0||dx>=N||dy<0||dy>=N||visit[dx][dy]||map[dx][dy]==1) continue;
                int needTime = getCost(map[dx][dy], dist[node.x][node.y]);
                if (dist[dx][dy] > dist[node.x][node.y] + needTime){
                    dist[dx][dy] = dist[node.x][node.y] + needTime;
                    q.add(new Node(dx,dy,dist[dx][dy]));
                }
            }
        }
        if (dist[endNode.x][endNode.y]==Integer.MAX_VALUE)return-1;
        return dist[endNode.x][endNode.y];
    }
    static int getCost(int comb, int cost){
        if (comb==2){
            int i = cost % 3;
            if (i==0) {
                return 3;
            }else if (i==1){
                return 2;
            }
        }
        return 1;
    }
}
class Node{
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}