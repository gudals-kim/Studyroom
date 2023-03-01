def 가로빙고확인(x,y,좌표들):
    if x==0:
        비교좌표들 = [(x+1,y),(x+2,y)]
    elif x==1:
        비교좌표들 = [(x-1,y),(x+1,y)]
    else:
        비교좌표들 = [(x-2,y),(x-1,y)]
    for 좌표 in 비교좌표들:
        if 좌표 not in 좌표들:
            return False
    return True
def 세로빙고확인(x,y,좌표들):
    if y==0:
        비교좌표들 = [(x,y+1),(x,y+2)]
    elif y==1:
        비교좌표들 = [(x,y-1),(x,y+1)]
    else:
        비교좌표들 = [(x,y-1),(x,y-2)]
    for 좌표 in 비교좌표들:
        if 좌표 not in 좌표들:
            return False
    return True
def 음수대각선빙고(x,y,좌표들):
    #음수대각선
    for 좌표 in [(0,0),(2,2)]:
        if 좌표 not in 좌표들:
            return False
    return True
def 양수대각선빙고(x,y,좌표들):
    #양수대각선
    for 좌표 in [(0,2),(2,0)]:
        if 좌표 not in 좌표들:
            return False
    return True
def checkBingo(좌표들):
    세로빙고 = []
    가로빙고 = []
    대각선빙고 = 0
    
    for x,y in 좌표들:
        if 가로빙고확인(x,y,좌표들):
            가로빙고.append(y)
        if 세로빙고확인(x,y,좌표들):
            세로빙고.append(x)
        if x==1 and y==1:
            if 음수대각선빙고(x,y,좌표들):
                #음수대각있음
                대각선빙고+=1
            if 양수대각선빙고(x,y,좌표들):
                #양수대각있음
                대각선빙고+=1
    return len(list(set(가로빙고)))+len(list(set(세로빙고)))+대각선빙고
def solution(board):
    o좌표들 = [] 
    x좌표들 = []
    for y in range(len(board)):
        for x in range(len(board[y])):
            if board[y][x]=='.':
                continue
            if board[y][x]=='O':
                o좌표들.append((x,y))
            else:
                x좌표들.append((x,y))
                
    o빙고개수=checkBingo(o좌표들)
    x빙고개수=checkBingo(x좌표들)
    
    #시작하기 전일 때
    if len(o좌표들)+len(x좌표들)==0:
        return 1
    #둘다 빙고가 없을때
    if o빙고개수==0 and x빙고개수==0:
        #o좌표의 개수가 x좌표의 개수보다 1개 많거나 같아야함
        if (len(o좌표들)==len(x좌표들)+1) or (len(o좌표들)==len(x좌표들)):
            return 1
        return 0
    #둘다 빙고가 있을때
    if o빙고개수>0 and x빙고개수>0:
        #그런 경우는 있을 수 없음
        return 0
    #o가 빙고가 있을때
    if o빙고개수>0:
        #o좌표개수가 x좌표 개수보다 1개 더 많아야함
        if len(o좌표들) == len(x좌표들)+1:
            return 1
        return 0
    #x가 빙고가 있을때
    if x빙고개수>0:
        #o좌표랑 x좌표의 개수가 같아야 함
        if len(o좌표들)==len(x좌표들):
            return 1
        return 0
    if len(o좌표들) <= len(x좌표들):
        return 0

    return 0