
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase < T+1; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int q = N-M+1;
            int answer = -1;
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < q; j++) {
                    int result = 0;
                    for (int di = 0; di < M; di++) {
                        for (int dj = 0; dj < M; dj++) {
                            result += arr[i+di][j+dj];
                        }
                    }
                    answer = Math.max(answer,result);
                }
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
	System.out.println(sb);
    }
}
