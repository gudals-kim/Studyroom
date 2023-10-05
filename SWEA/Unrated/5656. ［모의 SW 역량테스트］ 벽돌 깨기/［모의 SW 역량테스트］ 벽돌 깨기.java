import java.util.*;
import java.io.*;

class Solution{
    static int N,W,H, ans, boxN;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            ans = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j]>0) ans++;
                }
            }
            boxN = -1;
            //dfs
            dfs(0,0, map);

            sb.append(ans-boxN).append("\n");
        }
        System.out.println(sb);

    }

    /**
     *
     * @param cnt 상자를 때리는 횟수
     * @param sum 사라진 상자의 개수의 합
     * @param box 정렬된 상자
     */
    static void dfs(int cnt, int sum, int[][] box){
        if (cnt == N){
            boxN = Math.max(boxN, sum);
            return;
        }

        for (int i = 0; i < W; i++) {
            //i 는 때릴 y좌표
            //i 를 넣으면 상자가 사라지고, -> 사라진 상자 개수는 리턴됨
            //재 정렬이 된 새로운 박스들이 나오는 로직이 나와야함
            int[][] tempBox = getTempBox(box);
            int boxNum = getBox(i, tempBox);
            int[][] newBox = getNewBox(tempBox);
            dfs(cnt+1, sum+boxNum, newBox);
        }
    }
    static int[][] getTempBox(int[][] box){
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = box[i][j];
            }
        }
        return temp;
    }
    static int[][] getNewBox(int[][] box){
        //박스 내리는 로직
        int[][] temp = new int[H][W];
        for (int i = 0; i < W; i++) {
            int dx = H-1;
            for (int j = H-1; j >= 0; j--) {
                if (box[j][i]>0){
                    temp[dx--][i] = box[j][i];
                }
            }
        }
        return temp;
    }
    static int getBox(int y, int[][] box){
        int result = 0;
        //가장 상단의 박스를 찾아서 부시자!
        for (int x = 0; x < H; x++) {
            if (box[x][y]!=0){
                result+=boomBox(x,y,box);
                break;
            }
        }
        return result;
    }

    static int boomBox(int x, int y, int[][] box){
        int result = 1;
        if (box[x][y]==0) return 0;
        int boomPower = box[x][y];
        box[x][y] = 0;
        //상
        for (int dx = x-1; dx > x-boomPower; dx--) {
            if (dx<0) break;
            if (box[dx][y]>0)result+=boomBox(dx,y,box);
        }
        //하
        for (int dx = x+1; dx < x+boomPower; dx++) {
            if (dx>=H) break;
            if (box[dx][y]>0)result+=boomBox(dx,y,box);
        }
        //좌
        for (int dy = y-1; dy > y-boomPower; dy--) {
            if (dy<0) break;
            if (box[x][dy]>0)result+=boomBox(x,dy,box);
        }
        //우
        for (int dy = y+1; dy < y+boomPower; dy++) {
            if (dy>=W) break;
            if (box[x][dy]>0)result+=boomBox(x,dy,box);
        }
        return result;
    }
}