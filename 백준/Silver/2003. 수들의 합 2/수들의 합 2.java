import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i=0; i<n; i++){
            int sumN = 0;
            for (int j=i; j<n; j++){
                sumN+=arr[j];
                if(sumN>=m){
                    if(sumN==m){
                        answer++;
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}