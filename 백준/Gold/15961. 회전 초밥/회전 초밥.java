
import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken()); // 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = left+k;
        int ans = 0; // 먹은 초밥 개수임
        int[] visited = new int[3001];
        for (int i = left; i < right; i++) {
            if (visited[arr[i]]==0){//먹지 않은 새로운 스시
                ans++;
            }
            visited[arr[i]]++;
        }
        int result = Integer.MIN_VALUE;
        result = Math.max(result,ans);// 답안처리

//        String string = Arrays.toString(arr);
        while (left<N){

            if (visited[arr[right]]==0){// 새로운 스시를 먹었다면
                ans++;//스시 먹은 종류 추가
            }
            visited[arr[right]]++; // 오른쪽 스시 먹어본 종류 횟수 올리고
            visited[arr[left]]--; // 왼쪽 스시 먹어본 종류 횟수 내린다.

            //이미 있는경우가 아닐때만 ans를 빼준다.
            if (visited[arr[left]]==0){
                ans--;
            }
            
            
            //추가 초밥을 먹어본다.
            if (visited[c]==0){//추가 초밥 종류가 처음먹는거라면
                result = Math.max(result,ans+1);// 답안처리
            }else {
                result = Math.max(result,ans);
            }



//            System.out.println(string);
//            System.out.println("나간번호 "+arr[left]);
//            System.out.println("추가번호 "+arr[right]);

            left = (left+1);
            right = (right+1);
            if (right==N){
                right = 0;
            }

//            System.out.println("현재 ans "+ans);
//            System.out.println(" left "+left);
//            System.out.println(" right "+right);
        }


        System.out.println(result);
    }


}
