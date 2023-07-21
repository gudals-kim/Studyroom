import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int[] arr = new int[n];
            //1: true -1: false
            for (int i=0; i<n; i++){
                arr[i] = 1;
            }
            int ans = 0;
            // 1라운드(i=0)는 초기화로 끝냈으니, i=1 부터 시작해야한다.
            for (int i=1; i<n; i++){
                for (int j=0; j<n; j++){
                    if ((j+1)%(i+1)==0){
                        arr[j] *= -1;
                    }
                }
            }

            for (int a : arr){
                if (a==1){
                    ans++;
                }
            }
            sb.append(ans).append("\n");
            
        }
        System.out.print(sb);

    }

}