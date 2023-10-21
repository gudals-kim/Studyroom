import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 총 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int startNode = Integer.parseInt(st.nextToken())-1; // 해킹당한 컴퓨터 번호 (시작 노드)
            ArrayList[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Node>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }
            ans = -1;
            int chk = 0;
            int[] minDist = getMinDist(startNode, graph);
            for (int i = 0; i < n; i++) {
                if (minDist[i]==Integer.MAX_VALUE) continue;
                chk ++;
                ans = Math.max(ans,minDist[i]);
            }

            sb.append(chk).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
    static int[] getMinDist(int startNode, ArrayList[] graph){
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[startNode] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Node(startNode,0));
        while (!q.isEmpty()){
            Node node = q.poll();

            if (minDist[node.index] < node.cost) continue;

            ArrayList<Node> nextNodes = graph[node.index];
            for (Node nextNode : nextNodes) {
                if (minDist[nextNode.index] > nextNode.cost + minDist[node.index]){
                    minDist[nextNode.index] = nextNode.cost + minDist[node.index];
                    q.add(new Node(nextNode.index, minDist[nextNode.index]));
                }
            }

        }
        return minDist;
    }

}
class Node{
    int index;
    int cost;

    public Node(int index,  int cost) {
        this.index = index;
        this.cost = cost;
    }
}
