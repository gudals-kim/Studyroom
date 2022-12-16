import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/재귀_문제/input/input_1074.txt"

p = psutil.Process()
rss = p.memory_info().rss / 2 ** 20 # Bytes to MB

sys.stdin = open(inputData,"r")
startTime = time.time()
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    def visited(n, r, c):
        global result

        # 찾는 좌표라면 res를 출력하고 종료
        if r == R and c == C:
            print(int(result))
            return

        # 탐색 증인 배열 중에 찾는 좌표가 없다면 좌표에 크기를 더한다.
        if not (r <= R < r + n and c <= C < c + n):
            result += n * n
            return

        # 1/2/3/4사분면을 재귀적으로 탐색
        visited(n / 2, r, c)  # 1사분면
        visited(n / 2, r, c + n / 2)  # 2사분면
        visited(n / 2, r + n / 2, c)  # 3사분면
        visited(n / 2, r + n / 2, c + n / 2)  # 4사분면


    N, R, C = map(int, sys.stdin.readline().split())
    result = 0

    # 2^n을 0, 0부터 탐색
    visited(2 ** N, 0, 0)

    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")