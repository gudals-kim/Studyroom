import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/동적프로그래밍_문제/input/backjoon_1495.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    n, s, m = map(int, input().split())
    array = list(map(int, input().split()))

    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[0][s] = 1

    for i in range(1, n + 1):
        for j in range(m + 1):
            if dp[i - 1][j] == 0:
                continue
            if j - array[i - 1] >= 0:
                dp[i][j - array[i - 1]] = 1
            if j + array[i - 1] <= m:
                dp[i][j + array[i - 1]] = 1
    result = -1
    for i in range(m, -1, -1):
        if dp[n][i] == 1:
            result = i
            break
    print(result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")