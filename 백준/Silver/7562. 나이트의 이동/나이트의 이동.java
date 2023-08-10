import java.io.*;
import java.util.*;

public class Main{
    static int[][] dist;
    static int len;
    static int[][] move;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            len = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            Node startNode = new Node(startX, startY,0);

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            //이동할수 있는 곳
            move = new int[][] {
                    {-2,-1}, {-1,-2}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {2,1}, {1,2}};

            int[][] dijkstra = dijkstra(startNode);
            sb.append(dijkstra[endX][endY]).append("\n");


        }
        System.out.println(sb);


    }

    static int[][] dijkstra(Node startNode){

        boolean[][] visited = new boolean[len][len];

        dist = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(startNode);
        dist[startNode.x][startNode.y] = 0;

        while (!queue.isEmpty()){

            Node node = queue.poll();

            if (visited[node.x][node.y])continue;
            visited[node.x][node.y] = true;

            for (int[] mv : move) {
                int dx = node.x + mv[0];
                int dy = node.y + mv[1];

                if (dx<0||dx>=len||dy<0||dy>=len||visited[dx][dy]) continue;
                if (dist[dx][dy] > dist[node.x][node.y]+1){
                    dist[dx][dy] = dist[node.x][node.y]+1;
                    Node nextNode = new Node(dx,dy,dist[dx][dy]);
                    queue.add(nextNode);
                }

            }
        }

        return dist;
    }



}

class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}