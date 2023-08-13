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

        perm(N,M,0,new int[M]);
        System.out.println(sb);

    }


    static void perm(int N, int r, int cnt, int[] permCase){
        if (cnt==r){
            for (int i : permCase) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            permCase[cnt] = i;
            perm(N, r, cnt+1, permCase);
        }

    }
}