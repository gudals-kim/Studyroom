import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n;
        for (int row=0; row<3; row++){
            st = new StringTokenizer(bf.readLine());
            n=0;
            for (int col=0; col<4; col++){
                int dbt = Integer.parseInt(st.nextToken());
                n+=dbt;
            }
            if (n==4){
                System.out.println("E");
            }
            if (n==3){
                System.out.println("A");
            }
            if (n==2){
                System.out.println("B");
            }
            if (n==1){
                System.out.println("C");
            }
            if (n==0){
                System.out.println("D");
            }
        }
        
        
        
    }
}