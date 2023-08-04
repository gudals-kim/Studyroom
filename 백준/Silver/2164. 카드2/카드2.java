
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int cardNum = 1; cardNum <= N; cardNum++) {
            deque.add(cardNum);
        }
        while(deque.size()>1){
            deque.pollFirst();
            Integer sec = deque.pollFirst();
            deque.addLast(sec);
        }
        System.out.println(deque.poll());
    }

}
