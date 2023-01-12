import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_1766.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import heapq
    n, m = map(int, input().split())
    array = [[] for i in range(n+1)]
    indegree = [0] * (n+1)

    heap = []
    result = []

    for _ in range(m):
        x, y = map(int, input().split())
        array[x].append(y)
        indegree[y]+=1
    for i in range(1, n+1):
        if indegree[i]==0:
            heapq.heappush(heap, i)
    while heap:
        data = heapq.heappop(heap)
        result.append(data)
        for y in array[data]:
            indegree[y] -= 1
            if indegree[y] == 0:
                heapq.heappush(heap,y)

    print(" ".join(map(str,result)))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")