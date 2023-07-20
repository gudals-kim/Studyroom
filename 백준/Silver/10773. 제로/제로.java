import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int k=0; k<K; k++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if (n==0){
                stack.pop();
                continue;
            }
            stack.push(n);
        }

        for (Integer integer : stack) {
            ans+=integer;
        }
        System.out.print(ans);
    }
}