import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = new StringTokenizer(br.readLine()).nextToken();

        /**
         * 커서를 왼쪽으로 옮기면
         * left의 마지막 값를 right의 첫번째로 옮겨준다.
         * 커서를 오른쪽으로 옮기면
         * right의 첫번째 값을 left의 마지막으로 옮겨준다.
         * left, right 를 Deque로 생성
         */
        ArrayDeque<String> left = new ArrayDeque<>();
        ArrayDeque<String> right = new ArrayDeque<>();
        StringBuilder sm = new StringBuilder();

        //커서가 마지막에서 시작한다는 조건이기 때문에 left에 모두 값을 넣어준다.
        //string을 list or 배열에 넣어 줄때 이렇게 사용하는게 맞는지?
        for (int i=0; i<str.length(); i++){
            left.add(String.valueOf(str.charAt(i)));
        }

        // 명령어 개수 m을 입력받는다.
        int M =Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        // m개의 명령어를 입력받는다. comd <= 명령어가 들어가는 변수
        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            String comd = st.nextToken();
            // String을 같다 조건을 넣을때 무조건 equals 를 써야하는지? == 안되는지?
            if (comd.equals("P")){
                //p일때는 입력을 token을 하나 더 가져온 뒤 왼쪽 마지막 인덱스에 추가해준다.
                String addStr = st.nextToken();
                left.addLast(addStr);
            }
            //left & right 가 비어있을경우 무시한다.
            if (comd.equals("L")&&left.size()!=0){
                //L일때는 left에서 마지막 인덱스를 뺀 뒤 right에 넣어준다.
                right.addFirst(left.removeLast());
            }
            if (comd.equals("D")&&right.size()!=0){
                //D일때는 right의 앞에서 빼내준뒤 left의 마지막에 넣어준다.
                left.addLast(right.removeFirst());
            }
            if (comd.equals("B")&&left.size()!=0){
                //B일때는 left의 마지막을 빼내준다.
                left.removeLast();
            }
        }
        // 리스트를 string으로 출력할때 이렇게 for문으로 돌려서 출력해야하는지?
        for (String word : left){
            sm.append(word);
        }
        for (String word : right){
            sm.append(word);
        }
        System.out.println(sm.toString());


    }
}