from collections import defaultdict
import heapq

def solution(N, road, K):
    answer = 0
    graph = defaultdict(list)
    for node in road:
        graph[node[0]].append([node[2],node[1]])
        graph[node[1]].append([node[2],node[0]])
    최단거리들 = { node : float('inf') for node in graph.keys() }
    heap = []
    최단거리들[1]=0
    heapq.heappush(heap,[최단거리들[1],1])
    while heap:
        현재노드까지의최단거리, 현재노드 = heapq.heappop(heap)
        if 현재노드까지의최단거리 > 최단거리들[현재노드]:
            continue
        for 다음노드까지의거리, 다음노드 in graph[현재노드]:
            다음노드까지의최단거리 = 다음노드까지의거리 + 현재노드까지의최단거리
            if 다음노드까지의최단거리 < 최단거리들[다음노드]:
                최단거리들[다음노드] = 다음노드까지의최단거리
                heapq.heappush(heap,[최단거리들[다음노드],다음노드])
    
    for dist in 최단거리들.values():
        if dist <= K:
            answer+=1
    
    
    return answer