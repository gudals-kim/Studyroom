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
        perm(arr,M,0,new boolean[N],new int[M]);
        System.out.println(sb);

    }
    static void perm(int[] arr, int r, int cnt, boolean[] visited, int[] permCase){

        if (cnt==r){
            for (int i : permCase) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permCase[cnt] = arr[i];
            perm(arr, r, cnt+1, visited, permCase);
            visited[i] = false;
        }

    }


}