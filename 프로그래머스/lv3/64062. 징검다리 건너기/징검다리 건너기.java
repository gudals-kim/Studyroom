import java.io.*;

public class Solution {
    static int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;    
        int max = 200000000;
        while(min<=max){
            int mid = (min+max)/2;
            if(isCrossable(stones, k, mid)){
                min = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                max = mid-1;
            }
        }
        return answer;
    }

    static Boolean isCrossable(int[] stones, int k, int mid){
        int howFarAtOnce = 0;
        for(int num: stones){
            if(num - mid < 0) howFarAtOnce++;
            else howFarAtOnce = 0;
            if(howFarAtOnce==k) return false;
        }
        return true;
    }
}