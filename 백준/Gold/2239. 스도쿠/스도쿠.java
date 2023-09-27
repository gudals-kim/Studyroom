import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static HashSet[] chkRows, chkCols, chkBoxes;
    static ArrayList<Node> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        chkRows = new HashSet[9];
        chkCols = new HashSet[9];
        chkBoxes = new HashSet[9];
        nodes = new ArrayList<>();
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            chkRows[i] = new HashSet<Integer>();
            chkCols[i] = new HashSet<Integer>();
            chkBoxes[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                int num = input.charAt(j) - '0';
                arr[i][j] = num;
                if (num==0){
                    nodes.add(new Node(i,j));
                    continue;
                }
                chkRows[i].add(num);
                chkCols[j].add(num);
                chkBoxes[getBoxIndex((i/3),(j/3))].add(num);
            }
        }


        dfs(nodes.size(), 0);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
    static boolean dfs(int n, int cnt){
        if (n==cnt){
            return true;
        }
        Node node = nodes.get(cnt);
        for (int i = 1; i <= 9; i++) {
            if (chkCols[node.y].contains(i)
                    ||chkRows[node.x].contains(i)
                    ||chkBoxes[getBoxIndex(node.x/3, node.y/3)].contains(i)){
                continue;
            }
            arr[node.x][node.y] = i;
            chkCols[node.y].add(i);
            chkRows[node.x].add(i);
            chkBoxes[getBoxIndex(node.x/3, node.y/3)].add(i);
//            System.out.println("arr["+node.x+"]["+node.y+"] = "+i);
            if (dfs(n, cnt+1)){
                return true;
            }
//            System.out.println("arr["+node.x+"]["+node.y+"] = "+i+" 는 실패");
            arr[node.x][node.y] = 0;
            chkCols[node.y].remove(i);
            chkRows[node.x].remove(i);
            chkBoxes[getBoxIndex(node.x/3, node.y/3)].remove(i);
        }
        return false;
    }
    static int getBoxIndex(int i, int j){
        int result = 9;
        if (i == 0 && j == 0){
            result = 0;
        } else if (i == 0 && j == 1) {
            result = 1;
        } else if (i == 0 && j == 2) {
            result = 2;
        } else if (i == 1 && j == 0) {
            result = 3;
        } else if (i == 1 && j == 1) {
            result = 4;
        } else if (i == 1 && j == 2) {
            result = 5;
        } else if (i == 2 && j == 0) {
            result = 6;
        } else if (i == 2 && j == 1) {
            result = 7;
        } else if (i == 2 && j == 2) {
            result = 8;
        }
        return result;
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}