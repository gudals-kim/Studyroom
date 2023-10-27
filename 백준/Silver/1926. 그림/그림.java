

import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int N, M;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[N][M];
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int comb = Integer.parseInt(st.nextToken());
                if (comb==0) visit[i][j] = true;
                else nodes.add(new Node(i,j));
            }
        }
        int cnt = 0;
        ans = 0;
        for (Node node : nodes) {
            if (visit[node.x][node.y]) continue;
            cnt ++;
            ans = Math.max(ans, bfs(node,visit));
        }
        System.out.println(cnt);
        System.out.println(ans);

    }
    static int bfs(Node startNode, boolean[][] visit){
        ArrayDeque<Node> q = new ArrayDeque<>();
        int result = 0;
        q.add(startNode);
        while (!q.isEmpty()){
            Node node = q.poll();
            if (visit[node.x][node.y])continue;
            visit[node.x][node.y]= true;
            result ++;
            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];
                if (dx>=N||dx<0||dy>=M||dy<0||visit[dx][dy]) continue;
                q.add(new Node(dx,dy));
            }
        }
        return result;
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
