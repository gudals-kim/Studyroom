import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] getMinDist = new int[N][N];
        String[][] ans = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i==j){
                    getMinDist[i][j] = j;
                    ans[i][j] = "-";
                }
                else {
                    getMinDist[i][j] = INF;
                    ans[i][j] = String.valueOf(j+1);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int leftNode = Integer.parseInt(st.nextToken())-1;
            int rightNode = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            getMinDist[leftNode][rightNode] = Math.min(getMinDist[leftNode][rightNode],cost);
            getMinDist[rightNode][leftNode] = Math.min(getMinDist[rightNode][leftNode],cost);
        }

        for (int k = 0; k < N; k++) {
            for (int node = 0; node < N; node++) {
                for (int nextNode = 0; nextNode < N; nextNode++) {
                    if (getMinDist[node][nextNode]>getMinDist[node][k]+getMinDist[k][nextNode]){
                        getMinDist[node][nextNode] = getMinDist[node][k]+getMinDist[k][nextNode];
                        ans[node][nextNode] = ans[node][k];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i==j){
                    sb.append("-").append(" ");
                }else {
                    sb.append(ans[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}