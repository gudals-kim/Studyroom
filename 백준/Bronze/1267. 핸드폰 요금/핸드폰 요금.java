
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int [n];
        int Y = 0;
        int M = 0;
        int divY = 0;
        int divM = 0;
        
        
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            int time = Integer.parseInt(st.nextToken());
            if(time%30==0 && time%60==0) {
            	divY = 1;
            	divM = 1;
            }else if (time%30==0 && time%60!=0) {
				divY = 0;
				divM = 1;
			}else if (time%30!=0 && time%60==0) {
				divY = 1;
				divM = 0;
			}else {
				divY = 1;
				divM = 1;
            }

            Y+=((time/30)+divY)*10;
            M+=((time/60)+divM)*15;
        }
        
        if(Y>M){
            System.out.print("M "+M);
        }
        if(Y==M){
            System.out.print("Y M "+Y);
        }
        if(Y<M){
            System.out.print("Y "+Y);
        }
        
        
        
        
        
    }
}