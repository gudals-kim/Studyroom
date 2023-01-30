import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_1260.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    from collections import defaultdict, deque
    n, m, v = map(int, input().split())
    graph = defaultdict(list)
    graphDFS = defaultdict(list)
    for _ in range(m):
        A, B = map(int, input().split())
        graph[A].append(B)
        graph[B].append(A)
    for _ in graph.keys():
        graph[_] = set(sorted(graph[_]))
        graphDFS[_] = sorted(graph[_],reverse=True)
    def BFS(graph, startNode):
        result = []
        visited = deque([startNode])
        while visited:
            node = visited.popleft()
            if node not in result:
                result.append(node)
                visited.extend(graph[node])

        return result
    def DFS(graph, startNode):
        result = []
        visited = deque([startNode])
        while visited:
            node = visited.pop()
            if node not in result:
                result.append(node)
                visited.extend(graph[node])
        return result
    print(" ".join(str(x) for x in DFS(graphDFS,v)))
    print(" ".join(str(x) for x in BFS(graph,v)))
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")