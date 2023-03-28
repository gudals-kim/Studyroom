def solution(weights):
    same = [-1]*1001
    visit = [-1]*4001
    answer = 0
    for idx in range(len(weights)):
        same[weights[idx]]+=1
        answer += same[weights[idx]]
        sameCnt = same[weights[idx]]
        
        for dist in range(2,5):
            visit[weights[idx]*dist] += 1
            answer += (visit[weights[idx]*dist]-sameCnt)
        
    return answer
