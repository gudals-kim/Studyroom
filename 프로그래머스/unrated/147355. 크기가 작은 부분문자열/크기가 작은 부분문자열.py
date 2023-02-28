def solution(t, p):
    return len([num for num in [int(t[idx:idx+len(p)]) for idx in range(0,len(t)-len(p)+1)] if num<=int(p)])