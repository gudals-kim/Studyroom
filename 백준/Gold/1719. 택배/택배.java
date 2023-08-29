import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static ArrayList[] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Terminal>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int leftNode = Integer.parseInt(st.nextToken())-1;
            int rightNode = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            graph[leftNode].add(new Terminal(rightNode, cost, leftNode));
            graph[rightNode].add(new Terminal(leftNode, cost, rightNode));
        }


        for (int startNode = 0; startNode < N; startNode++) {
            int[][] getMinDist = getMinDistArr(new Terminal(startNode, 0, startNode));

            for (int endNode = 0; endNode < N; endNode++) {
                if (startNode==endNode) {
                    sb.append("-").append(" ");
                    continue;
                }
                sb.append(getFirstVisitNode(getMinDist, startNode, endNode)+1).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb);


    }
    //노드 역추적 메소드
    static int getFirstVisitNode(int[][] getMinDist, int start, int end){
        int path = end;
        while (getMinDist[path][1]!=start){
            path = getMinDist[path][1];
        }
        return path;
    }


    static int[][] getMinDistArr(Terminal startNode){
        int[][] getMinDist = new int[N][2];
        for (int i = 0; i < N; i++) {
            getMinDist[i] = new int[]{Integer.MAX_VALUE, startNode.index};
        }

        getMinDist[startNode.index][0] = 0;
        boolean[] visited = new boolean[N];
        PriorityQueue<Terminal> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(startNode);

        while (!q.isEmpty()){

            Terminal node = q.poll();
            if (visited[node.index]) continue;
            visited[node.index] = true;

            ArrayList<Terminal> nextNodes = graph[node.index];
            for (Terminal nextNode : nextNodes) {
                if (getMinDist[nextNode.index][0] > getMinDist[node.index][0]+nextNode.cost){
                    getMinDist[nextNode.index][0] = getMinDist[node.index][0]+nextNode.cost;
                    getMinDist[nextNode.index][1] = node.index;
                    q.add(new Terminal(nextNode.index, getMinDist[nextNode.index][0], getMinDist[nextNode.index][1]));
                }
            }
        }
        return getMinDist;
    }




}
class Terminal{
    int index;
    int cost;
    int preNode;
    public Terminal(int index, int cost, int preNode) {
        this.index = index;
        this.cost = cost;
        this.preNode = preNode;
    }
}
