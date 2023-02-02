import time
import datetime
import psutil
import sys
inputData = "/Users/gudals/Documents/github/Studyroom/codingtest/알고리즘_문제풀이/그래프탐색_문제/input/backjoon_1774.txt"

p = psutil.Process()

sys.stdin = open(inputData,"r")
T = int(sys.stdin.readline())
for test_case in range(1,T+1):
    startTime = time.time()
    print(f"--------{test_case}번 테스트 코드 답안 출력입니다.--------")
    # ======== 답안지 작성을 합니다 =========
    import math
    import sys

    input = sys.stdin.readline


    def get_distance(p1, p2):
        a = p1[0] - p2[0]
        b = p1[1] - p2[1]
        return math.sqrt((a * a) + (b * b))


    def get_parent(parent, n):
        if parent[n] == n:
            return n
        return get_parent(parent, parent[n])


    def union_parent(parent, a, b):
        a = get_parent(parent, a)
        b = get_parent(parent, b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b


    def find_parent(parent, a, b):
        a = get_parent(parent, a)
        b = get_parent(parent, b)
        if a == b:
            return True
        else:
            return False


    edges = []
    parent = {}
    locations = []
    n, m = map(int, input().split())

    for _ in range(n):
        x, y = map(int, input().split())
        locations.append((x, y))

    length = len(locations)

    for i in range(length - 1):
        for j in range(i + 1, length):
            edges.append((i + 1, j + 1, get_distance(locations[i], locations[j])))

    for i in range(1, n + 1):
        parent[i] = i

    for i in range(m):
        a, b = map(int, input().split())
        union_parent(parent, a, b)

    edges.sort(key=lambda data: data[2])
    result = 0
    for a, b, cost in edges:
        if not find_parent(parent, a, b):
            union_parent(parent, a, b)
            result += cost
    print("%0.2f" % result)
    # ==================================
    print(f"-----------------------------------------")
    rss = p.memory_info().rss / 2 ** 20  # Bytes to MB
    endTime = time.time()

    print(f" {test_case} testCode memory usage  {rss: 10.5f} MB")
    print(f" {test_case} testCode execution time  {datetime.timedelta(seconds=(endTime - startTime))} sec")
    print(f"-----------------------------------------")