import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] aArray = new int[n];
        int[] bArray = new int[m];


        st = new StringTokenizer(br.readLine());
        for (int ai=0; ai<n; ai++){
            aArray[ai]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int bi=0; bi<m; bi++){
            bArray[bi]= Integer.parseInt(st.nextToken());
        }


        int aIdx = 0;
        int bIdx = 0;
        while(aIdx<n&&bIdx<m){
            if (aArray[aIdx]>bArray[bIdx]){
                sb.append(bArray[bIdx]).append(" ");
                bIdx++;
            }
            else {
                sb.append(aArray[aIdx]).append(" ");
                aIdx++;
            }
//            else {//같을때
//                sb.append(aArray[aIdx]).append(" ");
//                sb.append(bArray[bIdx]).append(" ");
//                aIdx++;
//                bIdx++;
//            }
        }



        if (aIdx<n){
            for (int i=aIdx;i<n;i++){
                sb.append(aArray[i]).append(" ");
            }
        }
        if (bIdx<m){
            for (int i=bIdx;i<m;i++){
                sb.append(bArray[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}