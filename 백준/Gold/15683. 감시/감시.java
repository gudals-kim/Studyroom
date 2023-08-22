
import java.io.*;
import java.util.*;
public class Main {

    static int N, M;
    static boolean[][] map;
    static int minAns = Integer.MAX_VALUE;
    static ArrayList<CCTV> cctves = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num==0){
                    map[i][j] = true;
                }
                if (1<=num&&num<=5){
                    cctves.add(new CCTV(i,j,num));
                    map[i][j] = true;
                }
            }
        }
        perm(4,cctves.size(),0,new int[cctves.size()]);
        System.out.println(minAns);

    }
    static int getBlindSpot(boolean[][] copyMap){
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
    static void runningCCTV(boolean[][] copyMap, CCTV cctv, int[][] moveArr){
        for (int[] mv : moveArr) {
            int dx = mv[0] + cctv.x;
            int dy = mv[1] + cctv.y;
            while (dx>=0&&dx<N&&dy>=0&&dy<M&&map[dx][dy]){
                copyMap[dx][dy] = false;
                dx += mv[0];
                dy += mv[1];
            }
        }
    }

    static boolean[][] getCopyMap(){
        boolean[][] result = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = map[i][j];
            }
        }
        for (CCTV cctv : cctves) {
            result[cctv.x][cctv.y] = false;
        }
        return result;
    }
    static void perm(int n, int r, int cnt, int[] result){
        if (cnt==r){
            boolean[][] copyMap = getCopyMap();
            for (int i = 0; i < r; i++) {
                CCTV cctv = cctves.get(i);
                int[][] moveArr = getMoveArr(cctv.num, result[i]);
                runningCCTV(copyMap, cctv, moveArr);
            }
            minAns = Math.min(minAns,getBlindSpot(copyMap));
            return;
        }
        for (int i = 0; i < n; i++) {
            result[cnt] = i;
            perm(n,r,cnt+1,result);
        }
    }
    //90도 방향 4번 할수있음 -> 0번 회전,1번 회전,2번 회전,3번 회전
    static int[][] getMoveArr(int num, int rotate){
        int [][] result = null;
        int[][] arr = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};


        if (num==1){
            result = new int[][] {arr[rotate%4]};//{1,0}, {0,-1}, {-1,0}
        }
        if (num==2){
            result = new int[][] {arr[rotate%4],arr[(rotate+2)%4]};//{{1,0},{-1,0}}
        }
        if (num==3){
            result = new int[][] {arr[rotate%4],arr[(rotate+3)%4]};
        }
        if (num==4){
            result = new int[][] {arr[rotate%4],arr[(rotate+2)%4],arr[(rotate+3)%4]};
        }
        if (num==5){
            result = new int[][] {arr[0],arr[1],arr[2],arr[3]};
        }

        return result;
    }
}

class CCTV{
    int x;
    int y;
    int num;

    public CCTV(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}