import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int r=0; r<R; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comd = st.nextToken();

            if (comd.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (comd.equals("top")){
                if (stack.empty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
                continue;
            }
            if (comd.equals("empty")){
                if (stack.empty()){
                    sb.append(1).append("\n");
                    continue;
                }
                sb.append(0).append("\n");
                continue;
            }
            if (comd.equals("pop")){
                if (stack.empty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(stack.pop()).append("\n");
                continue;
            }
            if (comd.equals("size")){
                sb.append(stack.size()).append("\n");
                continue;
            }

        }
        System.out.print(sb.toString());

    }
}