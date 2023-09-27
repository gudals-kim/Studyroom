import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static String[][] map;
    static ArrayList<Node> waterNodes = new ArrayList<>();
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        Node startNode = null;
        Node endNode = null;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(input.charAt(j));
                if (map[i][j].equals("*"))waterNodes.add(new Node(i,j,0));
                if (map[i][j].equals("S"))startNode=new Node(i,j,0);
                if (map[i][j].equals("D"))endNode=new Node(i,j,0);
            }
        }

        int ans = getMinDist(startNode, endNode);
        if (ans==-1){
            System.out.println("KAKTUS");
        }else {
            System.out.println(ans);
        }

    }
    static int getMinDist(Node startNode, Node endNode){
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[R][C];
        boolean[] waterVisit = new boolean[R*C];
        q.add(startNode);
        while (!q.isEmpty()){
            Node node = q.poll();
            if (node.x== endNode.x&&node.y== endNode.y){
                return node.cnt;
            }
            if (visit[node.x][node.y]) continue;
            visit[node.x][node.y] = true;

            //물 번지기 채우기 로직
            if (!waterVisit[node.cnt]){
                waterVisit[node.cnt]=true;
                ArrayList<Node> temp = new ArrayList<>();
                for (Node waterNode : waterNodes) {
                    for (int[] mv : move) {
                        int dx = mv[0] + waterNode.x;
                        int dy = mv[1] + waterNode.y;
                        if (dx<0||dx>=R||dy<0||dy>=C||(dx== endNode.x&&dy== endNode.y)||(dx==node.x&&dy==node.y)||map[dx][dy].equals("*")||map[dx][dy].equals("X")) continue;
                        map[dx][dy] = "*";
                        temp.add(new Node(dx,dy,0));
                    }
                }
                waterNodes.addAll(temp);
            }
            //물 번지기 로직 끝

            for (int[] mv : move) {
                int dx = mv[0] + node.x;
                int dy = mv[1] + node.y;
                if (dx<0||dx>=R||dy<0||dy>=C||visit[dx][dy]||map[dx][dy].equals("*")||map[dx][dy].equals("X"))continue;
                q.add(new Node(dx,dy,node.cnt+1));
            }
        }
        return -1;
    }
}
class Node{
    int x;
    int y;
    int cnt;
    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}