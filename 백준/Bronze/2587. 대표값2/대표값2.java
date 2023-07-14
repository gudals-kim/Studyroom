import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int []arr = new int [5];
        int sumData = 0;
        
        for (int n=0;n<5;n++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[n] = num;
            sumData += num;
        }
        
        System.out.println(sumData/arr.length);
        Arrays.sort(arr);
        System.out.println(arr[2]);
        
    }
}