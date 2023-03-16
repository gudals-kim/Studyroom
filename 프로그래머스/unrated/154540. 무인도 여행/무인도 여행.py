from collections import defaultdict,deque


def makeGraph(maps):
    graph = defaultdict(list)
    for y in range(len(maps)):
        for x in range(len(maps[y])):
            if maps[y][x] == 'X':
                continue
            for dx, dy in [(x - 1, y), (x + 1, y), (x, y), (x, y - 1), (x, y + 1)]:
                if dy < 0 or dy >= len(maps) or dx < 0 or dx >= len(maps[y]):
                    continue
                if maps[dy][dx] == 'X':
                    continue
                graph[(x, y)].append([int(maps[dy][dx]), (dx, dy)])
    return graph

def 답찾기(graph, startNode, 방문여부):
    q = deque([startNode])

    답 = 0
    while q:
        node=q.popleft()
        for 거리, 다음노드 in graph[node]:
            if 방문여부[다음노드]:
                continue
            방문여부[다음노드] = True
            답+=거리
            q.extend([다음노드])
    return 답

def solution(maps):
    graph = makeGraph(maps)
    answer=[]
    방문여부 = {k: False for k in graph.keys()}
    for node in graph.keys():
        num = 답찾기(graph, node, 방문여부)
        if num==0:
            continue
        answer.append(num)
    if len(answer)==0:
        answer = [-1]
    return sorted(answer)