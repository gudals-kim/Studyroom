
import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("C:\\SSAFY\\workspace\\CodingTest\\src\\swea\\input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // (:0, [:1
        int sign[] = new int[4];
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            int size = input.length();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int ans = 1;
            if (size%2 == 1){
                sb.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }
            for (int idx = 0; idx < size; idx++) {
                char chr = input.charAt(idx);
                if (chr=='{'||chr=='('||chr=='['||chr=='<'){
                    stack.addLast(chr);
                    continue;
                }
                if (stack.isEmpty()||stack.pollLast()!=getPair(chr)){
                    ans = 0;
                    break;
                }
            }
            if (!stack.isEmpty()){
                ans = 0;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
    public static char getPair(char chr) {
        switch (chr) { //닫히는 괄호 들어오면 그와 일치하는 열린 괄호 리턴
            case '}':    return '{';
            case ')':    return '(';
            case ']':    return '[';
            case '>':    return '<';
        }
        return ' ';
    }

}
