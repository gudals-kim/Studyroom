import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        for (int i=0;i<n;i++){
            String left = "";
            String right = "";
            
            
            for (int space=0;space<i;space++){
                left += " ";
            }
            
            for (int s=n-1;s>i;s--){
                left+="*";
                right+="*";
            }
            
            System.out.println(left+"*"+right);
            
            
        }
        
        
    }
}