import java.io.*;
import java.util.*;

public class Main {
    static int ans, K;
    static int[][] mags = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                mags[i][j]=input.charAt(j)-'0';
            }
        }
        ans = 0;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int comb = Integer.parseInt(st.nextToken());
            process("start", num, comb);
        }
        ans = mags[0][0]*1 + mags[1][0]*2 + mags[2][0]*4 + mags[3][0]*8;
        System.out.println(ans);
    }
    private static void process(String preComb, int num, int comb) {
        boolean rightRun = preComb.equals("right") && num+1<4 && mags[num][2]!=mags[num+1][6];
        boolean leftRun = preComb.equals("left") && num-1>=0 && mags[num-1][2]!=mags[num][6];
        if (preComb.equals("start")){
            rightRun = num+1<4 && mags[num][2]!=mags[num+1][6];
            leftRun = num-1>=0 && mags[num-1][2]!=mags[num][6];
        }

        //현재 톱니바퀴를 돌려주자.
        if (comb==1){
            //comb = 1 시계로 돌리기
            int[] temp = new int[8];
            for (int i = 0; i < 8; i++) {
                int idx = i+1;
                if (idx==8) idx=0;
                temp[idx] = mags[num][i];
            }
            mags[num] = temp;
        } else if (comb==-1) {
            //comb = -1 반시계로 돌리기
            int[] temp = new int[8];
            for (int i = 0; i < 8; i++) {
                int idx = i-1;
                if (idx==-1) idx=7;
                temp[idx] = mags[num][i];
            }
            mags[num] = temp;
        }

        if (rightRun)process("right", num+1, comb*(-1));//오른쪽 돌리기
        if (leftRun)process("left", num-1, comb*(-1));//왼쪽 돌리기
    }
}

