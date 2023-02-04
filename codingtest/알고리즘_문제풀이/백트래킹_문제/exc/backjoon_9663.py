import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/백트래킹_문제/input/backjoon_9663.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    input = sys.stdin.readline
    def check(x):
        # 이전 행에서 놓았던 모든 Queen들을 확인한다.
        for i in range(x):
            # 위쪽 혹은 대각선을 확인
            if row[x] == row[i]:
                return False
            if abs(row[x] - row[i]) == x - i:
                return False
        return True
    # x번째 행에 대하여 처리
    def dfs(x):
        global result
        if x == n:
            result += 1
        else:
            # x번째 행의 각 열에 Queen을 둔다고 가정한다.
            for i in range(n):
                row[x] = i
                # 해당 위치에 Queen을 두어도 괜찮은 경우
                if check(x):
                    # 다음행으로 넘어간다.
                    dfs(x + 1)

    n = int(input())
    row = [0] * n
    result = 0
    dfs(0)
    print(result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")