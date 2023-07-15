import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i=0; i<n; i++){
            String left = "";
            String right = "";

            for (int space=n-1; space>i; space--){
                left += " ";

            }
            for (int star=0; star<i;star++){
                left += "*";
                right += "*";
            }
            arr[i] = left+"*"+right;
            System.out.println(arr[i]);
        }

        for (int idx=n-2; idx>-1; idx--){
            System.out.println(arr[idx]);
        }



    }
}