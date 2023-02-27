from collections import defaultdict

def solution(today, terms, privacies):
    answer = []
    년,월,일 = 0,1,2
    today = list(map(int,today.split(".")))
    term = {time.split()[0]:int(time.split()[1]) for time in terms}
    privacie = [(pri.split()[1],list(map(int,pri.split()[0].split(".")))) for pri in privacies]
    idx = 1
    for 약관타입, 약관날짜 in privacie:

        약관날짜[월]+=term[약관타입]
        약관날짜[일]-=1
        while 약관날짜[월]>12:
            약관날짜[월]-=12
            약관날짜[년]+=1
            

        if today[년]<약관날짜[년]:
            idx+=1
            continue
        if today[년]==약관날짜[년] and today[월]<약관날짜[월]:
            idx+=1
            continue
        if today[년]==약관날짜[년] and today[월]==약관날짜[월] and today[일]<=약관날짜[일]:
            idx+=1
            continue
        answer.append(idx)
        idx+=1
    return answer