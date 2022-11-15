import heapq

def dijkstra(그래프,시작노드):
    가중치들 = {노드 : float('inf') for 노드 in 그래프}
    가중치들[시작노드] = 0

    최소힙 = []
    heapq.heappush(최소힙,[가중치들[시작노드],시작노드])

    while(최소힙):
        최소_가중치,힙_노드 = heapq.heappop(최소힙)

        if 가중치들[힙_노드] < 최소_가중치:
            continue

        for 노드, 가중치 in 그래프[힙_노드].items():
            가중치 = 최소_가중치 + 가중치
            if 가중치 < 가중치들[노드]:
                가중치들[노드] = 가중치
                heapq.heappush(최소힙, [가중치, 노드])

    return 가중치들

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

