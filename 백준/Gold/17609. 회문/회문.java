import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            StringBuilder input = new StringBuilder(line);
            if (line.equals(input.reverse().toString())){//문자 자체가 회문이라면
                sb.append(0).append("\n");//회문이니 0 을 sb 에 넣고
                continue; //다음 테케로
            }
            //회문이 아닐때 유사회문인지 판단해야함.
            int left = 0;
            int right = input.length()-1;
            int ans = 2;
            while (left<right){
                if (line.charAt(left)==line.charAt(right)){
                    //같다면 투 포인터 옮겨주기
                    left++;
                    right--;
                    continue;
                }
                //같지 않을때 는 유사회문인지, 아예 회문이 아닌지 판단한다.

                
                //왼쪽 포인터, 오른쪽 포인터 하나씩 지운 후 반대로 해도 같다면 1개만 지워도 회문이 되는 유사회문임
                StringBuilder leftInputDel = new StringBuilder(line).deleteCharAt(left);
                StringBuilder rightInputDel = new StringBuilder(line).deleteCharAt(right);
                if (leftInputDel.toString().equals(leftInputDel.reverse().toString()) || rightInputDel.toString().equals(rightInputDel.reverse().toString())){
                    ans = 1;
                }
                //1개를 지워도 유사회문이 아니면 더 볼 필요없이 유사 회문이 아님
                break;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);



    }
}