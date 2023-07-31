import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        Long C = Long.parseLong(st.nextToken());
        HashMap<Long, Long[]> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (Long n = 0L; n < N; n++) {
            Long num = Long.parseLong(st.nextToken());
            if (!map.containsKey(num)){
                map.put(num,new Long[] {num, 1L,n});
                continue;
            }
            map.get(num)[1]++;
        }
        Long[][] arr = new Long[map.size()][3];
        arr = map.values().toArray(arr);

        Arrays.sort(arr,((o1, o2) ->
        {
            if (o1[1]==o2[1]) {
                return Long.compare(o1[2],o2[2]);
            }
            return Long.compare(o2[1],o1[1]);
        }));


        for (Long[] ans : arr) {
            for (int i = 0; i < ans[1]; i++) {
                sb.append(ans[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}