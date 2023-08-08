import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < N; x++) {
                arr[y][x] = Integer.parseInt(String.valueOf(line.charAt(x)));
            }
        }
        Roof(0,0,N);
        System.out.println(sb);

    }

    static void Roof(int x, int y, int size){

        // 숫자가 한개만 나온경우
        if (isPossible(x, y, size)){
            sb.append(arr[y][x]);
            return;
        }
        // 숫자가 한개가 아닌경우

        int splitSize = size/2;

        sb.append("(");
        //좌상
        Roof(x, y, splitSize);
        //우상
        Roof(x+splitSize, y, splitSize);
        //좌하
        Roof(x, y+splitSize, splitSize);
        //우하
        Roof(x+splitSize, y+splitSize, splitSize);

        sb.append(")");



    }
    
    
    //숫자가 한개만 나오는지 판단
    static boolean isPossible(int x, int y, int size){
        int value = arr[y][x];
        for (int dy = y; dy < y+size; dy++) {
            for (int dx = x; dx < x+size; dx++) {
                if (value!=arr[dy][dx]) return false;
            }
        }
        return true;
    }



}