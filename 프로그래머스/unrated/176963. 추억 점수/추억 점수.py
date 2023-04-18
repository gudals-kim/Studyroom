from collections import defaultdict
def solution(name, yearning, photo):
    maplist = defaultdict(int)
    answer = []
    for idx in range(len(name)):
        maplist[name[idx]] = yearning[idx]
    for pik in photo:
        result = 0
        for key in pik:
            result += maplist[key]
        answer.append(result)
    return answer