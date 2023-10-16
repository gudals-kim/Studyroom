import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            Planet start = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Planet end = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int n = Integer.parseInt(br.readLine());
            Planet[] planets = new Planet[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                planets[i] = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            ans = 0;
            process(planets, start, end);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    static void process(Planet[] planets, Planet start, Planet end){
        for (Planet planet : planets) {
            Double distStart = getDist(planet.x, planet.y, start.x, start.y);
            Double distEnd = getDist(planet.x, planet.y, end.x, end.y);
            double powCost = Math.pow(planet.cost, 2);

            if (powCost > distStart && powCost > distEnd) continue; //시작 위치와 도착위치가 둘다 행성 안에 있으면 더할 필요 없음
            if (powCost > distStart) ans++; // 시작 점이 행성 안에 있다면 1 더하기~
            else if (powCost > distEnd) ans++; // 도착 점이 행성 안에 있다면 1 더하기
        }

    }
    static Double getDist(int x, int y, int x2, int y2){
        return Math.pow(x-x2,2) + Math.pow(y-y2,2);
    }

}
class Planet{
    int x;
    int y;
    int cost;
    public Planet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Planet(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

