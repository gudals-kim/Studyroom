import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_1697.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import deque

    MAX = 100001
    n, k = map(int, input().split())
    result = [0] * MAX

    def bfs(n,k):
        visited = deque([n])
        while visited:
            node = visited.popleft()
            if node == k:
                return result[node]
            for nextNode in (node-1, node+1, node * 2):
                if 0<= nextNode < MAX and not result[nextNode]:
                    result[nextNode] = result[node] + 1
                    visited.append(nextNode)
    print(bfs(n,k))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")