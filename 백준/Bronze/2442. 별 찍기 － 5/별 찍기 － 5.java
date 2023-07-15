import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++){
            String left = "";
            String right = "";

            for (int rt=0; rt<i; rt++){
                right+="*";
            }

            for (int s=(n-1); s>i; s--){
                left += " ";
            }
            for (int lt=0; lt<i; lt++){
                left+="*";
            }

            System.out.println(left+"*"+right);
        }

    }


}