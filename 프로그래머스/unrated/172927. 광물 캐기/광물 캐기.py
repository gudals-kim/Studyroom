from collections import deque


def solution(picks, minerals):
    answer = 0
    minerals= minerals[:sum(picks)*5]
    돌변환기 = {'diamond' : 25, 'iron' : 5, 'stone' : 1}
    철변환기 = {'diamond' : 5, 'iron' : 1, 'stone' : 1}
    다이야변환기 = {'diamond' : 1, 'iron' : 1, 'stone' : 1}
    돌곡갱이피로도 = [ 돌변환기[i] for i in minerals]
    철곡갱이피로도 = [ 철변환기[i] for i in minerals]
    다이야곡갱이피로도 = [ 다이야변환기[i] for i in minerals]
    돌곡갱이피로도합 = [ sum(돌곡갱이피로도[idx:idx+5]) for idx in range(0,len(돌곡갱이피로도),5)]
    철곡갱이피로도합 = [ sum(철곡갱이피로도[idx:idx+5]) for idx in range(0,len(철곡갱이피로도),5)]
    다이야곡갱이피로도합 = [ sum(다이야곡갱이피로도[idx:idx+5]) for idx in range(0,len(다이야곡갱이피로도),5)]

    피로도합 = [[다이야곡갱이피로도합[idx],철곡갱이피로도합[idx],돌곡갱이피로도합[idx]] for idx in range(len(돌곡갱이피로도합))]
    피로도합=deque(sorted(피로도합,key=lambda x:x[2]-x[0], reverse=True))
    for n in range(picks[0]):
        if 피로도합:
            answer+=피로도합.popleft()[0]
    피로도합 = deque(sorted(피로도합, key=lambda x: x[2] - x[1], reverse=True))
    for n in range(picks[1]):
        if 피로도합:
            answer += 피로도합.popleft()[1]
    for n in range(picks[2]):
        if 피로도합:
            answer += 피로도합.popleft()[2]
    return answer