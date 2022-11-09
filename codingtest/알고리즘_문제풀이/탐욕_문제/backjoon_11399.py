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

