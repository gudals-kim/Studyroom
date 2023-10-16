import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            Double dist = getDist(x1, y1, x2, y2);


            if (dist == 0 && r1==r2){ //동심원이며, 반지름이 같다
                sb.append(-1); // 동심원이면 무수히 많다.
            }else if (Math.abs(r1-r2) == dist || r1+r2 == dist){ // 두 원이 내접이거나 외접인 경우 
                sb.append(1); // 내접이거나 외접이면 접점이 1개이다.
            }else if (Math.abs(r1-r2) < dist && dist < r1 + r2){ // 서로다른 두 점에서 만나는 경우임
                sb.append(2); // 접점 2개
            }else {
                sb.append(0); // 이외는 만나지 않음
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static Double getDist(int x, int y, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x,2) + Math.abs(Math.pow(y2-y,2)));
    }

}
