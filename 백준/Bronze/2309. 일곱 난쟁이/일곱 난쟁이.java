import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[9];

        for (int i=0; i<9;i++){

            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visitied = new boolean[arr.length];
        comb(arr, visitied, 0, 7, result);

        for(List<Integer> answer: result){
            int sum = 0;
            for (int n : answer){
                sum+=n;
            }
            if (sum==100){
                Collections.sort(answer);
                for (int n : answer){
                    System.out.println(n);
                }
                break;
            }
        }




    }


    static void comb(int[] array, boolean[] visited, int start, int r, List<List<Integer>> result){

        if(r==0){
            List<Integer> answer = new ArrayList<>();
            for (int i=0; i<array.length;i++){
                if(visited[i]){
                    answer.add(array[i]);
                }
            }
            result.add(answer);
            return;
        }



        for(int i=start; i<array.length; i++){
            visited[i] = true;
            comb(array, visited, i+1, r-1, result);
            visited[i] = false;
        }


    }

}