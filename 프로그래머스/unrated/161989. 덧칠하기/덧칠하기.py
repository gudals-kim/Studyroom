
def solution(n, m, section):
    done,answer = section[0]-1,0
    for x in section:
        if done<x:
            done=x+m-1
            answer+=1
    return answer