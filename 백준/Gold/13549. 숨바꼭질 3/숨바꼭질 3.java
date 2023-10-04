import java.io.*;
import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N));

    }
    static int bfs(int startNode){
        int[] minDist = new int[100001];
        Arrays.fill(minDist, 100002);
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(startNode,0));
        while (!q.isEmpty()){
            Node node = q.poll();

            if (node.index<0||node.index>=100001||minDist[node.index]<=node.cost)continue;
            minDist[node.index] = node.cost;
//            System.out.println(node);
//            if (node.index>=2*K+1) break;
            Node[] nextNodes = {
                    new Node(node.index+1,minDist[node.index]+1),
                    new Node(node.index-1,minDist[node.index]+1),
                    new Node(node.index*2, minDist[node.index])
            };
            for (Node nextNode : nextNodes) {
                if (nextNode.index<0||nextNode.index>=100001||minDist[nextNode.index]<=nextNode.cost)continue;
                q.add(nextNode);
            }

        }
        return minDist[K];
    }


}
class Node{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", cost=" + cost +
                '}';
    }
}