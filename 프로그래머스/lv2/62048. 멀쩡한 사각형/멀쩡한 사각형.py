import math
#최대공약수 풀이
def solution(w,h):
    return (w*h)-(w+h-math.gcd(w,h))
#일차함수의 정수 적분 합 풀이
# def solution(w,h):
#     return sum([int(h*x/w) for x in range(1,w)])*2