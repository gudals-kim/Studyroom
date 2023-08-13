import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //지름길 개수
        int D = Integer.parseInt(st.nextToken()); //고속도로의 길이 

        //현재 위치로 도착하는 지름길들을 저장한다.
        HashMap<Integer, ArrayList<FastRoute>> fastRoutes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//지름길 시작점
            int end = Integer.parseInt(st.nextToken());//지름길 도착점
            int dist = Integer.parseInt(st.nextToken());//지름길 거리

            if (!fastRoutes.containsKey(end)){
                fastRoutes.put(end, new ArrayList<>());
            }
            fastRoutes.get(end).add(new FastRoute(start,dist));
        }

        int[] getMinDist = new int[D+1];//시작점에서 각 인덱스까지 최소거리가 들어갈 예정

        for (int i = 1; i < D+1; i++) {
            getMinDist[i] = getMinDist[i-1]+1;//시작 점에서 i까지 최대 거리로 초기화

            if (fastRoutes.containsKey(i)){//i로 오는 지름길이 있다면?
                for (FastRoute fastRoute : fastRoutes.get(i)) {//모든 지름길 중
                    //시작점에서 지름길의 시작점까지의 최소거리 + 지름길의 거리가 최솟값인 곳을 저장한다.
                    getMinDist[i] = Math.min(getMinDist[i],getMinDist[fastRoute.start]+fastRoute.dist);
                }
            }
        }
        System.out.println(getMinDist[D]);
    }
}
class FastRoute{
    int start;
    int dist;

    public FastRoute(int start, int dist) {
        this.start = start;
        this.dist = dist;
    }
}