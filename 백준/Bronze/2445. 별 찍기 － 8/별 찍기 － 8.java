import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[] arr = new String [n];


        for (int i=0;i<n;i++){
            String left = "";
            String right = "";


            for (int star=0;star<i+1;star++){
                left+="*";
            }

            for (int space=n-1;space>i;space--){
                left+=" ";
                right+=" ";
            }
            for (int star=0;star<i+1;star++){
                right +="*";
            }

            arr[i] = left+right;
            System.out.println(arr[i]);
        }
        for (int i=n-2;i>-1;i--){
            System.out.println(arr[i]);
        }



    }
}