import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        int z = 'z';
        for (int i='a';i<z+1;i++){
            map.put(i,0);
        }
        String data = st.nextToken();
        for (int i=0;i<data.length();i++) {
        	map.put((int)data.charAt(i),map.get((int)data.charAt(i))+1);
        }
        for (int n:map.values()) {
        	System.out.print(n+" ");
        }

        
    }
}