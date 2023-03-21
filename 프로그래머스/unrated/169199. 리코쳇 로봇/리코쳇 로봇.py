import heapq
from collections import defaultdict

def solution(board):
    answer = 0
    #감싸기
    exBoard = wrapTheBoard(board)
    #벽, 출발, 도착, 길 좌표 찾기
    x벽리스트, y벽리스트, 좌표들, 출발좌표, 도착좌표 = extraKeys(exBoard)
    # 그래프 생성
    graph = makeGraph(x벽리스트, y벽리스트, 좌표들)
    # 다익스트라 알고리즘
    최단거리들=최단거리찾기(graph,출발좌표)

    if 최단거리들[도착좌표]!=float('inf'):
        return 최단거리들[도착좌표]
    return -1


def wrapTheBoard(board):
    exBoard = ['D' * (len(board[0]) + 2)] * (len(board) + 2)
    for idx in range(len(board)):
        exBoard[idx + 1] = "D" + board[idx] + "D"
    return exBoard


def extraKeys(exBoard):
    좌표들 = []
    x벽리스트, y벽리스트 = defaultdict(list), defaultdict(list)
    출발좌표, 도착좌표 = 0, 0
    for y in range(len(exBoard)):
        for x in range(len(exBoard[y])):
            if exBoard[y][x] == 'D':
                x벽리스트[x].append((x, y))
                y벽리스트[y].append((x, y))
                continue
            if exBoard[y][x] == 'R':
                출발좌표 = (x, y)
            if exBoard[y][x] == 'G':
                도착좌표 = (x, y)
            좌표들.append((x, y))
    return x벽리스트, y벽리스트, 좌표들, 출발좌표, 도착좌표


def makeGraph(x벽리스트, y벽리스트, 좌표들):
    graph = defaultdict(list)
    for x, y in 좌표들:
        # 상하좌우 연결
        상벽y, 하벽y, 좌벽x, 우벽x = float('inf'), -1, -1, float('inf')
        for dx, dy in y벽리스트[y]:
            if x > dx:
                좌벽x = max(좌벽x, dx)
            if x < dx:
                우벽x = min(우벽x, dx)
        for dx, dy in x벽리스트[x]:
            if y < dy:
                상벽y = min(상벽y, dy)
            if y > dy:
                하벽y = max(하벽y, dy)
        for 도착점 in [(x, 상벽y - 1), (x, 하벽y + 1), (좌벽x + 1, y), (우벽x - 1, y)]:
            if 도착점[0] == x and 도착점[1] == y:
                continue
            graph[(x, y)].append(도착점)
    return graph

def 최단거리찾기(graph, 시작좌표):
    최단거리들 = {node:float('inf') for node in graph}
    최단거리들[시작좌표] = 0
    q = []
    heapq.heappush(q,[최단거리들[시작좌표],시작좌표])
    while q:
        현재노드까지최단거리, 현재노드 = heapq.heappop(q)

        if 최단거리들[현재노드] < 현재노드까지최단거리:
            continue
        for 다음노드 in graph[현재노드]:
            다음노드까지의거리 = 현재노드까지최단거리 + 1
            if 최단거리들[다음노드] > 다음노드까지의거리:
                최단거리들[다음노드] = 다음노드까지의거리
                heapq.heappush(q,[최단거리들[다음노드],다음노드])

    return 최단거리들