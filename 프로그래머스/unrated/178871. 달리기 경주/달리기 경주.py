from collections import deque

def solution(players, callings):
    ratingMap = {players[idx] : idx for idx in range(len(players))}
    for 뒷선수 in callings:
        뒷등수 = ratingMap[뒷선수]
        앞등수 = 뒷등수-1
        앞선수 = players[앞등수]
        
        ratingMap[뒷선수] = 앞등수
        ratingMap[앞선수] = 뒷등수
        players[앞등수] = 뒷선수
        players[뒷등수] = 앞선수
        
    return players