import java.io.*;
import java.util.*;

public class Main{
    static HashSet<Integer> ans = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(br.readLine());
        int[] nums = new int[] {1, 5, 10, 50};
        comb(nums, r, 0, 0, new int[r]);
        System.out.println(ans.size());

    }

    static void comb(int[] nums, int r, int cnt, int start, int[] result){
        if (cnt == r){
            int sum = 0;
            for (int num : result) {
                sum+=num;
            }
            ans.add(sum);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            result[cnt] = nums[i];
            comb(nums, r, cnt+1, i, result);
        }
    }

}