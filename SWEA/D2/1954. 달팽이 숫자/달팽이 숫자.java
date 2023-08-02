import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n]; //숫자를 저장할 배열
            int y = 0; // 배열을 이동할 y 좌표
            int x = -1; // 배열을 이동할 x 좌표
            int X = n; // 최대 가로 길이
            int Y = n-1; // 최대 세로 길이(최대 가로길이보다 1적다)
            int cnt = 0; //탈출 조건 
            int num = 0; // 배열에 넣을 숫자
            int N = n*n; //총 배열의 크기
            while (cnt<(N)){
                //우
                for (int i = 0; i < X && cnt<N; i++) {
                    arr[y][++x] = ++num;
                    cnt++;
                }
                X--;
                //하
                for (int i = 0; i < Y && cnt<N; i++) {
                    arr[++y][x] = ++num;
                    cnt++;
                }
                Y--;
                //좌
                for (int i = 0; i < X && cnt<N; i++) {
                    arr[y][--x] = ++num;
                    cnt++;
                }
                X--;
                //상
                for (int i = 0; i < Y && cnt<N; i++) {
                    arr[--y][x] = ++num;
                    cnt++;
                }
                Y--;
            }
            
            //출력
            sb.append("#").append(testcase).append("\n");
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}