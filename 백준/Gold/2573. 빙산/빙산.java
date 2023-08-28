import java.io.*;
import java.util.*;


public class Main {
     static int N, M;
     static int[][] map;
     static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 맵의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 맵의 가로 크기
        map = new int[N][M];// 맵 생성
        ArrayList<Ice> ices = new ArrayList<>(); // 빙산들
        //입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]!=0){
                    ices.add(new Ice(i,j, map[i][j]));
                }
            }
        }
        //입력 받기 끝

        int year = 0; // 몇년이 지났는지 체크
        boolean isDiv = false; // 빙산이 나눠졌는지 체크
        while (ices.size()!=0){
            if (chk(ices)){//빙산의 덩어리가 나눠졌다면
                isDiv = true;// 나눠졌다 체크하고 
                break; // 탈출
            }

            year++;// 년도를 증가시킨 후
            ices = yearLater(ices); //빙산이 녹은 후 맵 업데이트 및 빙산 업데이트
        }
        
        if (isDiv){//빙산이 나눠졌다면
            System.out.println(year); // 연도 출력
        }else {
            System.out.println(0); // 빙산이 나눠지지 않았다면 0 출력
        }


    }
    //빙산이 나눠졌는지 체크하는 메소드
    static boolean chk(ArrayList<Ice> ices){
        boolean[][] visited = new boolean[N][M];
        int n = 0;
        for (Ice ice : ices) {
            if (visited[ice.x][ice.y]) continue;
            visited = bfs(ice, visited);
            n++;
            if (n>1){//bfs 가 한번 이상 돌았다면 빙산이 나눠진것임
                return true;
            }
        }
        //bfs 가 한번만 돌았다면 빙산이 나눠지지 않은것임
        return false;
    }
    //빙산 좌표를 넣으면 연결된 빙산을 탐색하는 bfs 메소드
    static boolean[][] bfs(Ice startNode, boolean[][] visited){
        ArrayDeque<Ice> q = new ArrayDeque<>();
        q.add(startNode);
        while (!q.isEmpty()){
            Ice ice = q.poll();
            if (visited[ice.x][ice.y]) continue;
            visited[ice.x][ice.y] = true;
            for (int[] mv : move) {
                int dx = mv[0] + ice.x;
                int dy = mv[1] + ice.y;
                if (isArea(dx,dy)&&!visited[dx][dy]&&map[dx][dy]!=0){
                    q.add(new Ice(dx,dy,map[dx][dy]));
                }
            }
        }
        return visited;

    }
    
    // 1년 뒤 빙산 맵을 만드는 메소드 -> 리턴값은 빙산 리스트
    static ArrayList<Ice> yearLater(ArrayList<Ice> ices){
        ArrayList<Ice> temp = new ArrayList<>();
        ArrayList<Ice> result = new ArrayList<>();
        //모든 빙산 마다 바다가 얼마나 붙어 있는지 탐색한 뒤 녹은 뒤의 빙산객체를 만든다.
        for (Ice ice : ices) {
            int meltTime = 0;
            for (int[] mv : move) {//각 상하좌우 마다
                int dx = mv[0] + ice.x;
                int dy = mv[1] + ice.y;
                if (isArea(dx,dy)&&map[dx][dy]==0){ //맵 범위 내이면서 높이가 0인 것을 체크한다.
                    meltTime++;
                }
            }
            ice.height -= meltTime;
            if (ice.height<0){
                ice.height = 0;
            }
            temp.add(ice);
        }
        //녹은 뒤의 빙산 객체를 맵에 업데이트 해준다.
        for (Ice ice : temp) {
            map[ice.x][ice.y] = ice.height;
            if (ice.height>0){
                result.add(ice);
            }
        }
        return result;
    }
    
    //맵의 범위 내인지 체크하는 메소드
    static boolean isArea(int x, int y){
        return (x>=0&&x<N&&y>=0&&y<M);
    }

}
class Ice{
    int x;
    int y;
    int height;

    public Ice(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}