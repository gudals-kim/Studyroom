
import java.util.*;
import java.io.*;

public class Solution {
    static int M, A, ans;
    static int[] moveUserA, moveUserB;
    static int[] ansA, ansB;
    static Charger[] chargers;
    static int[][] move = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveUserA = new int[M+1];
            ansA = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M+1; i++) {
                moveUserA[i] = Integer.parseInt(st.nextToken());
            }

            moveUserB = new int[M+1];
            ansB = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < M+1; i++) {
                moveUserB[i] = Integer.parseInt(st.nextToken());
            }

            chargers = new Charger[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers[i] = new Charger(x,y,c,p);
            }

            ans = 0;
            User userA = new User(0,0);
            User userB = new User(9,9);
            for (int i = 0; i < M+1; i++) {
                userA.x = userA.x+move[moveUserA[i]][0];
                userA.y = userA.y+move[moveUserA[i]][1];
                userB.x = userB.x+move[moveUserB[i]][0];
                userB.y = userB.y+move[moveUserB[i]][1];
                process(userA, userB, i);
            }
            
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static PriorityQueue<Charger> getSelectCharger(User user){
        PriorityQueue<Charger> chargerQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.performance, o1.performance));
        for (Charger charger : chargers) {
            if (getDist(user, charger) > charger.coverage) continue;
            chargerQueue.add(charger);
        }
        return chargerQueue;
    }
    static void process(User userA, User userB, int time){
        //두 유저가 같은 자리에 있을때
        if (userA.x==userB.x&&userA.y==userB.y){
            PriorityQueue<Charger> selectChargers = getSelectCharger(userA);//같은 좌표
            if (selectChargers.size()==0) return;
            if (selectChargers.size()==1){
                //현재 위치에서 얻을 수 있는 충전기가 1개일 때,
                Charger charger = selectChargers.poll();
                ansA[time] = charger.performance/2;
                ansB[time] = charger.performance/2;
            }else {
                //현재 위치에서 얻을 수 있는 충전기가 1개 이상일때
                Charger chargerA = selectChargers.poll();
                Charger chargerB = selectChargers.poll();
                ansA[time] = chargerA.performance;
                ansB[time] = chargerB.performance;
            }
        }else {//같은 자리에 없을 때,
            PriorityQueue<Charger> selectUserAChargers = getSelectCharger(userA);
            PriorityQueue<Charger> selectUserBChargers = getSelectCharger(userB);

            if (selectUserAChargers.size()==0&&selectUserBChargers.size()==0) return;//둘다 접속할 수 있는 충전기가 없을때
            else if (selectUserAChargers.size()==0){//A만 접속할 수 있는 충전기가 없을때
                Charger chargerB = selectUserBChargers.poll();
                ansA[time] = 0;
                ansB[time] = chargerB.performance;
            } else if (selectUserBChargers.size()==0) {//B만 접속할 수 있는 충전기가 없을때
                Charger chargerA = selectUserAChargers.poll();
                ansA[time] = chargerA.performance;
                ansB[time] = 0;
            } else if (selectUserAChargers.size()==1&&selectUserBChargers.size()==1) {
                //두 사람 다 접속할 수 있는 충전기가 1개일때
                Charger chargerA = selectUserAChargers.poll();
                Charger chargerB = selectUserBChargers.poll();
                if (chargerA.x==chargerB.x&&chargerA.y==chargerB.y){
                    //1개인 충전기가 둘 다 같을때
                    ansA[time] = chargerA.performance/2;
                    ansB[time] = chargerB.performance/2;
                }else {
                    //1개인 충전기가 둘이 다를때
                    ansA[time] = chargerA.performance;
                    ansB[time] = chargerB.performance;
                }
            } else if (selectUserAChargers.size()==1) {
                //user A가 사용할 수 있는 충전기기가 1개일때 B는 두개 이상
                Charger chargerA = selectUserAChargers.poll();
                Charger chargerB = selectUserBChargers.poll();
                if (chargerA.x==chargerB.x&&chargerA.y==chargerB.y){
                    Charger chargerB2 = selectUserBChargers.poll();
                    ansA[time] = chargerA.performance;
                    ansB[time] = chargerB2.performance;
                }else {
                    ansA[time] = chargerA.performance;
                    ansB[time] = chargerB.performance;
                }
            } else if (selectUserBChargers.size()==1) {
                //user B가 사용할 수 있는 충전기기가 1개일때 A는 두개 이상
                Charger chargerA = selectUserAChargers.poll();
                Charger chargerB = selectUserBChargers.poll();
                if (chargerA.x==chargerB.x&&chargerA.y==chargerB.y){
                    Charger chargerA2 = selectUserAChargers.poll();
                    ansA[time] = chargerA2.performance;
                    ansB[time] = chargerB.performance;
                }else {
                    ansA[time] = chargerA.performance;
                    ansB[time] = chargerB.performance;
                }
            } else {
                //두 사람 다 접속할 수 있는 충전기기가 2개 이상일때
                Charger chargerA = selectUserAChargers.poll();
                Charger chargerB = selectUserBChargers.poll();
                if (chargerA.x==chargerB.x&&chargerA.y==chargerB.y){
                    //가장 출력이 좋은 충전기가 둘이 같을때
                    Charger chargerA2 = selectUserAChargers.poll();
                    Charger chargerB2 = selectUserBChargers.poll();
                    if (chargerA2.performance>chargerB2.performance){
                        ansA[time] = chargerA2.performance;
                        ansB[time] = chargerB.performance;
                    }else {
                        ansA[time] = chargerA.performance;
                        ansB[time] = chargerB2.performance;
                    }
                }else {
                    //가장 출력이 좋은 충전기가 둘이 다를때
                    ansA[time] = chargerA.performance;
                    ansB[time] = chargerB.performance;
                }
            }
        }
        ans += (ansA[time]+ansB[time]);
    }
    static int getDist(User user, Charger charger){
        return Math.abs(user.x-charger.x) + Math.abs(user.y-charger.y);
    }

}
class User{
    int x;
    int y;

    public User(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class Charger{
    int x;
    int y;
    int coverage;
    int performance;

    public Charger(int x, int y, int coverage, int performance) {
        this.x = x;
        this.y = y;
        this.coverage = coverage;
        this.performance = performance;
    }

}
