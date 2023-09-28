import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int lis[] = new int[N];
            int cnt = 0;
            lis[cnt++] = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] > lis[cnt-1]) lis[cnt++]=arr[i];
                else lis[bSearch(lis, 0, cnt, arr[i])] = arr[i];
            }
            int ans = 1;
            int preI = 0;
            for (int i = 1; i < N; i++) {
                if (lis[preI]<lis[i]){
                    preI = i;
                    ans++;
                }else {
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static int bSearch(int[] arr, int start, int end, int findNum){
        while(start<end){
            int mid = (start+end) / 2;
            if (findNum>arr[mid]) start = mid + 1;
            else end = mid;
        }
        return end;
    }


}

