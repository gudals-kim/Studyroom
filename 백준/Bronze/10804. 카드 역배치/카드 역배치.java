import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[] arr = new int[20];
        for (int i=0;i<20;i++){
            arr[i] = i+1;
        }

        for (int n=0; n<10; n++){

            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;

            int[] sliceArr = slice(f, s, arr);
            int[] reservedArr = reserve(sliceArr);
            arr = sumArr(arr, reservedArr, f, s);

        }
        for (int num:arr){
            System.out.print(num+" ");
        }



    }
    static int[] sumArr(int[] arr, int[] reservedArr, int f, int s){

        for (int idx=f; idx<(s+1); idx++){
            arr[idx] = reservedArr[idx-f];
        }

        return arr;
    }

    static int[] slice(int f, int s, int[] arr){
        int[] resultArr = new int[s-f+1];

        for (int idx=f; idx<(s+1); idx++){
            resultArr[idx-f] = arr[idx];
        }


        return resultArr;
    }



    static int[] reserve(int[] arr){
        int[] resultArr = new int[arr.length];

        for (int idx=0; idx<arr.length; idx++){
            resultArr[idx] = arr[arr.length-idx-1];
        }
        return resultArr;
    }
}
