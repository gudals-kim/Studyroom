import java.util.*;
import java.io.*;
class Solution {
        public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int end = n;
        int left = 0;
        int right = 0;
        for(int i : stations){
            if(right > i-w){
                left = right;
            }else{
                left = i-w;
            }
            right = i+w;
            if (left>start){
                int plus = 0;
                if ((left-start)%(2*w+1) != 0){
                    plus = 1;
                }
                answer += (left-start)/(2*w+1) + plus;
            }
            start = right+1;
        }
        if (start < end){
            left = end;
            int plus = 0;
                if ((left-start)%(2*w+1) != 0){
                    plus = 1;
                }
            answer += (left-start)/(2*w+1) + plus;
        }else if (start==end){
            answer++;
        }


        return answer;
    }
}