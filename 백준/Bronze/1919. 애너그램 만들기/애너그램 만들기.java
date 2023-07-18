import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = new StringTokenizer(br.readLine()).nextToken();
        String word2 = new StringTokenizer(br.readLine()).nextToken();
        int[] apb = new int [26];
        for (int idx = 0; idx< word.length(); idx++){
            apb[word.charAt(idx)-'a']++;
        }
        for (int idx = 0; idx< word2.length(); idx++){
            apb[word2.charAt(idx)-'a']--;
        }
        int ans=0;
        for (int idx=0; idx < apb.length; idx++){
            if (apb[idx]!=0){
                ans+=Math.abs(apb[idx]);
            }
        }
        System.out.println(ans);
    }

}