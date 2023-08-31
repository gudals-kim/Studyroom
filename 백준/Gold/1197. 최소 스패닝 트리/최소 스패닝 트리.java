import java.io.*;
import java.util.*;
public class Main {
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Eg[] edgeArr = new Eg[E];

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int leftNode = Integer.parseInt(st.nextToken())-1;
            int rightNode = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            edgeArr[e] = new Eg(leftNode, rightNode, cost);
        }

        Arrays.sort(edgeArr, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        int[] getParent = new int[V];
        for (int i = 0; i < V; i++) {
            getParent[i] = i;
        }
        int ans = 0;
        for (Eg eg : edgeArr) {
            if (union(getParent, eg.leftNode, eg.rightNode))continue;
            ans+= eg.cost;
        }
        System.out.println(ans);

    }
    static int find(int[] arr, int i){
        if (arr[i]==i) return i;
        return arr[i] = find(arr, arr[i]);
    }
    static boolean union(int[] arr, int a, int b){
        int pA = find(arr, a);
        int pB = find(arr, b);
        if (pA==pB) return true;
        arr[pA] = pB;
        return false;
    }
}
class Eg{
    int leftNode;
    int rightNode;
    int cost;

    public Eg(int leftNode, int rightNode, int cost) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.cost = cost;
    }
}
