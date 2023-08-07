import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[][] isLink = new boolean[n][n];
        int[][] result = new int[n][n];
        for (int node = 0; node < n; node++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (Integer.parseInt(st.nextToken())==0)continue;
                isLink[node][nextNode] = true;
            }
        }
        ArrayDeque<Integer> queue;
        boolean[] visited;

        for (int startNode = 0; startNode < n; startNode++) {//모든 정점마다 탐색한다.
            // dfs
            queue = new ArrayDeque<>();
            visited = new boolean[n];
            queue.add(startNode);

            while (!queue.isEmpty()){
                int node = queue.poll();
                for (int nextNode = 0; nextNode < n; nextNode++) {//현재 노드에서 갈 수 있는 모든 노드를 탐색
                    if (isLink[node][nextNode] && !visited[nextNode]){//현재 노드에서 다음 노드가 연결되있고, 탐색하지 않은 노드라면
                        queue.add(nextNode);//다음 노드로 이동
                        visited[nextNode] = true;//방문 체크
                        result[startNode][nextNode] = 1;//시작노드에서 다음노드를 갈수 있으니 답에 추가
                    }
                }

            }
        }


        //출력
        for (int[] ints : result) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}