def solution(x, y, n):
    if x == y:
        return 0

    dp = [float('inf')] * (y + 1)
    dp[x] = 0
    
    #10부터 40까지 1씩 증가 다음값은
    for 다음값 in range(x, y + 1):
        # 다음 값이 15까진 지나온적 없으니 패스
        # 15이후 값이 20임
        if dp[다음값] == float('inf'):
            continue
        #1회전 - 10+5 <= 40
        #2회전 - 15+5 <= 40
        #3회전 - 20+5 <= 40
        if 다음값 + n <= y:
            #1회전 - dp[15] = min(inf, 1) = 1
            #2회전 - dp[20] = min(1,2) = 1
            #3회전 - dp[25] = min(inf, 2) = 2
            dp[다음값 + n] = min(dp[다음값 + n], dp[다음값] + 1)
        #1회전 20 <= 40
        #2회전 30 <= 40
        #3회전 40 <= 40
        if 다음값 * 2 <= y:
            #1회전 dp[20] = min(inf, 1) = 1
            #2회전 dp[30] = min(1, 2) = 1
            #3회전 dp[40] = min(inf, 2) = 2
            dp[다음값 * 2] = min(dp[다음값 * 2], dp[다음값] + 1)
        #1회전 30 <= 40
        #2회전 45 <= 40 x
        if 다음값 * 3 <= y:
            #1회전 dp[30] = min(inf, 1) = 1
            dp[다음값 * 3] = min(dp[다음값 * 3], dp[다음값] + 1)

    if dp[y] == float('inf'):
        return -1

    return dp[y]
