
import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] inEdgeCnt;
    static StringBuilder sb;
    static ArrayList[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//학생 수
        M = Integer.parseInt(st.nextToken());//키를 비교한 회수
        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        inEdgeCnt = new int[N+1];
        inEdgeCnt[0] = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int stuA = Integer.parseInt(st.nextToken());
            int stuB = Integer.parseInt(st.nextToken());
            inEdgeCnt[stuB]++;
            graph[stuA].add(stuB);
        }

        topologySort();
        System.out.println(sb);
    }
    static void topologySort(){
        //위상 정렬에 사용할 큐
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //진입 차수가 0인 모든 노드를 큐에 넣는다.
        for (int i = 1; i <= N; i++) {
            if (inEdgeCnt[i]==0){
                q.addLast(i);
            }
        }
        // 큐가 빌때 까지 반복한다.
        while (!q.isEmpty()){
            //큐에서 노드를 꺼낸다.
            Integer nodeNum = q.pollFirst();
            //그 노드를 적는다.
            sb.append(nodeNum).append(" ");
            //인접한 노드를 탐색한다.
            ArrayList<Integer> nextNodes = graph[nodeNum];
            for (Integer nextNode : nextNodes) {
                //이번 노드를 떼어 났으니 인접한 노드의 진입 차수를 1을 줄인다.
                inEdgeCnt[nextNode]--;
                if (inEdgeCnt[nextNode]==0){// 인접 노드의 진입 차수가 0이면
                    q.addLast(nextNode);//큐에 넣고 돌린다.
                }
            }
        }
        sb.append("\n");
    }
}