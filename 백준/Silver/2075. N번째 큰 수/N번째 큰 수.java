import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> queue = new PriorityQueue<>(
                (o1, o2) -> Long.compare(o2, o1)
        );


        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int n2 = 0; n2 < N; n2++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
        }

        for (int n=0; n<N-1; n++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}