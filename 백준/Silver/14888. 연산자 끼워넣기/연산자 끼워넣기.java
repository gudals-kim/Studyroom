import java.util.*;
import java.io.*;

public class Main{
    static int[] number , operator;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 계산할 숫자 입력 받기
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 입력 받기
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0],1);
        System.out.println(maxValue);
        System.out.println(minValue);
    }
    static void dfs(int curNum, int nextIdx){

        if (nextIdx == N){
            maxValue = Math.max(maxValue, curNum);
            minValue = Math.min(minValue, curNum);
            return;
        }

        for (int i = 0; i < 4; i++) {

            //사용할 연산자가 있는 경우
            if (operator[i]>0){
                //연산자를 사용햇으니 빼준다.
                operator[i]--;
                if (i==0){//더하기
                    dfs(curNum+number[nextIdx], nextIdx+1);
                }else if (i==1){//빼기
                    dfs(curNum-number[nextIdx], nextIdx+1);
                }else if (i==2){//곱하기
                    dfs(curNum*number[nextIdx], nextIdx+1);
                }else if (i==3){//나누기
                    dfs(curNum/number[nextIdx], nextIdx+1);
                }
                //다른 경우의 수에서 사용할 수 있도록 연산자를 더해준다.
                operator[i]++;
            }
        }
    }
}