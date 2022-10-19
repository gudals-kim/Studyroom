# [8,7]
# cycle 1 [7,8] 
# index 1에서 시작하여 -1인 0과 비교후 더 작은값이면 index 0의 앞으로 이동

# [8,7,2]
# cycle 1 [7,8,2]
# cycle 2 [2,7,8]

# [8,7,2,4]
# cycle 1 [7,8,2,4] index 1부터 0까지
# cycle 2 [2,7,8,4] index 2부터 0까지
# cycle 3 [2,4,7,8] index 3부터 0까지

# data가 n개 일때 cycle은 n-1번 반복
# index는 cycle에서 시작하여 -1 씩 이동후 비교

def insertion_sort(data):
    # data가 len(data) 개 일때 cycle은 len(data)-1번 반복
    for cycle in range(1,len(data)):#data가 4개면 cycle엔 [1,2,3] 이 들어감 n-1 번 반복 맞음
        #index는 cycle에서 시작하고 -1 씩 이동
        for index in range(cycle, 0,-1):
            #index와 앞 index를 비교후 data값이 작은경우 스왑
            if data[index] < data[index - 1]:
                data[index],data[index - 1] = data[index - 1],data[index]
            #앞 인덱스가 더 작을경우는 앞은 정렬이 되있다는 것이기 때문에 break
            else:
                break
    return data






#test code
import random

data_list = random.sample(range(100), 50)
print (insertion_sort(data_list))