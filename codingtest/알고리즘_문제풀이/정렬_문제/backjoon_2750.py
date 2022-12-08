import heapq
n = int(input())
queue = list()
for i in range(n):
    num = int(input())
    heapq.heappush(queue,num)

for i in range(n):
    print(heapq.heappop(queue))