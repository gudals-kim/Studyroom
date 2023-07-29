import java.io.*;
import java.util.*;

public class Main{
    static int ans = 0;
    static int[] yArr;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(
                new StringTokenizer(
                        new BufferedReader(new InputStreamReader(System.in))
                                .readLine()).nextToken());
        yArr = new int[n];
        dfs(n,0);
        System.out.println(ans);
    }

    static void dfs(int n, int x){
        if (n==x){
            ans++;
            return;
        }
        //x번째 행의 각 열에 Queen을 둔다고 가정한다.
        for (int y=0; y<n; y++){
            yArr[x] = y;
            if (isQueenGoThere(x)){//이 x의 위치에 Queen을 두어도 괜찮은 경우에
                dfs(n,x+1);//다음 x로 넘어간다.
            }
        }

    }
    static Boolean isQueenGoThere(int x){
        //이전 행에서 놓았던 모든 Queen들을 확인한다.
        for (int idx = 0; idx < x; idx++) {
            // 위쪽 혹은 대각선을 확인한다.
            if (yArr[x] == yArr[idx]||Math.abs(yArr[x]-yArr[idx])==x-idx){
                return false;
            }
        }
        return true;
    }
}