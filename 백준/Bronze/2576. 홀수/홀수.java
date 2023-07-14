import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int dn = 100;
        int sum = 0;
        for (int col=0; col<7; col++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n%2==1) {
                if (n<dn){
                    dn = n;
                }
                sum += n;
            }
        }
        if (dn==100){
            System.out.println("-1");
        }else{
            System.out.println(sum);
            System.out.println(dn);
        }
        
    }
}