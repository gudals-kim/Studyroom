import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_1715.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import heapq
    input=sys.stdin.readline
    n = int(input())
    numbers = []
    for i in range(n):
        num = int(input())
        heapq.heappush(numbers, num)

    result = 0

    while len(numbers)>1:
        num1 = heapq.heappop(numbers)
        num2 = heapq.heappop(numbers)
        sumNums = num1 + num2
        result+= sumNums
        heapq.heappush(numbers, sumNums)
    print(result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")