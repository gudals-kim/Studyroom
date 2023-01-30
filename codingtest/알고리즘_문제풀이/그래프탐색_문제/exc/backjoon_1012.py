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
    input = sys.stdin.readline
    def bfs(graph,startNode):
        result = set()
        visited = deque([startNode])
        while visited:
            node = visited.popleft()
            if node not in result:
                result.add(node)
                visited.extend(graph[node])
        return result

    for _ in range(int(input())):
        m, n, k = map(int, input().split())
        graph=list()
        result = defaultdict(set)
        for __ in range(k):
            x, y = map(int,input().split())
            graph.append((x,y))
        for ex in graph:
            x,y = ex
            for ex2 in [(x,y+1),(x-1,y),(x,y),(x+1,y),(x,y-1)]:
                if ex2 in graph:
                    result[ex].add(ex2)
                    result[ex2].add(ex)
        array = set(result.keys())
        cut = 0
        while array:
            node = array.pop()
            array = array - bfs(result,node)
            cut+=1
        print(cut)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")