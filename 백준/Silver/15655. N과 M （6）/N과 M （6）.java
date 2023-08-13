import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(arr,M,0,0,new int[M]);
        System.out.println(sb);

    }
    static void comb(int[] arr, int r, int cnt, int start, int[] combCase){

        if (cnt==r){
            for (int i : combCase) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            combCase[cnt] = arr[i];
            comb(arr, r, cnt+1, i+1, combCase);
        }

    }


}