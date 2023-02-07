import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_12100.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from copy import deepcopy

    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]

    #rotate90() 90도 돌리기 함수
    def rotate90(data, n):
        newData = deepcopy(data)
        for i in range(n):
            for j in range(n):
                newData[j][(n-i-1)] = data[i][j]
        return newData
    def convert(열, n):
        #양수만 가져온다.
        합쳐진열 = [i for i in 열 if i]
        for i in range(1, len(합쳐진열)):
            if 합쳐진열[i-1] == 합쳐진열[i]:
                합쳐진열[i-1] *= 2
                합쳐진열[i] = 0
        합쳐진열 = [i for i in 합쳐진열 if i]
        return 합쳐진열 + [0] * (n-len(합쳐진열))
    def dfs(n, data, count):
        #result는 현재 data 최댓값
        result = max([max(i) for i in data])
        #입력한 count가 0 회가 되면 result를 리턴하고 종료
        if count == 0:
            return result
        #상하좌우 4번을 돌려야한다.
        for _ in range(4):
            #data를 연산한다. 한 방향으로 배열 합치기
            newData = [convert(열, n) for 열 in data]
            if newData != data:
                # 이전과 같지 않다면 count를 1내리고 다시 dfs를 돌린다.
                result = max(result, dfs(n, newData, count-1))
            #배열을 90도로 돌린다.
            data = rotate90(data, n)
        return result


    print(dfs(n, data, 5))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")