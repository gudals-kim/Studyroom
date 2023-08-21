from collections import deque

MAX = 100001
n, k = map(int, input().split())
result = [0] * MAX

def bfs(n,k):
    visited = deque([n])
    while visited:
        node = visited.popleft()
        if node == k:
            return result[node]
        for nextNode in (node-1, node+1, node * 2):
            if 0<= nextNode < MAX and not result[nextNode]:
                result[nextNode] = result[node] + 1
                visited.append(nextNode)
print(bfs(n,k))