import java.io.*;
import java.util.*;

public class Main {
    
    static StringBuilder sb;
    static int N, M;
    static int[] inEdgeCnt;
    static ArrayList[] getNextNodes;
    static PriorityQueue[] getChildNode;
    static String[] getName, names;
    static HashMap<String, Integer> getIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        getIdx = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        getName = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            getName[i] = name;
        }
        Arrays.sort(getName);
        for (int i = 0; i < N; i++) {
            getIdx.put(getName[i], i);
        }

        inEdgeCnt = new int[N];
        getNextNodes = new ArrayList[N];
        getChildNode = new PriorityQueue[N];
        for (int i = 0; i < N; i++) {
            getNextNodes[i] = new ArrayList<Integer>();
            getChildNode[i] = new PriorityQueue<String>();
        }



        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Integer childIdx = getIdx.get(st.nextToken());
            Integer parentIdx = getIdx.get(st.nextToken());
            getNextNodes[parentIdx].add(childIdx);
            inEdgeCnt[childIdx]++;
        }
        topologySort();
        System.out.println(sb);
    }
    static void topologySort(){

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (inEdgeCnt[i]==0){
                q.addLast(i);
            }
        }
        sb.append(q.size()).append("\n");
        String[] temp = new String[q.size()];
        int tempIdx = 0;
        for (Integer integer : q) {
            temp[tempIdx++] = getName[integer];
        }
        Arrays.sort(temp);
        for (String s : temp) {
            sb.append(s).append(" ");
        }
        sb.append("\n");

        while (!q.isEmpty()){

            Integer nodeIdx = q.pollFirst();
            ArrayList<Integer> getNextNode = getNextNodes[nodeIdx];
            for (Integer nextNodeIdx : getNextNode) {
                inEdgeCnt[nextNodeIdx]--;
                if (inEdgeCnt[nextNodeIdx]==0){
                    getChildNode[nodeIdx].add(getName[nextNodeIdx]);
                    q.addLast(nextNodeIdx);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(getName[i]).append(" ").append(getChildNode[i].size()).append(" ");
            while (!getChildNode[i].isEmpty()){
                sb.append(getChildNode[i].poll()).append(" ");
            }
            sb.append("\n");
        }

    }
    
}
