import java.io.*;
import java.util.*;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        GuitarString[] brands = new GuitarString[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int packCost = Integer.parseInt(st.nextToken());
            int pieceCost = Integer.parseInt(st.nextToken());
            brands[i] = new GuitarString(packCost, pieceCost);
        }
        int[] minCost = new int[N+7];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                minCost[i+1] = Math.min(minCost[i+1], brands[j].piece+minCost[i]);
                minCost[i+6] = Math.min(minCost[i+6], brands[j].pack+minCost[i]);
            }
        }
        ans = Integer.MAX_VALUE;
        for (int i = N; i < N+7; i++) {
            ans = Math.min(ans, minCost[i]);
        }
        System.out.println(ans);
    }



}
class GuitarString{
    int pack;
    int piece;

    public GuitarString(int pack, int piece) {
        this.pack = pack;
        this.piece = piece;
    }
}