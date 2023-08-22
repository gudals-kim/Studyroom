import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] getEnergy, map, deadTreeEnergy;
    static PriorityQueue[][] trees;
    static ArrayDeque<Tree> newTrees;
    static int[][] move = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 땅의 크기 N * N
        M = Integer.parseInt(st.nextToken()); // 나무의 개수
        K = Integer.parseInt(st.nextToken()); // K 년이 지났을때, 살아있는 나무를 구해라

        getEnergy = new int[N][N]; //좌표마다 매년 추가될 양분
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                getEnergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map = new int[N][N];//좌표마다 존재하는 양분
        deadTreeEnergy = new int[N][N];//죽은 나무의 양분들이 들어갈거임
        trees = new PriorityQueue[N][N]; // 좌표마다 존재하는 나무들
        newTrees = new ArrayDeque<Tree>(); // 새롭게 자라나는 나무들
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 5;//처음의 양분 5로 초기화
                trees[i][j] = new PriorityQueue<Tree>((o1, o2) -> Integer.compare(o1.age, o2.age));// 나무 위치 배열 초기화
            }
        }

        //나무 M개를 받아준다.
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(new Tree(x,y,age));//각 좌표에 나무를 넣는다.
        }


        // K년 돌린다.
        for (int i = 0; i < K; i++) {
            //봄
            spring();
            //여름
            summer();
            //가을
            fall();
            //겨울
            winter();
        }

        System.out.println(getAliveTree());
    }
    //봄 (각 땅에서 나무로 양분이 들어간다 -> 나이가 어린 나무부터 양분이 들어간다.)
    static void spring(){
        
        //각 좌표마다 양분조회 -> 나무에게 양분이 빠진 후 -> 남은 양분 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int energy = map[i][j]; //현재 땅에 있는 양분
                PriorityQueue<Tree> getTree = trees[i][j];//현재 땅에 있는 나무들
                PriorityQueue<Tree> temp = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.age, o2.age));
                //트리가 빌 때까지
                while (!getTree.isEmpty()){
                    //나이가 어린 나무부터 올거임
                    Tree tree = getTree.poll();
                    //만약 현재 양분보다 나무 나이가 적다면
                    if (energy<tree.age){
                        //나무는 죽을거임
                        deadTreeEnergy[i][j] += (tree.age/2); //죽은 나무들의 양분 배열에 저장
                        continue;
                    }
                    //양분이 더 많으면
                    energy -= tree.age;//땅에 양분 빼기
                    tree.age++;//나이 증가
                    addTree(tree);//트리나이가 5의 배수 일때 번식 한다.
                    temp.add(tree);//산 나무넣기
                }
                map[i][j] = energy;//남은 양분 저장
                trees[i][j] = temp;//산 나무들 저장
            }
        }


    }

    //여름 -> 봄에 죽은 나무가 양분으로 변한다.(죽은 나무의 나이를 2로 나눈 값을 나무가 있던 칸에 추가)
    static void summer(){

        // 모든 죽은 나무들의 양분 배열에서 -> 현재 땅에 존재하는 양분 배열에 옮겨준다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += deadTreeEnergy[i][j];
                deadTreeEnergy[i][j] = 0;
            }
        }

    }
    //가을 -> 나무 번식 나무의 나이가 5의 배수이면 인접한 8개 칸에 나이가 1인 나무가 생긴다.
    static void fall(){
        while(!newTrees.isEmpty()){
            Tree tree = newTrees.poll();
            trees[tree.x][tree.y].add(tree);
        }
    }

    //겨울 -> 각 땅에 양분 추가
    static void winter(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += getEnergy[i][j];
            }
        }
    }
    //나무를 받아서 만약 5의 배수라면 newTrees 에 새로운 나무 추가
    static void addTree(Tree tree) {
        if (tree.age%5==0){
            for (int[] mv : move) {
                int dx = mv[0] + tree.x;
                int dy = mv[1] + tree.y;
                if (dx>=0&&dx<N&&dy>=0&&dy<N){// 좌표내 땅에 존재할 수 있다면
                    newTrees.add(new Tree(dx,dy,1));//새로운 나무 추가
                }
            }
        }
    }
    //현재 살아있는 나무 개수를 가져온다.
    static int getAliveTree(){
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += trees[i][j].size();
            }
        }
        return result;
    }
}
class Tree{

    int x;
    int y;
    int age;

    @Override
    public String toString() {
        return "("
                + age +
                ')';
    }

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}