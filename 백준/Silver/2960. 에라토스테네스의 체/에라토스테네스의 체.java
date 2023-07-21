import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        boolean[] chk = new boolean[N+1];
        int roop = 0;

        for (int n = 2; n < N+1; n++) {
            for (int i = n; i < N+1; i++) {
                if (i % n == 0 && !chk[i]) {
                    roop++;
                    chk[i] = true;
                }
                if (roop == K) {
                    sb.append(i);
                    break;
                }
            }
            if (roop==K){
                break;
            }
        }
        System.out.print(sb);
    }
}