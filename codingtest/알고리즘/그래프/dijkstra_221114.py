import heapq


def dijkstra(그래프, 시작노드):
    최단거리저장 = {노드: float('inf') for 노드 in 그래프}
    최단거리저장[시작노드] = 0

    최소힙 = []
    heapq.heappush(최소힙, [최단거리저장[시작노드], 시작노드])

    while 최소힙:
        현재노드까지의최단거리, 현재노드 = heapq.heappop(최소힙)
        # 최단거리에 저장된 거리가 더 짧다면 수행 필요없음
        if 최단거리저장[현재노드] < 현재노드까지의최단거리:
            continue
        for 다음노드, 현재노드와다음노드의거리 in 그래프[현재노드].items():
            다음노드까지의최단거리 = 현재노드와다음노드의거리 + 현재노드까지의최단거리
            if 다음노드까지의최단거리 < 최단거리저장[다음노드]:
                최단거리저장[다음노드] = 다음노드까지의최단거리
                heapq.heappush(최소힙, [다음노드까지의최단거리, 다음노드])
    return 최단거리저장

#test code
graph = {
    'A': {'B': 8,'C': 1,'D': 2},
    'B': {},
    'C': {'B': 5,'D': 2},
    'D': {'E': 3,'F': 5},
    'E': {'F': 1},
    'F': {'A': 5}
}

print(dijkstra(graph,'E').get('A'))
print(dijkstra(graph,'E'))

