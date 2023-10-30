
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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        pick(0,0, arr.length, arr,0);
        System.out.println(ans);
    }

    static void pick(int count, int sum, int len, int[] arr, int pick){
        if (sum==S&&pick>0){
            ans++;
        }
        if (count>=len) return;
        for (int i = count; i < len; i++) {
            pick(i+1, sum+arr[i], len, arr, pick+1);
        }
    }

}

