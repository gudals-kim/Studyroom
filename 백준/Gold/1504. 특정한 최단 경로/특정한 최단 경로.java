import java.io.*;
import java.util.*;
public class Main{

    static int N, E;
    static ArrayList[] graph;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//노드의 개수
        E = Integer.parseInt(st.nextToken());// 간선의 개수

        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            Long cost = Long.parseLong(st.nextToken());

            graph[node].add(new Node(nextNode, cost));
            graph[nextNode].add(new Node(node, cost));
        }
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        // 시작 -> f -> s -> 도착 간경우와 시작 -> s -> f -> 도착 경로와 비교해서 작은값 저장
        Long ans = Math.min(getAns(f, s),getAns(s,f));
        System.out.println(ans);
    }

    private static Long getAns(int f, int s) {
        Long[] minDist = getMinDist(new Node(1, 0L));
        Long[] minDistF = getMinDist(new Node(f, 0L));
        Long[] minDistS = getMinDist(new Node(s, 0L));
        if (minDist[f]==Long.MAX_VALUE){
            return -1L;
        }
        if (minDistF[s]==Long.MAX_VALUE){
            return -1L;
        }
        if (minDistS[N]==Long.MAX_VALUE){
            return -1L;
        }
        Long ans = minDist[f]+minDistF[s]+minDistS[N];
        return ans;
    }

    static Long[] getMinDist(Node startNode){
        Long[] minDist = new Long[N + 1]; // 시작 노드에서 각 노드까지의 최소 거리를 저장한다.
        Arrays.fill(minDist, Long.MAX_VALUE);

        minDist[startNode.index] = 0L;
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        q.add(startNode);

        while (!q.isEmpty()){

            Node node = q.poll();
            if (visited[node.index]) continue;
            visited[node.index] = true;

            ArrayList<Node> nextNodes = graph[node.index];
            for (Node nextNode : nextNodes) {

                if (minDist[nextNode.index]>minDist[node.index]+nextNode.cost&&!visited[nextNode.index]){
                    minDist[nextNode.index] = minDist[node.index] + nextNode.cost;
                    q.add(new Node(nextNode.index, minDist[nextNode.index]));
                }
            }
        }
        return minDist;
    }
}

class Node{
    int index;
    Long cost;

    public Node(int index, Long cost) {
        this.index = index;
        this.cost = cost;
    }
}