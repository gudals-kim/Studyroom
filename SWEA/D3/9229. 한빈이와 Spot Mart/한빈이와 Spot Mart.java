
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
            Integer[] arr = new Integer[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr,(o1,o2)->Integer.compare(o2,o1));


            int maxSum = -1;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length && j!=i; j++) {
                    if (arr[i]+arr[j]<=M && maxSum<=arr[i]+arr[j]){
                        maxSum=arr[i]+arr[j];
                    }
                }
            }
            if (maxSum<0){
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(maxSum).append("\n");
        }
        System.out.println(sb);

    }
}
