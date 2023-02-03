import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐욕_문제/input/backjoon_2212.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    센서개수 = int(input())
    집중국개수 = int(input())
    센서좌표 = sorted(map(int, input().split()))
    result = 0
    #집중국의 개수가 센서개수 보다 많을때
    if 집중국개수>=센서개수:
        #모든 센서위치에 집중국을 설치하면 된다.
        #집중국의 수신 가능영역은 0이다.
        pass
    else:
        #각 센서 간의 거리를 계산하여 내림차순 정렬
        거리 = []
        for index in range(1, 센서개수):
            거리.append(센서좌표[index]-센서좌표[index-1])
        거리.sort(reverse=True)

        #가장 긴 거리부터 하나씩 제거한다.
        for i in range(집중국개수-1):
            거리[i] = 0
        result = sum(거리)
    print(result)

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")