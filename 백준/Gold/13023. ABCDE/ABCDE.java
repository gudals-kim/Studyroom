

import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static ArrayList[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (graph[node1]==null){
                graph[node1] = new ArrayList<Integer>();
            }
            if (graph[node2]==null){
                graph[node2] = new ArrayList<Integer>();
            }

            graph[node1].add(node2);
            graph[node2].add(node1);

        }
        int ans = 0;
        for (int node = 0; node < N; node++) {
            if (dfs(node, new boolean[N], 0)) {
                ans = 1;
                break;
            }
        }
        System.out.println(ans);
    }
    static boolean dfs(int node, boolean[] visited, int cnt){
        if (cnt==5){
            return true;
        }

        ArrayList<Integer> nextNodes = graph[node];
        if (graph[node]==null) return false;
        for (Integer nextNode : nextNodes) {
            if (visited[nextNode]) continue;
            visited[nextNode] = true;
            if (dfs(nextNode, visited, cnt+1)) return true;
            visited[nextNode] = false;
        }
        return false;
    }

}
