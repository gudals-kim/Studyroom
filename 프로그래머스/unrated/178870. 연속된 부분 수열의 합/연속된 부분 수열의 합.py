def solution(sequence, k):
    end = 0
    answer = []
    subTotal = 0
    for start in range(len(sequence)):
        while end < len(sequence) and subTotal < k:
            subTotal += sequence[end]
            end+=1
        if subTotal == k:
            if not answer:
                answer = [start,end-1]
            else:
                if (end-1-start)<(answer[1]-answer[0]):
                    answer = [start,end-1]
                if (end-1-start)==(answer[1]-answer[0]) and start<answer[0]:
                    answer = [start,end-1]
        subTotal -= sequence[start]
    return answer
