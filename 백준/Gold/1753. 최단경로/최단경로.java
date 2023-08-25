
import java.io.*;
import java.util.*;
public class Main {

    static int V, E, startNodeIdx;
    static ArrayList[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken())+1;
        E = Integer.parseInt(st.nextToken());
        startNodeIdx = Integer.parseInt(br.readLine());


        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[node].add(new Nod(nextNode, cost));
        }
        int[] minDist = getMinDist(new Nod(startNodeIdx, 0));
        for (int i = 1; i < V; i++) {
            if (minDist[i]== Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(minDist[i]).append("\n");
        }
        System.out.println(sb);
    }
    static int[] getMinDist(Nod startNode){

        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[startNode.num] = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Nod> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(startNode);

        while (!q.isEmpty()){
            Nod node = q.poll();
            if (visited[node.num]) continue;
            visited[node.num] = true;

            ArrayList<Nod> nextNodes = graph[node.num];
            for (Nod nextNode : nextNodes) {
                if (minDist[nextNode.num]>minDist[node.num]+ nextNode.cost){
                    minDist[nextNode.num] = minDist[node.num]+ nextNode.cost;
                    q.add(new Nod(nextNode.num, minDist[nextNode.num]));
                }
            }
        }
        return minDist;
    }
}
class Nod{
    int num;
    int cost;

    public Nod(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}
