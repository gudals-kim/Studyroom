import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int r=0; r<n; r++){
            String inputs = new StringTokenizer(br.readLine()).nextToken();
            ArrayDeque<Character> left = new ArrayDeque<>();
            ArrayDeque<Character> right = new ArrayDeque<>();
            for (int i=0; i<inputs.length(); i++){
                char input = inputs.charAt(i);
                if (input=='<'&&left.size()>0){
                    Character character = left.removeLast();
                    right.addFirst(character);
                    continue;
                }
                if (input=='>'&&right.size()>0){
                    Character character = right.removeFirst();
                    left.addLast(character);
                    continue;
                }
                if (input=='-'&&left.size()>0){
                    left.removeLast();
                    continue;
                }
                if (input!='<'&&input!='>'&&input!='-'){
                    left.addLast(input);
                }
            }

            for (Character character : left) {
                sb.append(character);
            }
            for (Character character : right) {
                sb.append(character);
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }
}