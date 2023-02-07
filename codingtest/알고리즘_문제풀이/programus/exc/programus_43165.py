import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/programus/input/programus_43165.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import deque
    n = int(input())
    numbers = list(map(int,input().split()))
    target = int(input())

    def solution(numbers, target):
        answer = 0
        queue = deque()
        n = len(numbers)
        queue.append([numbers[0], 0])
        queue.append([-1 * numbers[0], 0])
        while queue:
            node, idx = queue.popleft()
            idx += 1
            if idx < n:
                queue.append([node + numbers[idx], idx])
                queue.append([node - numbers[idx], idx])
            else:
                if node == target:
                    answer += 1
        return answer

    print(solution(numbers, target))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")