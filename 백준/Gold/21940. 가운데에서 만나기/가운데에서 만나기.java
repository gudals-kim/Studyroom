import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int N, M;
    static ArrayList[] graph;
    static int[][] minDistAll;
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,t));
        }

        int K = Integer.parseInt(br.readLine());
        int[] city = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            city[i] = Integer.parseInt(st.nextToken())-1;
        }

        int max = INF;
        minDistAll = getMinDistAll();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int end = 0; end < N; end++) {
            int temp = 0;
            for (int start : city) {
                if (end==start) continue;
                temp = Math.max(temp, minDistAll[start][end] + minDistAll[end][start]);
            }
            if (max>temp){
                max = temp;
                ans = new ArrayList<Integer>();
                ans.add(end);
            }else if (max==temp){
                ans.add(end);
            }
        }
        Collections.sort(ans);
        for (Integer i : ans) {
            sb.append(i+1).append(" ");
        }
        System.out.println(sb);
    }
    static int[][] getMinDistAll(){
        int[][] minDist = new int[N][N];
        for (int i = 0; i < N; i++) {
            minDist[i] = getMinDist(new Node(i, 0));
//            System.out.println("minDist["+i+"] = " + Arrays.toString(minDist[i]));
        }
        return minDist;
    }
    
    static int[] getMinDist(Node startNode){
        int[] minDist = new int[N];
        Arrays.fill(minDist, INF);

        minDist[startNode.index] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(startNode);
        while (!q.isEmpty()){
            Node node = q.poll();

            if (node.cost > minDist[node.index]) continue;
            ArrayList<Node> nextNodes = graph[node.index];
            for (Node nextNode : nextNodes) {
                if (minDist[nextNode.index] > nextNode.cost+minDist[node.index]){
                    minDist[nextNode.index] = nextNode.cost+minDist[node.index];
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


    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}