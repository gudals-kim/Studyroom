import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int answer = 0;
        for (int i=0; i<n; i++ ){
            if (v==Integer.parseInt(st.nextToken())){
                answer++;
            }
        }
        System.out.print(answer);
        
        
    }
}