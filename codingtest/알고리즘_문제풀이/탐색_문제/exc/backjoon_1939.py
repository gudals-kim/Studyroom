import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/탐색_문제/input/backjoon_1939.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print("--------여기부터 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import deque
    n, m = map(int, input().split())
    adj = [[] for _ in range(n+1)]
    def bfs(c):
        queue = deque([start_node])
        visited = [False] * (n+1)
        visited[start_node] = True
        while queue:
           x = queue.popleft()
           for y, weight in adj[x]:
               if not visited[y] and weight >= c:
                    visited[y] = True
                    queue.append(y)
        return visited[end_node]

    start = 1000000000
    end = 1

    for _ in range(m):
        x, y ,weight = map(int, input().split())
        adj[x].append((y, weight))
        adj[y].append((x, weight))
        start = min(start, weight)
        end = max(end, weight)

    start_node, end_node = map(int, input().split())
    result = start
    while(start<=end):
        mid = (start + end)//2
        if bfs(mid):
            result = mid
            start = mid + 1
        else:
            end = mid - 1
    print(result)

    # ==================================
    print("--------여기까지 답안 출력입니다.--------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")