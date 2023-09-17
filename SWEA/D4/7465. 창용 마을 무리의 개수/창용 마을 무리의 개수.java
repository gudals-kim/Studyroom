/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static ArrayList[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken())+1;
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N];
            for (int i = 1; i < N; i++) {
                graph[i] = new ArrayList();
            }
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int leftNode = Integer.parseInt(st.nextToken());
                int rightNode = Integer.parseInt(st.nextToken());

                graph[leftNode].add(rightNode);
                graph[rightNode].add(leftNode);
            }

            int ans = 0;
            boolean[] visited = new boolean[N];
            for (int i = 1; i < N; i++) {
                if (visited[i]) continue;
                ans ++;
                bfs(i, visited);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int startNode, boolean[] visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        while (!q.isEmpty()){
            Integer node = q.poll();
            if (visited[node]) continue;
            visited[node] = true;

            ArrayList<Integer> nextNodes = graph[node];
            for (Integer nextNode : nextNodes) {
                if (visited[nextNode]) continue;
                q.add(nextNode);
            }
        }
    }
}