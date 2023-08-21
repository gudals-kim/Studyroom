
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char [][] good = new char[N][N];
        char [][] bad =  new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char color = input.charAt(j);
                good[i][j] = color;
                if (color=='G'||color=='R'){
                    bad[i][j] = 'G';
                }
            }
        }
        System.out.println(bfs(good)+" "+bfs(bad));


    }
    static int bfs(char[][] arr){
        int result = 0;
        ArrayDeque<Color> q = new ArrayDeque<Color>();
        int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                q.addFirst(new Color(i,j));
                while (!q.isEmpty()){

                    Color node = q.pollLast();
                    if (visited[node.x][node.y]) continue;
                    visited[node.x][node.y] = true;

                    for (int[] mv : move) {
                        int dx = mv[0] + node.x;
                        int dy = mv[1] + node.y;
                        if (dx<0||dx>=N||dy<0||dy>=N||visited[dx][dy]||arr[node.x][node.y]!=arr[dx][dy])continue;
                        q.addFirst(new Color(dx,dy));
                    }
                }
                result++;
            }
        }
        return result;
    }


}
class Color{
    int x;
    int y;

    public Color(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
