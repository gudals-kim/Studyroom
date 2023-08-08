import java.io.*;
import java.util.*;

public class Main{


    static ArrayList<Node>[][][] graph;
    static boolean[][][] canMove;
    static int L;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); //빌딩의 층수
            R = Integer.parseInt(st.nextToken()); //한층의 행
            C = Integer.parseInt(st.nextToken()); //한층의 열
            if (L==0&&R==0&&C==0) break;
            //입력 받기
            canMove= new boolean[L][R][C];
            graph = new ArrayList[L][R][C];
            Node startNode = null;
            Node endNode = null;
            for (int h = 0; h < L; h++) {
                for (int y = 0; y < R; y++) {
                    String line = br.readLine();
                    for (int x = 0; x < C; x++) {
                        char node = line.charAt(x);
                        graph[h][y][x] = new ArrayList<>();
                        if (node == 'S') {
                            startNode = new Node(h,x,y,0);
                        }
                        if (node == 'E') {
                            endNode = new Node(h,x,y,1);
                        }
                        if (node == '#') {
                            continue;
                        }
                        canMove[h][y][x] = true;
                    }
                }
                br.readLine();
            }


            //동,서,남,북,상,하//x,y,h가 들어감
            int[][] move = new int[][] {{1,0,0},{-1,0,0},{0,-1,0},{0,1,0},{0,0,1},{0,0,-1}};
            for (int h = 0; h < L; h++) {
                for (int y = 0; y < R; y++) {
                    for (int x = 0; x < C; x++) {
                        for (int[] mv : move) {
                            int dx = mv[0]+x;
                            int dy = mv[1]+y;
                            int dh = mv[2]+h;
                            if (dx<0||dx>=C||dy<0||dy>=R||dh<0||dh>=L||!canMove[dh][dy][dx]) continue;
                            graph[h][y][x].add(new Node(dh,dx,dy,1));
                        }
                    }
                }
            }

            int[][][] result = dijkstra(startNode);
            int dist = result[endNode.h][endNode.y][endNode.x];
            if (dist==Integer.MAX_VALUE){
                sb.append("Trapped!").append("\n");
            }else {
                sb.append("Escaped in ").append(dist).append(" minute(s).").append("\n");
            }
        }
        System.out.println(sb);

    }

    static int[][][] dijkstra(Node startNode){
        boolean[][][] check = new boolean[L][R][C];//방문 체크 배열
        int[][][] dist = new int[L][R][C]; // 출발지로부터 각 정점까지 거리
        for (int h = 0; h < L; h++) {
            for (int y = 0; y < R; y++) {
                Arrays.fill(dist[h][y],Integer.MAX_VALUE);
            }
        }
        //시작 노드에서 시작노드까지의 최소거리를 0으로 초기화
        dist[startNode.h][startNode.y][startNode.x] = 0;
        // 큐에 노드를 넣으면 cost가 더 작은 노드가 나오는 큐를 생성한다.
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        queue.add(startNode);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if (check[node.h][node.y][node.x]) continue;
            check[node.h][node.y][node.x] = true;

            ArrayList<Node> nextNodes = graph[node.h][node.y][node.x];
            for (Node nextNode : nextNodes) {
                if (dist[nextNode.h][nextNode.y][nextNode.x] > dist[node.h][node.y][node.x] + nextNode.cost){
                    dist[nextNode.h][nextNode.y][nextNode.x] = dist[node.h][node.y][node.x] + nextNode.cost;
                    queue.add(new Node(nextNode.h,nextNode.x,nextNode.y,dist[nextNode.h][nextNode.y][nextNode.x]));
                }

            }

        }
        return dist;
    }







}
class Node{
    int h;
    int x;
    int y;
    int cost;

    public Node(int h, int x, int y, int cost) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}