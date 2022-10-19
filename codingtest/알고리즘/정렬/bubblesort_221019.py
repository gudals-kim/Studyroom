#데이터가 2개 일때 cycle과 index순회
# [2,6]
#cycle 1  index 0에 접근후 index+1값과 비교후 교체

#데이터가 3개 일때 cycle과 index 순회
#[9,2,6]
#cycle 1 [2,6,9] index 0과 1에 접근
# cycle 2 [2,6,9] index 1과 2에 접근

#데이터가 4개 일때 cycle과 index 순회
#[5,9,2,1]
# cycle 1 [5,2,1,9] index 0부터 3까지 접근 
# cycle 2 [2,1,5,9] index 0부터 2까지 접근
# cycle 3 [1,2,5,9] index 0부터 1까지 접근

#데이터가 n개일때 cycle은 n-1번 반복하고 각 cycle의 index는 0부터 n - 현재 싸이클 cycle까지 접근한다.
def bubblesort(data):
    #data가 len(data)개 일때 cycle은 len(data)-1 반복한다.
    for cycle in range(1,len(data)):#data가 4개면 [1,2,3] 으로 3번반복이다.
        swap = False
        #index는 0부터 len(data) - 현재cycle 을 뺀곳까지 접근
        for index in range(len(data)-cycle):
            #인덱스와 옆 인덱스를 비교후 큰값이면
            if data[index] > data[index+1]:
                #데이터를 바꿔준다.
                data[index],data[index+1] = data[index+1],data[index]
                #데이터가 바뀌었으면 true 반환 
                swap = True
        #사이클에서 swap이 한번도 일어나지 않았다면 정렬이 됬기에 cycle을 그만 돈다.
        if swap == False:
            break
    return data


#test code
import random

data_list = random.sample(range(100), 50)
print (bubblesort(data_list))