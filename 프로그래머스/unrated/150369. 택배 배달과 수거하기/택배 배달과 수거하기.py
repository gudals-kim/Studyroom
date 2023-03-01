def solution(cap, n, deliveries, pickups):
    answer = 0
    deliver = 0
    pickup = 0
    for idx in range(n-1, -1, -1):
        cnt = 0
        deliver -= deliveries[idx]
        pickup -= pickups[idx]
        while deliver < 0 or pickup < 0:
            deliver += cap
            pickup += cap
            cnt += 1
        answer += (idx + 1) * 2 * cnt
    return answer