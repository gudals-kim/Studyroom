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
        Integer[] nArr = new Integer[N];
        st = new StringTokenizer(br.readLine()); // 2번째 줄(nArr)
        for (int n=0; n<N; n++){
            nArr[n] = Integer.parseInt(st.nextToken());
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
        nArr = [카드번호,...]
        mArr = [[카드번호,인덱스],...]
        카드번호 순으로 내림차순 정렬
         */
        Arrays.sort(nArr, ((o1, o2) -> Integer.compare(o2,o1)));
        Arrays.sort(mArr, ((o1, o2) -> Integer.compare(o2[0],o1[0])));

        int[] ans = new int[M];//정답이 들어갈 배열
        int idxN = 0; // arrN을 조회할 인덱스
        int idxM = 0; // arrM을 조회할 인덱스
        
        while (idxM<M){// arrM을 모두 조회했다면 탈출

            if (idxN>N-1){// arrN의 인덱스가 마지막 인덱스라면
                idxN=N-1;// 계속 마지막 인덱스로 초기화
            }
            int ansIdx = mArr[idxM][1]; //정답 배열의 인덱스는 mArr의 정렬전 인덱스
            //두 배열이 값이 같을때
            if (nArr[idxN]==mArr[idxM][0]){
                ans[ansIdx] = 1;//정답 인덱스를 증가 =1로 초기화 해도 무관함.
                idxN++;//n 배열 다음 인덱스로
                idxM++;//m 배열 다음 인덱스로
                continue;
            }
            //nArr보다 mArr가 클때
            if (nArr[idxN]<mArr[idxM][0]){
                ans[ansIdx] = 0; //안해도 되지만 가독성을 위해 적음
                idxM++;//m 배열만 다음 인덱스로
                continue;
            }
            //mArr보다 nArr가 클때
            if (nArr[idxN]>mArr[idxM][0]){
                ans[ansIdx] = 0; //안해도 되지만 가독성을 위해 적음
                idxN++;//n 배열만 다음 인덱스로
                if (idxM==M-1){//단, M배열의 인덱스가 마지막 인덱스라면 탈출한다.
                    break;
                }
            }
        }
        
        //답안 출력
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}