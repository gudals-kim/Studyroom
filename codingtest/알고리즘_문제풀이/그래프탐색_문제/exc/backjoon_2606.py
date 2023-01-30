import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_2606.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import defaultdict,deque
    cnt = int(input())
    graph = defaultdict(set)
    for _ in range(int(input())):
        a, b = map(int,input().split())
        graph[a].add(b)
        graph[b].add(a)
    def bfs(graph, startNode):
        result = list()
        visited = deque([startNode])
        while visited:
            node = visited.popleft()
            if node not in result:
                result.append(node)
                visited.extend(graph[node])
        return result
    print(len(bfs(graph, 1))-1)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")