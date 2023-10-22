import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }


        Arrays.sort(inputs); //정렬을 하면 비슷한 접두사를 가진 단어가 같이 위치한다.

        ans = findMaxSubsetSize(inputs);

        System.out.println(ans);
    }

    // 최대 접두사X 집합의 크기를 찾는 함수 (startWith = 접두어 찾는 메소드)
    private static int findMaxSubsetSize(String[] inputs) {
        int maxSubsetSize = 1;  // 최소한 한 단어는 항상 포함됨

        for (int i = 1; i < inputs.length; i++) {
            if (!inputs[i].startsWith(inputs[i - 1])) {//현재 단어가 이전 단어의 접두사가 아닌 경우
                maxSubsetSize++;// 같은 집단에 있어도 되기때문에 1을 증가시켜준다.
            }
        }

        return maxSubsetSize;
    }

}
