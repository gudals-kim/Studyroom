import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr;
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //왼쪽으로 간 뒤 처리임 -> y 좌표 기준임
        Node leftAlpha = new Node(0, -1, 0);
        Node[] left = new Node[]{
            new Node(-1,0,7),// 위
            new Node(1,0,7),//아래
            new Node(-2,0,2),//제일 위
            new Node(2,0,2),//제일 아래
            new Node(-1,1,1),//오른쪽 위 대각
            new Node(1,1,1),//오른쪽 아래 대각
            new Node(-1,-1,10),//왼쪽 위 대각
            new Node(1,-1,10), //왼쪽 아래 대각
            new Node(0,-2,5)//제일 왼쪽
        };
        Node rightAlpha = new Node(0, 1, 0);
        Node[] right = new Node[]{
                new Node(-1,0,7),// 위
                new Node(1,0,7),//아래
                new Node(-2,0,2),//제일 위
                new Node(2,0,2),//제일 아래
                new Node(-1,1,10),//오른쪽 위 대각
                new Node(1,1,10),//오른쪽 아래 대각
                new Node(-1,-1,1),//왼쪽 위 대각
                new Node(1,-1,1), //왼쪽 아래 대각
                new Node(0,2,5)//제일 오른쪽
        };
        Node upAlpha = new Node(-1, 0, 0);
        Node[] up = new Node[]{
                new Node(-2,0,5),//제일 위
                new Node(1,1,1),//오른쪽 아래 대각선
                new Node(1,-1,1),//왼쪽 아래 대각선
                new Node(0,-1,7),//왼쪽
                new Node(0,1,7),//오른쪽
                new Node(0,-2,2),//제일 왼쪽
                new Node(0,2,2),//제일 오른쪽
                new Node(-1,-1,10),//왼쪽 위 대각
                new Node(-1,1,10)//오른쪽 위 대각
        };
        Node downAlpha = new Node(1, 0, 0);
        Node[] down = new Node[]{
                new Node(2,0,5),//제일 아래
                new Node(1,1,10),//오른쪽 아래 대각선
                new Node(1,-1,10),//왼쪽 아래 대각선
                new Node(0,-1,7),//왼쪽
                new Node(0,1,7),//오른쪽
                new Node(0,-2,2),//제일 왼쪽
                new Node(0,2,2),//제일 오른쪽
                new Node(-1,-1,1),//왼쪽 위 대각
                new Node(-1,1,1)//오른쪽 위 대각
        };

        int x = N/2;// 시작 X
        int y = N/2;// 시작 Y
        int maxCnt = N*N-1; //전체 이동 횟수
        int cnt = 0; //현재 이동 횟수
        int lenX = 1; //X 세로이동횟수 [1->2->3->4->..(N-1)]
        int lenY = 1; //Y 가로이동횟수 [1->2->3->4->..(N-1)]
        while (cnt<maxCnt){

            //왼쪽이동
            for (int i = 0; i < lenY && cnt<maxCnt; i++) {
                y--;//이동
                calculator(x,y,left,leftAlpha);//모래 이동 계산
                cnt++;
            }
            lenY++;
            //아래이동
            for (int i = 0; i < lenX && cnt<maxCnt; i++) {
                x++;//이동
                calculator(x,y,down,downAlpha);
                cnt++;
            }
            lenX++;
            //오른쪽 이동
            for (int i = 0; i < lenY && cnt < maxCnt; i++) {
                y++;
                calculator(x,y,right,rightAlpha);
                cnt++;
            }
            lenY++;
            //위 이동
            for (int i = 0; i < lenX && cnt < maxCnt; i++) {
                x--;
                calculator(x,y,up,upAlpha);
                cnt++;
            }
            lenX++;
        }
        System.out.println(ans);
    }


    //모래가 날려진 좌표들(상하좌우)과, alpha(상하좌우) 좌표를 넣으면 계산해준다.
    static void calculator(int x, int y, Node[] move, Node alpha){
        int cost = arr[x][y];//현재 좌표의 모래양
        arr[x][y] = 0;
        int moveCost = 0;
        if (cost==0) return; //모래량이 0이면 수행 필요없음
        for (Node nextNode : move) {
            int dx = x+nextNode.x;
            int dy = y+nextNode.y;
            int addCost = (int)( cost * (nextNode.cost * 0.01));//이동할 모래 계산
            moveCost += addCost; //alpha 계산을 위한 합
            //범위 내일때
            if (dx>=0&&dx<N&&dy>=0&&dy<N){
                arr[dx][dy] += addCost; //모래 이동
                continue;
            }
            //범위 밖일땐 답 변수에 이동된 모래 추가.
            ans+=addCost;
        }
        //alpha 계산
        int dx = x+alpha.x;
        int dy = y+alpha.y;
        int alphaCost = cost - moveCost;
        //범위 내일땐
        if (dx>=0&&dx<N&&dy>=0&&dy<N) {
            arr[dx][dy] += alphaCost;//a 좌표에 답을 넣어준다.
        }
        else {// 범위 밖일땐
            ans += alphaCost; //답에 추가해준다.
        }
    }

}
class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}