from heapq import *

def solution(numbers):
    answer = [-1] * len(numbers)
    q = []
    for index in range(len(numbers)):
        while q and q[0][0] < numbers[index]:
            _, idx = heappop(q)
            answer[idx] = numbers[index]
        heappush(q, [numbers[index], index])
    return answer