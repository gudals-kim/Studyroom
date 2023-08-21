import java.io.*;
import java.util.*;

public class Main{
    
    static int N,M,B;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] layer = new int[257];
        
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 인벤토리에 있는 블록 개수
        int minLayer = Integer.MAX_VALUE;
        int maxLayer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                layer[num]++;
                minLayer = Math.min(minLayer,num);
                maxLayer = Math.max(maxLayer,num);

            }
        }
        int [] dp = new int[257];
        Arrays.fill(dp,Integer.MAX_VALUE);

        for (int curLayer = minLayer; curLayer <= maxLayer; curLayer++) {
            int inv = B;//현재 인벤토리
            int time = 0;
            int add = 0; //
            int dig = 0;

            //현재보다 높은 땅과의 개수 차이 -> 파야함
            for (int highLayer = curLayer+1; highLayer <= maxLayer; highLayer++) {
                if (layer[highLayer]==0) continue;//0이면 현재 높이에 블록이 없음
                dig += (highLayer-curLayer) * layer[highLayer];//파야하는 개수
            }
            time += dig * 2; //파는데 걸린시간을 더해준다.
            inv += dig; // 판 개수 만큼 인벤토리에 넣어준다.

            //현재보다 낮은 땅과의 개수 차이 -> 올려줘야함
            for (int lowLayer = 0; lowLayer < curLayer; lowLayer++) {
                if (layer[lowLayer]==0)continue;//0이면 현재 높이에 블록이 없다ㅡㄴ거
                add += (curLayer-lowLayer)*layer[lowLayer];//더해줘야하는 블록 개수
            }
            if (add<=inv){
                time += add;//1개 블록당 1초가 걸리니 블록개수와 같다.
                dp[curLayer] = time;//현재 층으로 맞췄을때의 총 걸린 시간을 저장한다.
            }

        }
        int ansLayer = 0;// 시간이 가장 적게 걸린 층을 고른다.
        for (int curLayer = 0; curLayer <= 256; curLayer++) {
            if (dp[curLayer]<=dp[ansLayer]){//같은 값이나 더 작은값이면 더 높은 층을 고른다.
                ansLayer = curLayer;
            }
        }

        System.out.println(dp[ansLayer]+" "+ansLayer);
    }
}