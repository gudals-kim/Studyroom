from collections import deque

def solution(ingredient):
    answer = 0
    q = deque(ingredient)
    back = []
    idx = 0
    while q:
        node = q.popleft()
        back.append(node)
        if len(back)>3 and back[idx-3:idx+1] == [1,2,3,1]:
            back.pop()
            back.pop()
            back.pop()
            back.pop()
            idx -= 4
            answer += 1
        idx += 1
    return answer

