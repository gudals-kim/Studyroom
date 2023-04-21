from collections import defaultdict

def solution(X, Y):
    X출연횟수, Y출연횟수 = defaultdict(int),defaultdict(int)
    result = ""
    for i in X:
        X출연횟수[int(i)]+=1
    for i in Y:
        Y출연횟수[int(i)]+=1
    answer = sorted(list({int(i) for i in X}&{int(i) for i in Y}),reverse=True)
    if not answer:
        return "-1"
    elif len(answer)==1 and answer[0]==0:
        return "0"
    for i in answer:
        출연횟수 = min(X출연횟수[i],Y출연횟수[i])
        result+=(str(i)*출연횟수)
    return result