def solution(wallpaper):
    answer = [float('inf'),float('inf'),0,0]
    for x in range(len(wallpaper)):
        for y in range(len(wallpaper[x])):
            if wallpaper[x][y]=='#':
                if answer[0]>x:
                    answer[0]=x
                if answer[1]>y:
                    answer[1]=y
                if answer[2]<x+1:
                    answer[2]=x+1
                if answer[3]<y+1:
                    answer[3]=y+1
    return answer