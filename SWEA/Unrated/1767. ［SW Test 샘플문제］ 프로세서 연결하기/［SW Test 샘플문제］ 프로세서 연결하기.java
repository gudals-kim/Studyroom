import java.io.*;
import java.util.*;
public class Solution {
    static int N;
    static int[][] move = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] map;
    static int maxCore, minLength;
    static ArrayList<Core> cores;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());


            //입력 받기 start
            map = new int[N][N];
            cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i == 0 || j == 0 || i == N-1 || j == N-1)
                        // 가장가리에 있을때는 무조건 길이가 0이여야해
                        continue;
                    if(map[i][j] == 1)
                        cores.add(new Core(i,j));
                }
            }
            //입력 받기 end

            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;
            dfs(0,0,0);
            sb.append(minLength).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int coreNum, int coreCnt, int len){
        if (coreNum == cores.size()){//모든 코어를 다 선택했을때
            if (maxCore < coreCnt){ //선택된 코어 개수가 더 많을때
                maxCore = coreCnt;// 최대값 갱신
                minLength = len; //최소 길이 기준 갱신
            } else if (maxCore == coreCnt) {
                //가장 많은 코어 개수를 선택했을때 가장 전선이 짧은 때로 갱신한다.
                minLength = Math.min(minLength, len);
            }
            return;
        }
        //남은 코어가 있을때,

        int x = cores.get(coreNum).x;
        int y = cores.get(coreNum).y;

        //모든 4방향 탐색
        for (int pointer = 0; pointer < 4; pointer++) {
            int dx = x;
            int dy = y;
            int moveCnt = 0; // 이동횟수 저장

            while (true){
                dx += move[pointer][0];
                dy += move[pointer][1];
                // 벽을 만날 때 까지 ! -> 만난다면 전선 연결할 수 있음
                if (isWall(dx, dy)) break;
                // 전선을 만난다면
                if (map[dx][dy]==1){
                    moveCnt=0; // 전선을 벽까지 연결 할 수 없음
                    break;
                }
                moveCnt++; // 전선길이 증가
            }

            //전선이 연결된 경우
            if (moveCnt!=0) {
                int mx = x;
                int my = y;
                for (int i = 0; i < moveCnt; i++) {
                    mx += move[pointer][0];
                    my += move[pointer][1];
                    map[mx][my] = 1; //전선이 연결되었으면 map에 갱신한다
                }
                //다음 코어로 이동한다.
                dfs(coreNum+1, coreCnt+1, len + moveCnt);
                mx = x;
                my = y;

                //dfs가 끝난뒤에는 연결된 map를 0으로 바꿔줘야함
                // -> 분기점이 다름. 다른 전선을 연결할거임
                for (int i = 0; i < moveCnt; i++) {
                    mx += move[pointer][0];
                    my += move[pointer][1];
                    map[mx][my] = 0;
                }
            }else {
                //전선과 연결할 수 없을때는 코어만 바꾸어주고 코어개수와 길이를 증가 및 갱신하지 않는다.
                dfs(coreNum+1, coreCnt, len);
            }
        }
    }
    static boolean isWall(int x, int y){
        return (x < 0 || x >= N || y < 0 || y >= N);
    }
}
class Core{
    int x;
    int y;

    public Core(int x, int y) {
        this.x = x;
        this.y = y;
    }
}