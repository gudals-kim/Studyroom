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