import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[] getCost = new int[N];

        for (int n = 0; n < N; n++) {
            getCost[n] = Integer.parseInt(br.readLine());
        }
        for (int i = N-1; i > -1; i--) {
            ans += K/getCost[i];
            K = K%getCost[i];
        }
        System.out.println(ans);
    }
}