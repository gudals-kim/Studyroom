
import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        ans = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 1; right < N + 1; right++) {
            arr[right] = arr[right-1] + Integer.parseInt(st.nextToken());
            while (left<right&&arr[right]-arr[left]>=S){
                ans = Math.min(ans,right-left);
                left++;
            }
        }
        if (arr[N]<S){
            System.out.println(0);
            return;
        }

        System.out.println(ans);

    }
}

