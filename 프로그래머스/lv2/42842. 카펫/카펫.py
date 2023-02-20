def solution(brown, yellow):
    answer = []
    total = brown + yellow
    for a in range(1, total+1):
        if (total / a) % 1 == 0:
            b = total / a
            if b >= a:
                if 2*a + 2*b == brown + 4:
                    return [b,a]
    
    
    return answer