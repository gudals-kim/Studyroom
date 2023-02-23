from collections import deque
def solution(cards1, cards2, goal):
    Que = deque(goal)
    cards1 = deque(cards1)
    cards2 = deque(cards2)
    answer = "Yes"
    result = []
    while Que:
        node = Que.popleft()

        if 0 < len(cards1) and cards1[0] == node:
            n=cards1.popleft()
            result.append(n)
        if 0 < len(cards2) and cards2[0] == node:
            n=cards2.popleft()
            result.append(n)

    print(result)
    print(goal)
    if len(result) != len(goal):
        answer = "No"
    return answer