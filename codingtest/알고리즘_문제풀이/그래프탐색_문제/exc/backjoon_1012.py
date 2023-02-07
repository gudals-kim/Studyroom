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
    from collections import defaultdict, deque
    import sys
    input = sys.stdin.readline
    #dfs
    def dfs(graph, start):
        result = set()
        q = deque([start])
        while q:
            node = q.popleft()
            if node not in result:
                result.add(node)
                q.extend(graph[node])
        return result

    for t in range(int(input())):
        m, n, k = map(int, input().split())
        배추심은곳들 = set(tuple(map(int,input().split())) for _ in range(k))
        graph = defaultdict(set)
        for x,y in 배추심은곳들:
            # 배추가 심어진곳에서 상하좌우로 탐색한다. + 본인 좌표도 추가해야함
            for 옆좌표 in [(x, y + 1), (x - 1, y), (x, y), (x + 1, y), (x, y - 1)]:
                # 상하좌우에 배추가 심어져 있다면 그래프를 연결한다.
                if 옆좌표 in 배추심은곳들:
                    graph[(x,y)].add(옆좌표)
                    graph[옆좌표].add((x,y))
        # 그래프의 모든 key(배추가 심어진 곳)에서 붙어 있는 곳(그래프로 연결된 곳)을 찾아 차집합으로 빼준다.
        result = 0
        while 배추심은곳들:
            node = 배추심은곳들.pop()
            배추심은곳들 = 배추심은곳들 - dfs(graph, node)
            result+=1
        print(result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")