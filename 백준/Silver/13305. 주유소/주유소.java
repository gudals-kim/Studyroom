import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] getDist = new int[N];
        int[] getCost = new int[N];

        StringTokenizer distSt = new StringTokenizer(br.readLine());
        StringTokenizer costSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i<N-1){
                getDist[i] = Integer.parseInt(distSt.nextToken());
            }
            getCost[i] = Integer.parseInt(costSt.nextToken());
        }

        int minCost = getCost[0];
        int ans= minCost*getDist[0];
        for (int i = 1; i < N; i++) {
            minCost = Math.min(minCost, getCost[i]);
            ans+=minCost*getDist[i];
        }
        System.out.println(ans);
    }

}