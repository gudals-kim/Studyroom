import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            int[] arr = new int[N];
            for (int n=0; n<N; n++){
                int num = Integer.parseInt(st.nextToken());
                queue.add(new int[] {num, n});
                arr[n] = num;
            }
            Arrays.sort(arr);
            int idx = N-1;
            int ans = 0;
            while(!queue.isEmpty()||idx>0){
                int[] node = queue.removeFirst();
                if (node[0]==arr[idx]){
                    ans++;
                    idx--;
                    if (node[1]==M){
                        sb.append(ans).append("\n");
                        break;
                    }
                }else {
                    queue.addLast(node);
                }
            }
        }

        System.out.print(sb);


    }
}