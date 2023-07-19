import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = 0;
        int answer;
        int last;
        while(true){
            n++;
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L==0 && P==0 && V==0){
                break;
            }

            answer = L*(V/P);
            last = V%P;
            if (last>=L){
                answer+=L;
                sb.append("Case "+n+": "+answer).append("\n");
            }
            else {
                answer+=last;
                sb.append("Case "+n+": "+answer).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}