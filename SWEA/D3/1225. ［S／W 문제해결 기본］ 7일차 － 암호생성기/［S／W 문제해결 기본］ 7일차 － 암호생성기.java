
import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] ILoveU) throws IOException{
//        System.setIn(new FileInputStream("C:\\SSAFY\\workspace\\CodingTest\\src\\swea\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> queue;
        int T;
        for (int testCase = 1; testCase <= 10; testCase++) {
            T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            queue = new ArrayDeque<>();
            for (int n = 0; n < 8; n++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            while(true){
                for (int minus = 1; minus < 6; minus++) {
                    int node = queue.pollFirst() - minus;

                    if (node<0) node=0;
                    queue.addLast(node);
                    if (node==0) break;
                }
                if (queue.getLast()==0) break;
            }

            sb.append("#").append(testCase).append(" ");
            while(!queue.isEmpty()){
                sb.append(queue.pollFirst()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
