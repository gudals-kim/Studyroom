import java.util.*;
import java.io.*;

class Solution{
    static int N,M, ans;
    static ArrayList[] graph, pre, post;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            graph = new ArrayList[N]; // 그래프
            pre = new ArrayList[N]; // 이전에 와야하는 애들
            post = new ArrayList[N]; // 이후에 와야하는 애들
            int[] inEdgeCnt = new int[N]; // 진입차수 기록
            
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<Integer>();
                pre[i] = new ArrayList<Integer>();
                post[i] = new ArrayList<Integer>();
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                graph[a].add(b); // 그래프 연결
                inEdgeCnt[b]++; // 진입차수 증가
            }

            // 위상정렬 시작
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                if (inEdgeCnt[i]==0){
                    q.add(i);//q에 진입차수가 0인 시작노드 넣기
                }
            }
            while (!q.isEmpty()){
                Integer node = q.poll();
                
                // bfs 돌면서 pre와 post 채우기
                bfs(node);

                // 그래프 연결 끊고 진입차수 줄여줄인 뒤 진입차수가 0인 노드 큐에 넣기
                ArrayList<Integer> nextNodes = graph[node];
                for (Integer nextNode : nextNodes) {
                    inEdgeCnt[nextNode]--;
                    if (inEdgeCnt[nextNode]<=0){
                        q.add(nextNode);
                    }
                }
            }
            // 위상정렬 끝

            ans = 0;
            for (int i = 0; i < N; i++) {
                if (pre[i].size()+post[i].size()==N-1){
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    static void bfs(int startNode){
        boolean[] visit = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(startNode);

        while (!q.isEmpty()){
            Integer node = q.poll();

            if (visit[node])continue;
            visit[node] = true;
            
            //pre와 post 채우기
            if (node!=startNode){
                pre[node].add(startNode);
                post[startNode].add(node);
            }

            ArrayList<Integer> nextNodes = graph[node];
            for (Integer nextNode : nextNodes) {
                if (visit[nextNode])continue;
                q.add(nextNode);
            }
        }
    }

}