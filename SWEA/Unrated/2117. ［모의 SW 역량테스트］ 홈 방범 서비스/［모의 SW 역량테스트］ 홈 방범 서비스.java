import java.util.*;
import java.io.*;

class Solution {
    static int N, M, K, ans;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도시의 크기
            M = Integer.parseInt(st.nextToken()); // 집당 최대 비용
            map = new int[N][N];
            ArrayList<Node> homes = new ArrayList<>(); // 집좌표 리스트
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j]==1) homes.add(new Node(i,j)); //집인경우 집 리스트에 넣기
                }
            }

            ans = -1;
            //모든 좌표에서
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= N+1; k++) { // 모든 k의 범위에서
                        int temp = 0;
                        for (Node home : homes) {// 각 집까지 거리가 
                            if (isInSafeArea(home, i, j, k)) temp++;
                        }
                        if (temp * M >= (k * k) + ((k - 1) * (k - 1))) {
                            ans = Math.max(ans, temp);
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    static boolean isInSafeArea(Node home, int x, int y, int k){
        return (k>(Math.abs(home.x-x)+Math.abs(home.y-y)));
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