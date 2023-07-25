import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        Long[] arr = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int idx=0; idx<n; idx++){
            arr[idx] = Long.parseLong(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        Long k = Long.parseLong(st.nextToken());
        Long sum = arr[0];
        Long ans = 0L;
        int left = 0;
        int right = 0;

        while(left<n&&right<n){
            if (left>right){
                right=left;
                sum = arr[left];
            }

            if (sum>k){
                ans += n - right;

                sum -= arr[left];
                left++;
            }
            else {
                right++;

                if (right>=n) break;
                sum+=arr[right];
            }
        }
        System.out.print(ans);
    }
}