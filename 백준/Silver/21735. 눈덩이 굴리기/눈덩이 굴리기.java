import java.io.*;
import java.util.*;

public class Main{
    static int ans;
    static int N;
    static int M;
    static int[] A;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        ans = -1;
        // 처음 눈사람의 크기는 1이다.
        dfs(0,1,0);
        System.out.println(ans);
    }

    /**
     *
     * @param idx 거리
     * @param size 눈사람 크기
     * @param time 대회시간
     */
    static void dfs(int idx, int size, int time){

        //시간이 M을 초과하면 끝
        if (time > M) return;

        //시간을 초과하지 않으면 눈덩이 크기를 비교해서 최댓값을 저장한다.
        ans = Math.max(ans, size);


        //눈덩이 굴리기 case 1
        if (idx < N){
            dfs(idx+1, size+A[idx+1], time+1);
        }

        //눈덩이 굴리기 case 2
        if (idx < N-1){
            dfs(idx+2, size/2+A[idx+2], time+1);
        }
    }


}
