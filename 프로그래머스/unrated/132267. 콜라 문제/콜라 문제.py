from collections import deque
def 공병받으면콜라줌(a, b, n):
    return b*(n//a), n%a

def solution(a, b, n):
    answer = 0
    q = deque([n])
    while q:
        현재공병 = q.pop()
        if 현재공병<a:
            break
        받은콜라, 남은공병 = 공병받으면콜라줌(a,b,현재공병)
        answer+=받은콜라
        q.append(받은콜라+남은공병)
    return answer