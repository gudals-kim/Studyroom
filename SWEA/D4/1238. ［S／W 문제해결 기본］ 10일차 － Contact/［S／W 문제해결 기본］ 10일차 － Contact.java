
import java.util.*;
import java.io.*;
public class Solution {
    static int ans;
    static ArrayList[] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" "); // 출력 형식 맞추기
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[101];
            for (int i = 0; i < 101; i++) {
                graph[i] = new ArrayList<노드>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {
                int node = Integer.parseInt(st.nextToken());
                int nextNode = Integer.parseInt(st.nextToken());

                graph[node].add(new 노드(nextNode,0));
            }

            boolean[] visited = new boolean[101];
            ArrayList<노드> result = new ArrayList<>();
            ArrayDeque<노드> q = new ArrayDeque<>();
            q.add(new 노드(startNode,0));
            while (!q.isEmpty()){
                노드 node = q.poll();
                if (visited[node.index]) continue;
                visited[node.index] = true;

                ArrayList<노드> nextNodes = graph[node.index];
                for (노드 nextNode : nextNodes) {
                    if (visited[nextNode.index]) continue;
                    노드 다음노드 = new 노드(nextNode.index, node.depth + 1);
                    q.add(다음노드);
                    result.add(다음노드);
                }
            }
            Collections.sort(result, (o1, o2) -> {
                int compare = Integer.compare(o2.depth, o1.depth);
                if (compare==0){
                    return Integer.compare(o2.index, o1.index);
                }
                return compare;
            });

            sb.append(result.get(0).index);

            sb.append("\n"); // 출력형식 맞추기
        }
        System.out.println(sb);
    }
}
class 노드{
    int index;
    int depth;


    public 노드(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }
}