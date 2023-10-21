import java.io.*;
import java.util.*;

public class Main {
    static double ans;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        ans = -1;
        process(N,3,0,0,new Point[3]);
        System.out.println(ans);
    }
    static void process(int n, int r,int start, int cnt, Point[] result){
        if (cnt==r){
            ans = Math.max(ans, getArea(result));
            return;
        }
        for (int i = start; i < n; i++) {
            result[cnt] = points[i];
            process(n,r,i+1,cnt+1,result);
        }
    }
    static double getArea(Point[] pickPoints){
        Point one = pickPoints[0];
        Point two = pickPoints[1];
        Point three = pickPoints[2];
        int temp1 = (one.x*two.y) + (two.x*three.y) + (three.x * one.y);
        int temp2 = (one.y*two.x) + (two.y*three.x) + (three.y * one.x);
        return Math.abs(temp1-temp2) * 0.5;
    }

}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}