import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[10];
        int data = 1;
        for (int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            data = data*n;
        }
        String stData = String.valueOf(data);
        for (int i=0;i<stData.length();i++){
            int idx = Integer.parseInt(String.valueOf(stData.charAt(i)));
            arr[idx]++;
        }
        for (int n:arr){
            System.out.println(n);
        }

    }
}