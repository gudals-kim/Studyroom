import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];

        for (int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken())-1;

            arr[c][s] += 1;

        }
        for (int i=0; i<6;i++){
            for (int j=0; j<2;j++){
                if (arr[i][j]==0){
                    continue;
                }
                if (arr[i][j]<=k){
                    answer+=1;
                    continue;
                }
                int num = arr[i][j];
                while (num>0){
                    num-=k;
                    answer+=1;
                }
            }
        }
        System.out.print(answer);
    }
}