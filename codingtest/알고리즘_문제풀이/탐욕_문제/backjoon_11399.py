#입력기능
def make_input():
    i=0
    result=list()
    while i < 2:
        if i<1:
            people_count = int(input())
            result.append(people_count)
        else:
            withdrawal_time = list(map(int,input().split()))
            result.append(withdrawal_time)
        i += 1
    return result

#정렬기능
def make_sort(withdrawal_time):
    if len(withdrawal_time)<=1:
        return withdrawal_time
    pivot = withdrawal_time[0]
    left = list()
    right = list()
    for index in range(1,len(withdrawal_time)):
        if pivot > withdrawal_time[index]:
            left.append(withdrawal_time[index])
        else:
            right.append(withdrawal_time[index])
    return make_sort(left)+[pivot]+make_sort(right)
