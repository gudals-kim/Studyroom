import java.io.*;
import java.util.*;
public class Solution {
public static int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = stones.length;
        int[] maxValues = new int[n - k + 1];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // 현재 원소보다 작은 원소들은 큐에서 제거
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 현재 원소보다 작거나 같은 값들은 큐에서 제거
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            // 현재 원소를 큐에 추가
            deque.addLast(i);

            // 현재 연속 집합의 크기가 k에 도달하면 최댓값 저장
            if (i >= k - 1) {
                maxValues[i - k + 1] = stones[deque.peekFirst()];
            }
        }

        // 최솟값 계산
        for (int max : maxValues) {
            result = Math.min(result, max);
        }

        return result;
    }
}