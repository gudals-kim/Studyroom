import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        //------------ 입력 start-------------
        st = new StringTokenizer(br.readLine()); // 1번째 줄(n)
        int N = Integer.parseInt(st.nextToken());
        int[][] nArr = new int[N][2];
        st = new StringTokenizer(br.readLine()); // 2번째 줄(nArr)
        for (int n=0; n<N; n++){
            nArr[n] = new int[] {Integer.parseInt(st.nextToken()), n};
        }

        st = new StringTokenizer(br.readLine()); // 3번째 줄 (m)
        int M = Integer.parseInt(st.nextToken());
        int[][] mArr = new int[M][2];
        st = new StringTokenizer(br.readLine()); // 4번째 줄 (mArr)
        for (int m=0; m<M; m++){
            mArr[m] = new int[] {Integer.parseInt(st.nextToken()), m};
        }
        //--------------입력 end---------------
        /*
        nArr,mArr = [[카드번호,인덱스],...]
        카드번호 순으로 정렬
         */
        Arrays.sort(nArr, ((o1, o2) -> Integer.compare(o2[0],o1[0])));
        Arrays.sort(mArr, ((o1, o2) -> Integer.compare(o2[0],o1[0])));

        int[] ans = new int[M];
        int idxN = 0;
        int idxM = 0;
        while (idxM<M){
            if (idxN>N-1){
                idxN=N-1;
            }
            int ansIdx = mArr[idxM][1];
            if (nArr[idxN][0]==mArr[idxM][0]){
                ans[ansIdx]++;
                idxM++;
                idxN++;
                continue;
            }
            if (nArr[idxN][0]<mArr[idxM][0]){
                ans[ansIdx] = 0; //안해도 되지만 가독성을 위해 적음
                idxM++;
                continue;
            }
            if (nArr[idxN][0]>mArr[idxM][0]){
                ans[ansIdx] = 0; //안해도 되지만 가독성을 위해 적음
                idxN++;
                if (idxM==M-1){
                    break;
                }
            }
        }

        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}