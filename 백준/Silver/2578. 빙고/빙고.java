

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        // 철수 빙고 입력

        int[] userChkX = new int[5];
        int[] userChkY = new int[5];
        // 4,0 3,1 2,2 1,3 0,4 -> |x-dx| - |y-dy| = 0
        int diagonalUp = 0;
        // 0,0 1,1 2,2 3,3 4,4 -> |x+dx| - |y+dy| = 0
        int diagonalDown = 0;
        HashMap<Integer, BingGoNode> bingoMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingoMap.put(num, new BingGoNode(i,j,num));
            }
        }
        //사회자가 부르는 수들 입력

        for (int i = 0; i < 25; i++) {
            if (i==0||i%5==0){
                st = new StringTokenizer(br.readLine());
            }
            int num = Integer.parseInt(st.nextToken());

            BingGoNode bingGoNode = bingoMap.get(num);
            userChkX[bingGoNode.x]++;
            userChkY[bingGoNode.y]++;
            if ((bingGoNode.x+bingGoNode.y)==4){
                diagonalUp++;
            }
            if (bingGoNode.x==bingGoNode.y){
                diagonalDown++;
            }
            int bingo = 0;
            bingo+=isLineChk(userChkX);
            bingo+=isLineChk(userChkY);

            if (diagonalUp>4){
                bingo++;
            }
            if (diagonalDown>4){
                bingo++;
            }

            if (bingo>2){
                System.out.println(i+1);
                break;
            }
        }

    }
    static int isLineChk(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>4){
                result++;
            }
        }
        return result;
    }
}
class BingGoNode{
    int x;
    int y;
    int num;

    public BingGoNode(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}