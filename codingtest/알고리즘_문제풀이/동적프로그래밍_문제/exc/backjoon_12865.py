import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/동적프로그래밍_문제/input/backjoon_12865.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    n, k = map(int, input().split())
    dp = [[0] * (k+1) for _ in range(n+1)]

    for i in range(1, n+1):
        weight, value = map(int, input().split())
        for j in range(1, k+1):
            if j < weight:#물건의 무게보다 k가 낮을때는 그대로 가져온다.
                dp[i][j] = dp[i-1][j]
            else:#max(둘중에 더 큰값)
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
    print(dp[n][k])
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")