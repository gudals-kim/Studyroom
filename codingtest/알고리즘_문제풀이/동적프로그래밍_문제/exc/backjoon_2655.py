import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/동적프로그래밍_문제/input/backjoon_2655.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    n = int(input())
    array = []

    array.append((0,0,0,0))
    for i in range(1, n+1):
        area, height, weight = map(int, input().split())
        array.append((i, area, height, weight))
    #무게 기준 정렬
    array = sorted(array, key=lambda x: x[3])

    dp = [0] * (n+1)

    for i in range(1, n+1):
        for j in range(0, i):
            if array[i][1] > array[j][1]:
                dp[i] = max(dp[i], dp[j] + array[i][2])
    max_value = max(dp)
    index = n
    result = []

    while index != 0:
        if max_value == dp[index]:
            result.append(array[index][0])
            max_value -= array[index][2]
        index -= 1
    result.reverse()
    print(len(result))
    [print(i) for i in result]
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")