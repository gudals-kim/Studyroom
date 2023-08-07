import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        // 그래프 생성
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Node>();
        }
        //그래프 연결
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken())-1;
            int nextNode = Integer.parseInt(st.nextToken())-1;
            graph[node].add(new Node(nextNode, 1));
            graph[nextNode].add(new Node(node, 1));
        }
        //답안 출력 맞춰주기
        int[][] ans = new int[N][2];
        for (int node = 0; node < N; node++) {
            int[] dijkstra = dijkstra(node, N); // 모든 노드에 대해 최단거리를 찾는다.
            int sum = 0;
            for (int cost : dijkstra) { //모든 시작노드에서 각 노드까지의 거리 합을 구해서
                sum+=cost;
            }
            ans[node][0] = node; //답 배열에 노드와
            ans[node][1] = sum; //합을 저장한다.
        }
        Arrays.sort(ans,(o1, o2) -> { //가장 작은 cost 합, 적은 번호를 찾아야하기 때문에 정렬
            if (Integer.compare(o1[1],o2[1])==0) return Integer.compare(o1[0],o2[0]);
            return Integer.compare(o1[1],o2[1]);
        });
        System.out.println(ans[0][0]+1); // 출력 (index였기 때문에 1추가)
    }
    static int[]  dijkstra(int start, int n){
        boolean[] isChk = new boolean[n];// 방문 체크 배열
        int[] dist = new int[n]; // 시작노드로부터 각 노드(인덱스)까지의 최소거리 배열
        Arrays.fill(dist,Integer.MAX_VALUE); //모든 최소거리를 무한대로 초기화

        dist[start] = 0; //시작노드에서 시작노드까지의 거리는 0으로 초기화
        PriorityQueue<Node> queue = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(start,0));//최소 힙에 첫 시작 노드 추가

        while(!queue.isEmpty()){
            Node node = queue.poll();//현재노드

            //현재노드가 이미 방문한 노드라면 제낀다.
            if (isChk[node.index]) continue;
            //방문하지 않은 노드라면 방문처리 해준다.
            isChk[node.index]=true;
            ArrayList<Node> nextNodes = graph[node.index];
            for (Node nextNode : nextNodes) {
                //시작 노드로 부터 다음 노드까지의 현재까지 저장된 최소거리가
                //시작 노드부터 현재 노드까지의 최소거리 + 현재 노드에서 다음 노드까지의 거리 보다 크면
                //더 최단거리를 저장한다.
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
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}