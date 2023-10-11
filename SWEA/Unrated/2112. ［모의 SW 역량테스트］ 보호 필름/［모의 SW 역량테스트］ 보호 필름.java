
import java.util.*;
import java.io.*;

public class Solution {
    static int D, W, K, ans;
    static int[] aCells, bCells;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[][] map = new int[D][W];
            aCells = new int[W];
            bCells = new int[W];
            Arrays.fill(aCells, 0);
            Arrays.fill(bCells, 1);
            ans = 99999;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(map, 0, 0, new boolean[D]);

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int[][] map, int start, int change, boolean[] visit){
        if (isPass(map)){
            ans = Math.min(change, ans);
            return;
        }
        if (change>=ans) return;//이미 찾은 답보다 더 많이 바꾼다면 가지치기
        for (int i = start; i < D; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            int[] temp = map[i];

            //A 로 바꾸기
            map[i] = aCells;
            dfs(map, i+1,change+1, visit);
            //B 로 바꾸기
            map[i] = bCells;
            dfs(map, i+1,change+1, visit);

            map[i] = temp;
            visit[i] = false;
        }
    }

    static boolean isPass(int[][] cells){
        for (int w = 0; w < W; w++) {
            int count = 1;
            boolean fail = true;
            int preCell = cells[0][w];
            for (int d = 1; d < D; d++) {
                if (preCell==cells[d][w]) count++; // 전이랑 같다면 카운트
                else {//전이랑 다르다면
                    preCell = cells[d][w]; //이전값을 갱신하고
                    count = 1;//카운트 1로 초기화
                }
                if (count==K) {//만약 카운트가 K와 같다면
                    fail = false;//성공한것
                    break;//더 이상보지 않아도 됨
                }
            }
            if (fail) return false;//만약 실패했다면 무조건 실패임
        }
        //모두 완벽하게 돌았다면 성공임
        return true;
    }
}
