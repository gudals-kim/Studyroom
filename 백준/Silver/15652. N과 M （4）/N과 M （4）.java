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

        comb(N,M,0,1,new int[M]);
        System.out.println(sb);

    }
    static void comb(int N, int r, int cnt, int start, int[] combCase){
        if (cnt==r){
            for (int i : combCase) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            combCase[cnt] = i;
            comb(N,r,cnt+1,i,combCase);
        }
    }


}