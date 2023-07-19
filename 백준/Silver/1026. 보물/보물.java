import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arrA,Collections.reverseOrder());
        Arrays.sort(arrB);
        
        for (int idx=0; idx<n; idx++){
            ans += arrA[idx]*arrB[idx];
        }
        System.out.println(ans);
    }
}