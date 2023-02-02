테스트케이스횟수 = int(input())
횟수=0
while 횟수<테스트케이스횟수:
    횟수+=1
    문서개수, pickNum = map(int,input().split())
    중요도리스트 = list(map(int,input().split()))
    queue = [(중요도,인덱스) for 인덱스, 중요도 in enumerate(중요도리스트)]
    중요도집합 = set(중요도리스트)
    count = 0
    if len(중요도리스트) == len(중요도집합):
        뽑아야하는값=중요도리스트[pickNum]
        중요도리스트.sort(reverse=True)
        for i in 중요도리스트:
            count+=1
            if 뽑아야하는값 == i:
                print(count)
                break
    else:
        while True:
            if queue[0][0] == max(queue, key=lambda x: x[0])[0]:
                count+=1
                if queue[0][1]==pickNum:
                    print(count)
                    break
                else:
                    queue.pop(0)
            else:
                queue.append(queue.pop(0))