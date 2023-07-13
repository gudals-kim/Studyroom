
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int key, value;
        int maxKey = 0;
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<Integer>();
        
        for (int i=1; i<7; i++){
            map.put(i, 0);
        }
        
        for (int i=0; i<3; i++){
        	key = Integer.parseInt(st.nextToken());
        	arr.add(key);
        	value = map.get(key);
        	value++;
        	map.put(key, value);
        	
        	if (value == 3) {
				maxKey = key;
			}else if (value == 2) {
				maxKey = key;
			}
        }
        if (maxKey==0) {
			maxKey = Collections.max(arr);
			result = maxKey*100;
		}
        else if (map.get(maxKey)==2) {
        	result=((maxKey*100)+1000);
        }
        else if (map.get(maxKey)==3) {
        	result=((maxKey*1000)+10000);
		}
        
        System.out.print(result);
      
    }
}