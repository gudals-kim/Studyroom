
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] getCost = new int[N][N];

        int[] R = new int[N+1];
        int[] G = new int[N+1];
        int[] B = new int[N+1];

        for (int home = 0; home < N; home++) {
            st = new StringTokenizer(br.readLine());
            for (int color = 0; color < 3; color++) {
                getCost[home][color] = Integer.parseInt(st.nextToken());
            }
            R[home] = getCost[home][0];
            G[home] = getCost[home][1];
            B[home] = getCost[home][2];
        }




        for (int home = 1; home < N; home++) {
            R[home] = Math.min(getCost[home][0]+B[home-1], getCost[home][0]+G[home-1]);
            G[home] = Math.min(getCost[home][1]+R[home-1], getCost[home][1]+B[home-1]);
            B[home] = Math.min(getCost[home][2]+R[home-1], getCost[home][2]+G[home-1]);
        }
        System.out.println(Math.min(R[N-1],Math.min(G[N-1],B[N-1])));




    }

}
