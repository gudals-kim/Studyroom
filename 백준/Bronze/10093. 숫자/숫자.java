import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxNum = Math.max(a,b);
        int minNum = Math.min(a,b);
        int result = maxNum-minNum-1;
        if (maxNum==minNum){
            result = 0;
        }
        System.out.println(result);
        for (int i=minNum+1;i<maxNum;i++){
            System.out.print(i+" ");
        }


    }


}