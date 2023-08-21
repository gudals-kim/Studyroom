
import java.io.*;
import java.util.*;
public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Nd> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        q.addFirst(new Nd(N,0));
        while (!q.isEmpty()){
            Nd node = q.pollLast();
            if (node.idx==K) {
                ans = node.cost;
                break;
            }
            if (visited[node.idx]) continue;
            visited[node.idx] = true;
            Nd[] nextNodes = getNextNodes(node);
            for (Nd nextNode : nextNodes) {
                if (nextNode.idx<0||nextNode.idx>100000||visited[nextNode.idx]) continue;
                q.addFirst(nextNode);
            }
        }
        System.out.println(ans);
    }
    static Nd[] getNextNodes(Nd node){
        Nd[] nextNodes = { new Nd(node.idx - 1, node.cost+1), new Nd(node.idx + 1, node.cost+1), new Nd(node.idx*2, node.cost+1)};
        return nextNodes;
    }
}
class Nd{
    int idx;
    int cost;

    public Nd(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

