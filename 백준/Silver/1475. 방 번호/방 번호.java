import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        float[] arr = new float[10];
        for (int i=0;i<n.length();i++){
            int m = Integer.parseInt(String.valueOf(n.charAt(i)));
            if (m==9 || m==6){

                arr[6] += 0.5f;
            }
            else{
                arr[m]++;
            }
        }
        float maxN = 0L;
        for (float i :arr){
            maxN =Math.max(maxN,i);
        }
        System.out.println(Math.round(maxN));
    }
}