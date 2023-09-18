import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int leftNode = Integer.parseInt(st.nextToken())-1;
                int rightNode = Integer.parseInt(st.nextToken())-1;
                // 연결 시켜주기
                union(arr, leftNode, rightNode);
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                find(arr,i);
                if (arr[i]==i) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static int find(int[] arr, int i){
        if (arr[i]==i) return i;
        return arr[i] = find(arr, arr[i]);
    }
    static void union(int[] arr, int a, int b){
        int pA = find(arr, a);
        int pB = find(arr, b);
        if (pA<pB) {
            arr[pB] = pA;
        }else {
            arr[pA] = pB;
        }
    }
}