import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static HashSet<Integer> member;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        member = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            member.add(i);
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(N,N/2,0,0,new int[N/2]);
        System.out.println(ans);
    }
    static void comb(int n, int r, int cnt, int start, int[] team){
        if (cnt==r){
            HashSet<Integer> teamA = new HashSet<>();
            for (int i : team) {
                teamA.add(i);
            }
            member.removeAll(teamA);
            ans = Math.min(ans,calculator(teamA, member));
            member.addAll(teamA);
            return;
        }
        for (int i = start; i < n; i++) {
            team[cnt] = i;
            comb(n,r,cnt+1,i+1,team);
        }
    }
    static int calculator(HashSet<Integer> teamA, HashSet<Integer> teamB){
        int scoreA = getTeamScore(teamA);
        int scoreB = getTeamScore(teamB);
        return Math.abs(scoreA-scoreB);
    }

    static int getTeamScore(HashSet<Integer> team) {
        int result = 0;
        for (Integer perA : team) {
            for (Integer perB : team) {
                result += arr[perA][perB];
            }
        }
        return result;
    }

}