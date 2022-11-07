# [8,5]
# cycle 1 [5,8]
# [8,5,2]
# cycle 1 [2,8,5] index 0부터 2까지
# cycle 2 [2,5,8] index 1부터 2까지 
# [8, 5, 2, 1]
#  cycle 0 [1,8,5,2] index 0부터 3까지
#  cycle 1 [1,2,8,5] index 1부터 3까지
#  cycle 2 [1,2,5,8] index 2부터 3까지
# cycle은 n-1번 반복 
# index는 cycle 부터 len(data)-1 까지 data[cycle]에 가장 최솟값 정렬

def selection_sort(data):
    #cycle은 n-1번 반복 
    for cycle in range(len(data)-1):
        #최소값 데이터 지정 
        min = cycle
        #index는 cycle 부터 len(data)-1 까지
        for index in range(cycle,len(data)):
            #만약 data[index]가 data[cycle]보다 작다면
            if data[index] < data[min]:
                min = index
        #가장 작은값의 데이터와 data[cycle] 번째에 있는 데이터를 교환한다.
        data[min],data[cycle] = data[cycle],data[min]
    return data


#test code
import random

data_list = random.sample(range(100), 10)
print(selection_sort(data_list))