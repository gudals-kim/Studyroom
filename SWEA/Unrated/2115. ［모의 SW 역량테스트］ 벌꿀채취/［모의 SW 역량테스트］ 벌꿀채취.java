import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, C, plusHoney, ans;
    static int[][] map;
    static ArrayList<Node> nodes;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 맵 크기
            M = Integer.parseInt(st.nextToken()); // 연속되는 수의 크기
            C = Integer.parseInt(st.nextToken()); // M개의 연속되는 배열의 수들의 합이 넘으면 안되는 수
            map = new int[N][N];
            nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (j<N-M+1) nodes.add(new Node(i,j));
                }
            }
            // N*N 의 크기를 가진 배열 중
            // M개의 연속하는 부분 집합의 합이 C를 넘지 않는 가장 큰 수 구하고
            // 가장 큰 수를 가진 조합 2개를 골라라 -> 수가 겹치면 안돼
            ans = 0;
            comb(nodes.size(),2,0,0,0,0,0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    // 2개 조합을 뽑을거임
    static void comb(int n, int r, int pickX, int pickY,int start, int cnt, int sum){
        if (cnt==r){
            ans = Math.max(ans, sum);
//            System.out.println("ans = > "+ ans);
            return;
        }
        for (int i = start; i < n; i++) {
            Node node = nodes.get(i);
            int dx = node.x;
            int dy = node.y;
            if (dx==pickX && dy<pickY)continue;
//            getMaxNumber(dx, dy, dy+M,0, 0);
            //모든 중복조합 구하기
            plusHoney = 0;
            for (int r2 = 1; r2 <= M; r2++) {
                comb2(dy+M, r2, 0, dx, dy, 0, 0);
            }
//            System.out.println("dx, dy = " + dx+", "+ dy);
//            System.out.println(plusHoney);
            comb(n, r, dx,dy+M,start+1,cnt+1,sum+plusHoney);

        }
    }

    // 연속하는 M 개의 수 중 C를 넘지않는 최대 합을 구하는 메서드
    static void getMaxNumber(int x, int y, int limit, int sum, int result){
        if (C<sum){
            return;
        }
        plusHoney = Math.max(plusHoney, result);
        for (int i = y; i < limit; i++) {
//            System.out.println("sum(" +sum+" )+map["+x+"]["+i+"]= "+(sum+map[x][i]));
            getMaxNumber(x,y+1, limit,sum+map[x][i], result+(map[x][i]*map[x][i]));
        }
    }
    static void comb2(int n, int r, int cnt, int x, int y, int sum, int result){
        if (sum>C) return;
        if (cnt==r){
            plusHoney = Math.max(plusHoney, result);
            return;
        }
        for (int i = y; i < n; i++) {
            comb2(n,r,cnt+1,x,i+1,sum+map[x][i], result+(map[x][i]*map[x][i]));
        }

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
