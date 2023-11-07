
import java.io.*;
import java.util.*;

public class Main {
    static double ans;
    static long N, L, W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        ans = b_search(0, Math.max(L, Math.max(W, H)));

        System.out.println(ans);
    }
    static double b_search(double start, double end){
        double mid;

        while (start<end){
            mid = (start + end) / 2;
            long l = (long) (L / mid) * (long) (W / mid) * (long) (H / mid);

            if (l < N){
                if(end==mid) break;
                end = mid;
            }else {
                if(start==mid) break;
                start = mid;
            }
        }
        return start;
    }

}

