import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_1012.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import sys

    sys.setrecursionlimit(100000)


    def dfs(x, y):
        visited[x][y] = True
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if array[nx][ny] and not visited[nx][ny]:
                dfs(nx, ny)


    for _ in range(int(input())):
        m, n, k = map(int, input().split())
        array = [[0] * m for _ in range(n)]
        visited = [[False] * m for _ in range(n)]
        for _ in range(k):
            y, x = map(int, input().split())
            array[x][y] = 1
        result = 0
        for i in range(n):
            for j in range(m):
                if array[i][j] and not visited[i][j]:
                    dfs(i, j)
                    result += 1
        print(result)

    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")