from collections import defaultdict
def solution(s):
    a=defaultdict(list)
    answer = []
    for idx in range(len(s)):
        if len(a[s[idx]])==0:
            answer.append(-1)
            a[s[idx]].append(idx)
            continue
        a[s[idx]].append(idx)
        answer.append(idx-a[s[idx]][-2])
    return answer