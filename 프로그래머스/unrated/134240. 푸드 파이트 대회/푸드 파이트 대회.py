def solution(food):
    left = ""
    right = ""
    for idx in range(1,len(food)):
        left+=(str(idx)*(food[idx]//2))
        right+=(str(len(food)-idx)*(food[len(food)-idx]//2))
    return left+"0"+right