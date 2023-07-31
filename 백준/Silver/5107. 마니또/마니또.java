import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N==0) break;
            HashMap<String, Object[][]> graph = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                graph.put(st.nextToken(),new Object[][] {{1,st.nextToken()}});
            }
            int ans = 0;
            HashSet<HashSet<String>> set = new HashSet<HashSet<String>>();
            for (String s : graph.keySet()) {
                HashMap<String, Object[]> dijkstraMap = dijkstra(graph, s);
                HashSet<String> temp = new HashSet<>();
                for (String key2 : dijkstraMap.keySet()) {
                    if ((Integer) dijkstraMap.get(key2)[0]==Integer.MAX_VALUE) continue;
                    temp.add(key2);
                }
                set.add(temp);
            }
            sb.append(++testcase).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
    static HashMap<String, Object[]> dijkstra(HashMap<String,Object[][]> graph, String start){
        //시작 정점에서 각 정점까지의 거리를 저장할 map을 생성하고, 무한대로 초기화한다. (비교해서 더 짧은 거리를 추가함)
        HashMap<String, Object[]> distanceMap = new HashMap<>();
        for (String key : graph.keySet()) {
            distanceMap.put(key,new Object[] {Integer.MAX_VALUE, start});
        }
        //그래프의 시작 정점의 거리는 0으로 초기화
        distanceMap.get(start)[0] = 0;

        //최소 힙 생성
        PriorityQueue<Object[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare((Integer)o1[0],(Integer)o2[0]));
        // 그래프의 시작 정점과 시작 정점의 거리(0)을 최소 힙에 넣어준다.
        queue.add(new Object[] {distanceMap.get(start)[0],start});

        while (!queue.isEmpty()){
            // 큐에서 정점을 하나씩 꺼내 인접한 정점들의 거리를 모두 확인하며 업데이트한다.
            Object[] node = queue.poll();
            int curDistance = (Integer)node[0];
            String curNodeKey = (String)node[1];
            //더 짧은 경로가 있다면 무시한다.
            if ((Integer)distanceMap.get(curNodeKey)[0] < curDistance) continue;

            for ( Object[] nextNode : graph.get(curNodeKey)) {
                int nextDistance = (Integer) nextNode[0];
                String nextNodeKey = (String) nextNode[1];
                if (curDistance+nextDistance < (Integer) distanceMap.get(nextNodeKey)[0]){
                    distanceMap.get(nextNodeKey)[0] = curDistance+nextDistance;
                    distanceMap.get(nextNodeKey)[1] = curNodeKey;

                    queue.add(new Object[]{curDistance+nextDistance, nextNodeKey});
                }
            }
        }
        return distanceMap;
    }

}