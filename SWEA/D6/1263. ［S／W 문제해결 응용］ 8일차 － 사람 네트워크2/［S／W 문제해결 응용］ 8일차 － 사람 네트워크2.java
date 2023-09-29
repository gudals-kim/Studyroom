import java.io.*;
import java.util.*;

public class Solution {

    static int ans;
    static ArrayList[] graph;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<Integer>();
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(st.nextToken())==1)graph[i].add(j);
                }
            }
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                ans = Math.min(ans,getDist(i,N));
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static int getDist(int startNode, int N){
        int result = 0;
        boolean[] visit = new boolean[N];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(startNode,0));
        while (!q.isEmpty()){

            Node node = q.poll();
            if (visit[node.index])continue;
            visit[node.index] = true;
            result += node.depth;

            ArrayList<Integer> nextNodes = graph[node.index];
            for (Integer nextNode : nextNodes) {
                if (visit[nextNode]) continue;
                q.add(new Node(nextNode,node.depth+1));
            }

        }
        return result;
    }

}
class Node{
    int index;
    int depth;

    public Node(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }
}

