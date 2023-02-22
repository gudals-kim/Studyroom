def solution(dirs):
    answer = 0
    decode = {'U':(0,1),
             'D':(0,-1),
             'L':(-1,0),
             'R':(1,0)}
    간곳 = set()
    좌표 = (0,0)
    for 명령어 in dirs:
        이전좌표 = 좌표
        좌표 = (좌표[0]+decode[명령어][0],좌표[1]+decode[명령어][1])
        if 좌표[0] > 5 or 좌표[0] < -5 or 좌표[1] > 5 or 좌표[1] < -5:
            좌표 = 이전좌표
            continue
        간곳.add(좌표+이전좌표)
        간곳.add(이전좌표+좌표)
    print(간곳)
    return len(간곳)//2