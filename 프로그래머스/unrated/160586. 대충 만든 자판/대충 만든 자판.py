def solution(keymap, targets):
    answer = []
    for target in targets:
        답 = 0
        for k in target:
            최솟값 = float('inf')
            for maps in keymap:
                n = float('inf')
                for idx in range(len(maps)):
                    if k == maps[idx]:
                        n = (idx + 1)
                        break
                최솟값 = min(최솟값, n)
            if 최솟값==float('inf'):
                답 = -1
                break
            답 += 최솟값
        answer.append(답)

    return answer