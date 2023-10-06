import java.io.*;
import java.util.*;

public class Main {
    static int[] coins = {25, 10, 5, 1};
    static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for (int coin : coins) {
                sb.append(N/coin).append(" ");
                N = N%coin;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

