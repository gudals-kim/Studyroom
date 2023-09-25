import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N, M;
    static ArrayList<Node> startNodes, space;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        startNodes = new ArrayList<>();
        space = new ArrayList<>();

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num==0) space.add(new Node(i,j));
                if (num==1) visited[i][j] = true;
                if (num==2) startNodes.add(new Node(i,j));
            }
        }

        comb(space.size(),3,0,0,new Node[3]);
        System.out.println(ans);


    }
    static boolean[][] getVisited(Node[] combCase){
        boolean[][] temp = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = visited[i].clone();
        }
        for (Node node : combCase) {
            temp[node.x][node.y] = true;
        }
        return temp;
    }
    static void comb(int n, int r, int start, int cnt, Node[] combCase){
        if (cnt==r){
            boolean[][] tempVisit = getVisited(combCase);
            int temp = 0;
            for (Node startNode : startNodes) {
                bfs(startNode, tempVisit);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j])continue;
                    temp+=bfs(new Node(i,j),tempVisit);
                }
            }
            ans = Math.max(temp,ans);
            return;
        }
        for (int i = start; i < n; i++) {
            combCase[cnt] = space.get(i);
            comb(n,r,i+1,cnt+1,combCase);
        }
    }
    static int bfs(Node startNode, boolean[][] visit){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(startNode);
        int cnt = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            if (visit[node.x][node.y])continue;
            visit[node.x][node.y] = true;
            cnt++;
            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];
                if (notInArea(dx,dy)||visited[dx][dy]) continue;
                q.add(new Node(dx,dy));
            }
        }
        return cnt;
    }
    static boolean notInArea(int x, int y){
        return (x<0 || x>=N || y<0 || y>=M);
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
