import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<Edge> edges = new HashSet<Edge>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int leftNode = Integer.parseInt(st.nextToken())-1;
            int rightNode = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(leftNode, rightNode, cost));
        }

        Edge[] edgesArr = edges.toArray(new Edge[edges.size()]);
        Arrays.sort(edgesArr, (o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int[] getParent = new int[N];
        for (int i = 0; i < N; i++) {
            getParent[i] = i;
        }
        int ans = 0;
        int maxCost = Integer.MIN_VALUE;
        for (int idx = 0; idx < edgesArr.length; idx++) {
            Edge edge = edgesArr[idx];
            if (isCycle(getParent,edge.leftNode,edge.rightNode))continue;
            maxCost = Math.max(maxCost, edge.cost);
            ans+=edge.cost;

        }
        System.out.println(ans-maxCost);
    }
    static int findParent(int[] getParent, int node){
        if (getParent[node] == node) return node;
        return getParent[node] = findParent(getParent, getParent[node]);
    }

    static boolean isCycle(int[] getParent, int leftNode, int rightNode){
        int parentLeft = findParent(getParent, leftNode);
        int parentRight = findParent(getParent, rightNode);
        if (parentLeft==parentRight) return true;
        getParent[parentLeft] = parentRight;
        return false;
    }
}
class Edge{
    int leftNode;
    int rightNode;
    int cost;

    @Override
    public String toString() {
        return "Edge{" +
                "leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (leftNode == edge.leftNode && rightNode == edge.rightNode && cost == edge.cost) || (leftNode == edge.rightNode && rightNode == edge.leftNode && cost == edge.cost);
    }

    @Override
    public int hashCode() {
        if (leftNode>rightNode){
            return Objects.hash(rightNode, leftNode, cost);
        }
        return Objects.hash(leftNode, rightNode, cost);
    }

    public Edge(int leftNode, int rightNode, int cost) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.cost = cost;
    }
}