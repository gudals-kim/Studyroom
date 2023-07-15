import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++){
            String star = "";
            for (int s=0; s<i; s++){
                star+=" ";
            }
            for (int t=n; t>i; t--){
                star+="*";
            }
            System.out.println(star);
        }

    }
}