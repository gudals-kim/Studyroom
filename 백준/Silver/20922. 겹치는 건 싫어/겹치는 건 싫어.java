import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(st.nextToken());
            data[n] = num;
            map.put(num,0);
        }

        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while (right<N) {
            map.put(data[right],map.get(data[right])+1);
            while (map.get(data[right])>K&&left<right){
                map.put(data[left],map.get(data[left])-1);
                maxLen=Integer.max(maxLen,len);
                left++;
                len--;
            }
            right++;
            len++;
        }
        maxLen=Integer.max(maxLen,len);

        System.out.println(maxLen);
    }

}