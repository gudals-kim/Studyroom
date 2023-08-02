import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로길이
            int N = Integer.parseInt(st.nextToken()); // 세로길이
            int K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치 개수
            // X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)

            ArrayDeque<Node> queue = new ArrayDeque<>();
            boolean[][] isIn = new boolean[N][M];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                //배추가 있는 좌표 노드 생성 후 queue에 저장
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                queue.add(new Node(x,y));
                isIn[y][x] = true;
            }


            //옆으로 이동할 배열 생성
            int[][] move = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
            int ans = 0; // 답이 들어갈거임
            while (!queue.isEmpty()) {
                Node firstNode = queue.poll();
                if (!isIn[firstNode.y][firstNode.x]) continue;

                ArrayDeque<Node> stack = new ArrayDeque<>();
                stack.add(firstNode);

                while (!stack.isEmpty()){
                    Node node = stack.pollLast();
                    //방문 했으니 체크
                    isIn[node.y][node.x]=false;

                    //인접 노드로 이동
                    for (int[] mv : move) {
                        int dx = mv[0]+node.x;
                        int dy = mv[1]+node.y;

                        //이동한 곳이 범위를 벗어나거나, 배추가 심어져 있지 않은 곳이라면 넘어감
                        if (dx < 0 || dx >= M || dy < 0 || dy >= N || !isIn[dy][dx]){
                            continue;
                        }
                        //배추가 존재하는 경우는 이동해야하니 스택에 넣는다.
                        stack.add(new Node(dx,dy));
                    }
                }
                ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
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