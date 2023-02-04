import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐욕_문제/input/backjoon_1781.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import heapq
    input = sys.stdin.readline
    모든문제들 = sorted([tuple(map(int,input().split())) for _ in range(int(input()))])
    풀어서받은컵라면들 = []
    for 데드라인,컵라면 in 모든문제들:
        heapq.heappush(풀어서받은컵라면들,컵라면)
        if len(풀어서받은컵라면들)-1 >= 데드라인:
            heapq.heappop(풀어서받은컵라면들)
    result = 0
    if len(풀어서받은컵라면들)!=0:
        result = sum(풀어서받은컵라면들)
    print(result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")