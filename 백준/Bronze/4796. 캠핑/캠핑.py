n = 0
while True:
    answer = 0
    n += 1
    L, P, V = map(int, input().split())
    if L == 0 and P == 0 and V == 0:
        break
    answer += L * (V // P)
    if V % P >= L:
        answer += L
    else:
        answer += V % P
    print(f"Case {n}: {answer}")