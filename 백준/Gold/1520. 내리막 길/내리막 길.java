import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static int[][] dp;
    static int[][] move;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //세로의 크기
        N = Integer.parseInt(st.nextToken()); //가로의 크기
        // arr 초기화
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기화
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        move = new int[][]{{-1,0},{0,1},{0,-1},{1,0}}; //사방 탐색 초기화
        Node startNode = new Node(0,0);
        Node endNode = new Node(M-1,N-1);
        System.out.println(dfs(startNode,endNode));



    }
    static int dfs(Node node, Node endNode){
        if (node.x== endNode.x && node.y== endNode.y){
            return 1;
        }
        dp[node.x][node.y] = 0;

        for (int[] mv : move) {
            int dx = mv[0] + node.x;
            int dy = mv[1] + node.y;
            //다음 x,y가 범위를 벗어나거나, 현재 높이보다 높거나 같은 곳이라면 이동하지 않는다.
            if (dx<0||dx>=M||dy<0||dy>=N||arr[node.x][node.y]<=arr[dx][dy])continue;
            //이동 가능한 경우
            //이동할 좌표 처음 방문한 곳이라면
            if (dp[dx][dy] == -1) {
                dp[node.x][node.y] += dfs(new Node(dx,dy),endNode);
                continue;
            }
            //방문을 한적 있는경우는 
            dp[node.x][node.y] += dp[dx][dy];
        }
        return dp[node.x][node.y];
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
