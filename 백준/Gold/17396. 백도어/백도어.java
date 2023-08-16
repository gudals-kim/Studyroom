
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] canMove;
    static ArrayList<Node>[] graph;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//노드 수
        M = Integer.parseInt(st.nextToken());//간선 수

        //갈 수 있는 노드인지 판단하는 배열 생성
        canMove = new boolean[N];//idx=노드 번호를 가진 노드에 갈 수 있는지 판단.
        st = new StringTokenizer(br.readLine());
        canMove[N-1] = true; // 넥서스는 무조건 갈 수 있음
        for (int n = 0; n < N-1; n++) {
            int code = Integer.parseInt(st.nextToken());
            if (code==0){
                canMove[n] = true;
            }
        }

        //그래프 생성
        // 갈 수 있는 노드를 가리키는 곳만 그래프에 추가한다.
        graph = new ArrayList[N];
        for (int n = 0; n < N; n++) {
            graph[n] = new ArrayList<Node>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            Long cost = Long.parseLong(st.nextToken());
            if (canMove[nextNode]){
                graph[node].add(new Node(nextNode, cost));
            }
            if (canMove[node]){
                graph[nextNode].add(new Node(node, cost));
            }
        }

        //최소거리 탐색
        Long[] getMinDist = dijkstra(new Node(0, 0L));
        if (getMinDist[N-1]==Long.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(getMinDist[N-1]);
        }
    }
    static Long[] dijkstra(Node StartNode){
        //최소 거리를 저장할 배열
        Long[] dist = new Long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[StartNode.index] = 0L; //시작노드에서 시작 노드까지 가는 최소 거리는 0으로 초기화

        boolean[] visited = new boolean[N]; // 방문 체크 배열 생성

        //최소 힙 생성
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        queue.add(StartNode);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (visited[node.index]) continue; //방문 노드면 체크하지 않는다.

            visited[node.index] = true; // 방문체크
            ArrayList<Node> nextNodes = graph[node.index];// 연결되어 있는 다음 노드들
            //다음노드로 탐색
            for (Node nextNode : nextNodes) {
                //다음 노드에 저장된 거리 최소값이 현재 노드까지 거리 최솟값 + 다음노드까지 가는 거리 비용 보다 작다면
                if (dist[nextNode.index] > dist[node.index] + nextNode.cost){
                    dist[nextNode.index] = dist[node.index] + nextNode.cost;
                    queue.add(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }

        return dist;
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