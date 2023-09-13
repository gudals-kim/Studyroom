import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        String T = br.readLine();

        while (S.length() < T.length()){
            if (T.endsWith("A")){
                T = T.substring(0,T.length()-1);
                continue;
            }
            if (T.endsWith("B")){
                T = T.substring(0,T.length()-1);
                T = new StringBuilder(T).reverse().toString();
            }
        }

        if (S.equals(T)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

}