def solution(k, m, score):
    score=sorted(score,reverse=True)
    return sum([min(score[idx:idx+m])*m for idx in range(0,len(score),m) if len(score[idx:idx+m])==m])