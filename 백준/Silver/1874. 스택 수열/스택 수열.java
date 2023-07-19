import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int i=0;
        int cnt = 1;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (i<n){
            int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            while (cnt<=num){
                stack.addLast(cnt);
                cnt++;
                sb.append("+").append("\n");
            }
            if (num == stack.getLast()){
                stack.removeLast();
                sb.append("-").append("\n");
            }
            else{
                sb.delete(0,sb.length());
                sb.append("NO");
                break;
            }
            i++;
        }
        System.out.println(sb.toString());

    }
}