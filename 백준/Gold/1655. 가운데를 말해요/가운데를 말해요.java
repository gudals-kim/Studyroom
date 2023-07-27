import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(
                ((o1, o2) -> Integer.compare(o2,o1)));
        PriorityQueue<Integer> right = new PriorityQueue<>(
                ((o1, o2) -> Integer.compare(o1,o2))
        );

        int N = Integer.parseInt(st.nextToken());



        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        if (f<s){
            left.add(f);
            right.add(s);
        }else {
            left.add(s);
            right.add(f);
        }

        sb.append(f)
                .append("\n")
                .append(left.peek())
                .append("\n");

        for (int n = 2; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (n%2!=0){
                //짝수
                if (!(left.isEmpty())&&left.peek()>num){
                    right.add(left.poll());
                    left.add(num);

                    sb.append(left.peek()).append("\n");
                    continue;
                }
                right.add(num);
                sb.append(left.peek()).append("\n");
                continue;
            }
            //홀수
            if (!(right.isEmpty())&&right.peek()<=num){
                left.add(right.poll());
                right.add(num);

                sb.append(left.peek()).append("\n");
                continue;
            }
            left.add(num);
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }

}
