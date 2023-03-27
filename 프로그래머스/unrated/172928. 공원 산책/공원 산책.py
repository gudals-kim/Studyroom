def solution(park, routes):
    answer = []
    벽좌표들 = []
    시작좌표 = 0
    for h in range(len(park)):
        for w in range(len(park[h])):
            if park[h][w]=='X':
                벽좌표들.append((h,w))
                continue
            if park[h][w]=='S':
                시작좌표 = (h,w)
    현재좌표 = 시작좌표
    for route in routes:
        방위, 이동거리 = route.split()
        벽에막힘 = False
        if 방위=='N':
            for 거리 in range(1,int(이동거리)+1):
                다음좌표 = (현재좌표[0]-거리,현재좌표[1])
                if 다음좌표[0] >= len(park) or 다음좌표[1] >= len(park[0]) or 다음좌표[0] < 0 or 다음좌표[1] < 0 or 다음좌표 in 벽좌표들:
                    벽에막힘 = True
                    break
            if not 벽에막힘:
                현재좌표 = 다음좌표
            continue
        if 방위=='S':
            for 거리 in range(1,int(이동거리)+1):
                다음좌표 = (현재좌표[0]+거리,현재좌표[1])
                if 다음좌표[0]>=len(park) or 다음좌표[1] >= len(park[0]) or 다음좌표[0]<0 or 다음좌표[1] < 0 or 다음좌표 in 벽좌표들:
                    벽에막힘 = True
                    break
            if not 벽에막힘:
                현재좌표 = 다음좌표
            continue
        if 방위=='W':
            for 거리 in range(1,int(이동거리)+1):
                다음좌표 = (현재좌표[0],현재좌표[1]-거리)
                if 다음좌표[0]>=len(park) or 다음좌표[1] >= len(park[0]) or 다음좌표[0]<0 or 다음좌표[1] < 0 or 다음좌표 in 벽좌표들:
                    벽에막힘 = True
                    break
            if not 벽에막힘:
                현재좌표 = 다음좌표
            continue
        if 방위=='E':
            for 거리 in range(1,int(이동거리)+1):
                다음좌표 = (현재좌표[0],현재좌표[1]+거리)
                if 다음좌표[0]>=len(park) or 다음좌표[1] >= len(park[0]) or 다음좌표[0]<0 or 다음좌표[1] < 0 or 다음좌표 in 벽좌표들:
                    벽에막힘 = True
                    break
            if not 벽에막힘:
                현재좌표 = 다음좌표
            continue
    return 현재좌표
        