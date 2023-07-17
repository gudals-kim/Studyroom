import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args ) throws IOException {
        //---- 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        // ---------
        int answer = 0;
        Arrays.sort(arr);
        for (int i=0;i<n-1;i++){
            for (int j=i+1; j<n; j++){
                if (arr[i]+arr[j]>x){
                    break;
                }
                if (arr[i]+arr[j]==x){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }




    static void comb(int[] arr, boolean[] visited, int start, int r, List<List<Integer>> result){
        if (r == 0){
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i<arr.length; i++){
                if (visited[i]){
                    answer.add(arr[i]);
                }
            }
            result.add(answer);
            return;
        }

        for (int i = start; i < arr.length; i++){
            visited[i] = true;
            comb(arr, visited, i+1, r-1,result);
            visited[i] = false;

        }


    }



}