from collections import defaultdict
import heapq

# 다익스트라 알고리즘
def 최단거리탐색(그래프, 시작좌표):
    최단거리저장 = { node : float('inf') for node in 그래프.keys()}
    최단거리저장[시작좌표] = 0
    heap = []
    heapq.heappush(heap, [최단거리저장[시작좌표],시작좌표])
    while heap:
        현재까지최단거리, 현재노드 = heapq.heappop(heap)
        if 현재까지최단거리 > 최단거리저장[현재노드]:
            continue
        for 다음노드 in list(그래프[현재노드]):
            다음노드까지거리 = 현재까지최단거리 + 1
            if 다음노드까지거리 < 최단거리저장[다음노드]:
                최단거리저장[다음노드] = 다음노드까지거리
                heapq.heappush(heap, [다음노드까지거리, 다음노드])
    return 최단거리저장



def solution(maps):
    # 그래프 생성
    graph = defaultdict(set)
    시작좌표, 경유좌표, 도착좌표 = 0, 0, 0
    for y in range(len(maps)):
        for x in range(len(maps[y])):
            if maps[y][x] == 'X':
                continue
            if maps[y][x] == 'S':
                시작좌표=(x,y)
            if maps[y][x] == 'L':
                경유좌표=(x,y)
            if maps[y][x] == 'E':
                도착좌표=(x,y)
            graph[(x, y)].add((x,y))
            for 다음x, 다음y in [(x,y+1),(x,y-1),(x-1,y),(x+1,y)]:
                if 다음x >= len(maps[y]) or 다음x < 0 or 다음y >= len(maps) or 다음y < 0:
                    continue
                if maps[다음y][다음x] != 'X':
                    graph[(x,y)].add((다음x,다음y))
                    graph[(다음x,다음y)].add((x,y))
    # 답안 출력
    if 시작좌표 == 0 or 도착좌표 == 0 or 경유좌표 == 0 :
        return -1
    시작경유최단거리 = 최단거리탐색(graph, 시작좌표)
    경유도착최단거리 = 최단거리탐색(graph, 경유좌표)
    if 시작경유최단거리[경유좌표] == float('inf') or 경유도착최단거리[도착좌표] == float('inf'):
        return -1
    return 시작경유최단거리[경유좌표]+경유도착최단거리[도착좌표]
