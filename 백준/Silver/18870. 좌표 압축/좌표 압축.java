import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            Long num = Long.parseLong(st.nextToken());
            if (map.containsKey(num)){
                map.get(num).add(n);
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(n);
            map.put(num,list);
        }

        Long[] sortKeys = map.keySet().toArray(new Long[map.keySet().size()]);
        Arrays.sort(sortKeys);

        for (int idx = 0; idx < sortKeys.length; idx++) {
            for (Integer ansIndex : map.get(sortKeys[idx])) {
                ans[ansIndex] = idx;
            }
        }

        for (int n : ans) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}