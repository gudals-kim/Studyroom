from collections import deque, defaultdict
import heapq

def solution(N, road, K):
    answer = 0
    graph = defaultdict(list)
    for node in road:
        graph[node[0]].append((node[2],node[1]))
        graph[node[1]].append((node[2],node[0]))
    최단거리 = { n : float('inf') for n in graph.keys()}
    최단거리[1]=0
    heap = []
    heapq.heappush(heap,(최단거리[1],1))
    
    while heap:
        현재노드까지의최단거리, 현재노드 =heapq.heappop(heap)
        if 최단거리[현재노드] < 현재노드까지의최단거리:
            continue
        for 현재노드와다음노드의거리, 다음노드 in graph[현재노드]:
            다음노드까지의최단거리 = 현재노드와다음노드의거리 + 현재노드까지의최단거리
            if 다음노드까지의최단거리 < 최단거리[다음노드]:
                최단거리[다음노드] = 다음노드까지의최단거리
                heapq.heappush(heap,[다음노드까지의최단거리,다음노드])
    for n in 최단거리.values():
        if n <= K:
            answer +=1
    
    return answer