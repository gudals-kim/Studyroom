import java.util.*;
import java.io.*;
public class Main {
    static  ArrayDeque<Pair> stack;
    static ArrayList<Bracket> brackets;
    static char[] chars;
    static ArrayList<String> answer;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        brackets = new ArrayList<>();
        String input = br.readLine();
        chars = new char[input.length()];
        set = new HashSet<>();
        answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }

        //괄호 짝 찾기 만약 짝이 없다면 스택에 남아 있다.
        findBracket(input);

        //짝이 아닌 괄호는 다 지워준다.
        while (!stack.isEmpty()){
            chars[stack.pollLast().index]='x';
        }

        //빠질 괄호 쌍 고르기
        for (int r = 1; r <= brackets.size(); r++) {
            comb(brackets.size(),r,0,0,new int[r]);
        }

        // 정렬해야하기 때문에 리스트로 옮겨준다.
        for (String s : set) {
            answer.add(s);
        }
        //저장된 데이터를 정렬한다.
        Collections.sort(answer);
        //이후 출력한다.
        for (String s : answer) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
    static void comb(int n, int r, int cnt, int start, int[] result){
        if (cnt==r){
            char[] temp = chars.clone();
            for (int i : result) {
                temp[brackets.get(i).left] = 'x';
                temp[brackets.get(i).right] = 'x';
            }
            String ans = "";
            for (char c : temp) {
                if (c!='x'){
                    ans+=c;
                }
            }
            set.add(ans);
            return;
        }
        for (int i = start; i < n; i++) {
            result[cnt] = i;
            comb(n, r,cnt+1, i+1, result);
        }
    }


    static void findBracket(String input){
        stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c!='('&&c!=')')continue;
            boolean flag = true;
            while (!stack.isEmpty()&&c==')'){
                Pair left = stack.pollLast();
                if (left.str=='('){
                    brackets.add(new Bracket(left.index,i));
                    flag = false;
                    break;
                }
            }
            if (flag&&c==')'){
                stack.addLast(new Pair(i,c));
            }
            if (c=='('){
                stack.addLast(new Pair(i,c));
            }
        }

    }

}
class Bracket{
    int left;
    int right;

    @Override
    public String toString() {
        return "Bracket{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    public Bracket(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
class Pair{
    int index;
    char str;

    @Override
    public String toString() {
        return "Pair{" +
                "index=" + index +
                ", str=" + str +
                '}';
    }

    public Pair(int index, char str) {
        this.index = index;
        this.str = str;
    }
}