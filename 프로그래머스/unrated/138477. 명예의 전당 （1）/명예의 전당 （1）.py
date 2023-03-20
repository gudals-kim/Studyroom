from heapq import *
def solution(k, score):
    q = [score[0]]
    answer = [score[0]]
    for idx in range(1,len(score)):
        heappush(q,score[idx])
        if len(q)>k:
            heappop(q)
        node = heappop(q)
        answer.append(node)
        heappush(q,node)
    return answer